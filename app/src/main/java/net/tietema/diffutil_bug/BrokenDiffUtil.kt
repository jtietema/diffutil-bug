package net.tietema.diffutil_bug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


class BrokenDiffUtil : AppCompatActivity() {

    lateinit var adapter: OuterAdapterWithDiffUtil
    var data = Section((0..12).map { Box(it) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        adapter = OuterAdapterWithDiffUtil { clickedBox ->
            data = data.copy(subList = data.subList.map {
                it.copy(clicked = clickedBox.id == it.id)
            })
            adapter.submitList(listOf(data))
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.submitList(listOf(data))

    }
}