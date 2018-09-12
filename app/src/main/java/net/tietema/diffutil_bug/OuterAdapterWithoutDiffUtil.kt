package net.tietema.diffutil_bug

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class OuterAdapterWithoutDiffUtil(val onBoxClicked: (Box) -> Unit) : RecyclerView.Adapter<SectionViewHolder>(){

    var items: List<Section> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): SectionViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_section, p0, false)
        return SectionViewHolder(view, onBoxClicked)
    }

    override fun onBindViewHolder(p0: SectionViewHolder, p1: Int) {
        p0.adapter.submitList(items[p1].subList)
    }
}

