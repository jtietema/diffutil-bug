package net.tietema.diffutil_bug

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class OuterAdapterWithDiffUtil(val onBoxClicked: (Box) -> Unit) : ListAdapter<Section, SectionViewHolder>(object : DiffUtil.ItemCallback<Section>() {


    override fun areItemsTheSame(p0: Section, p1: Section): Boolean {
        return p0.id == p1.id
    }

    override fun areContentsTheSame(p0: Section, p1: Section): Boolean {
        return p0 == p1
    }

}){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SectionViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_section, p0, false)
        return SectionViewHolder(view, onBoxClicked)
    }

    override fun onBindViewHolder(p0: SectionViewHolder, p1: Int) {
        p0.adapter.submitList(getItem(p1).subList)
    }
}


class SectionViewHolder(itemView: View, onBoxClicked: (Box) -> Unit) : RecyclerView.ViewHolder(itemView) {

    val adapter: InnerAdapterWithDiffUtil

    init {
        val recyclerView = itemView.findViewById<RecyclerView>(R.id.inner_list)
        adapter = InnerAdapterWithDiffUtil(onBoxClicked)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(itemView.context, LinearLayoutManager.HORIZONTAL, false)
    }

}