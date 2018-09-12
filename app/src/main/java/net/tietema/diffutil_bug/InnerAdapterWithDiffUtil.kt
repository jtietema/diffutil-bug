package net.tietema.diffutil_bug

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class InnerAdapterWithDiffUtil(val onBoxClicked: (Box) -> Unit) : ListAdapter<Box, BoxViewHolder>(object : DiffUtil.ItemCallback<Box>() {
    override fun areItemsTheSame(p0: Box, p1: Box): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: Box, p1: Box): Boolean {
        return p0 == p1
    }
}){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BoxViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_box, p0, false)
        return BoxViewHolder(view)
    }

    override fun onBindViewHolder(p0: BoxViewHolder, p1: Int) {
        p0.idTextView.text = "Id: ${getItem(p1).id}"
        p0.statusTextView.text = if (getItem(p1).clicked) "Clicked" else "Not clicked"
        p0.itemView.setOnClickListener {
            onBoxClicked(getItem(p1))
        }
    }

}

class BoxViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val idTextView: TextView = itemView.findViewById(R.id.box_id)
    val statusTextView: TextView = itemView.findViewById(R.id.box_status)

}

