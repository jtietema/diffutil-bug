package net.tietema.diffutil_bug

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView


class Fixed : AppCompatActivity() {

    lateinit var adapter: OuterAdapterWithoutDiffUtil
    var data = Section((0..12).map { Box(it) })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val recyclerView = findViewById<RecyclerView>(R.id.list)
        adapter = OuterAdapterWithoutDiffUtil { clickedBox ->
            data = data.copy(subList = data.subList.map {
                it.copy(clicked = clickedBox.id == it.id)
            })
            adapter.items = listOf(data)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter.items = listOf(data)

    }
}