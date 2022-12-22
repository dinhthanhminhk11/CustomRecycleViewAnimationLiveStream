package com.example.spendingmanagement.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.spendingmanagement.R
import com.example.spendingmanagement.model.Widget

class WidgetAdapter(private val widgets: MutableList<Widget> = mutableListOf()) :
    RecyclerView.Adapter<WidgetViewHolder>() {

    override fun getItemCount(): Int = widgets.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WidgetViewHolder =
        WidgetViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.widget_item, parent, false)
        )

    override fun onBindViewHolder(holder: WidgetViewHolder, position: Int) {
        if (position < 0 || position >= widgets.size) return
        val widget = widgets[position]
        when (holder) {
            is WidgetViewHolder -> {
                holder.bind(widget, this)
            }
        }
    }

    fun addWidget(widget: Widget) {
        widgets.add(0, widget)
        notifyItemInserted(0)
    }

    fun removeWidget(widget: Widget) {
        val position = widgets.indexOf(widget)
        widgets.removeAt(position)
        notifyItemRemoved(position)
    }
}