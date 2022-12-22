package com.example.spendingmanagement

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spendingmanagement.adapter.CustomItemAnimator
import com.example.spendingmanagement.adapter.WidgetAdapter
import com.example.spendingmanagement.model.Widget

class MainActivity : AppCompatActivity() {
    var adapter: WidgetAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView by lazy { findViewById<RecyclerView>(R.id.recyclerView) }
        val click: Button by lazy { findViewById<Button>(R.id.click) }

        recyclerView?.layoutManager =
            LinearLayoutManager(baseContext, LinearLayoutManager.VERTICAL, false)
        adapter = WidgetAdapter()
        recyclerView?.adapter = adapter
        recyclerView?.itemAnimator = CustomItemAnimator()

        click?.setOnClickListener {
            adapter?.addWidget(Widget((Math.random() * 1000).toString()))
        }
    }
}