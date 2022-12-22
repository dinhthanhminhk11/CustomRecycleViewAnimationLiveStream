package com.example.spendingmanagement.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.spendingmanagement.R
import com.example.spendingmanagement.model.Widget
import java.lang.ref.WeakReference

class WidgetViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val widgetName: TextView? = itemView.findViewById(R.id.widget_name)
    private var weakAdapter: WeakReference<WidgetAdapter>? = null

    fun bind(widget: Widget, adapter: WidgetAdapter) {
        weakAdapter = WeakReference(adapter)

        widgetName?.text = widget.name
        widgetName?.setOnClickListener {
            weakAdapter?.get()?.removeWidget(widget)
        }
    }
}