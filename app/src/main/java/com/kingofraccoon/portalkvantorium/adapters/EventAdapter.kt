package com.kingofraccoon.portalkvantorium.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kingofraccoon.portalkvantorium.Event
import com.kingofraccoon.portalkvantorium.R

class EventAdapter: RecyclerView.Adapter<EventAdapter.Companion.EventViewHolder>(), ItemTouchHelperAdapter {
    var listEvents = mutableListOf<Event>()

    fun setList(mutableList: MutableList<Event>){
        listEvents = mutableList
        notifyDataSetChanged()
    }

    fun addEvent(event: Event){
        listEvents.add(event)
        notifyDataSetChanged()
    }

    fun addEvents(mutableList: MutableList<Event>){
        listEvents.addAll(mutableList)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventViewHolder {
        return EventViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.event_adapter, parent, false)
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.onBind(listEvents[position])
    }

    override fun getItemCount(): Int = listEvents.size

    companion object{
        class EventViewHolder(view: View) : RecyclerView.ViewHolder(view){
            val event_title : TextView = view.findViewById(R.id.event_title)
            val event_date : TextView = view.findViewById(R.id.event_date)
            val event_time : TextView = view.findViewById(R.id.event_time)

            fun onBind(event: Event){
                event_title.text = event.title
                event_date.text = event.date
                event_time.text = event.time
            }
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition){
            // свайп влево
            Log.d("Swipe", "Влево")
        }
        else{
            // свайп вправо
            Log.d("Swipe", "Вправо")
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        listEvents.removeAt(position)
        notifyItemRemoved(position)
    }
}