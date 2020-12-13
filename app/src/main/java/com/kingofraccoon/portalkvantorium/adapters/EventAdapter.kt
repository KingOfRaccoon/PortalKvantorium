package com.kingofraccoon.portalkvantorium.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.kingofraccoon.portalkvantorium.Event
import com.kingofraccoon.portalkvantorium.Fragment.MoreEventFragment
import com.kingofraccoon.portalkvantorium.R

class EventAdapter(var fragmentManager: FragmentManager): RecyclerView.Adapter<EventAdapter.Companion.EventViewHolder>(), ItemTouchHelperAdapter {
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
                .inflate(R.layout.event_adapter, parent, false),
            fragmentManager
        )
    }

    override fun onBindViewHolder(holder: EventViewHolder, position: Int) {
        holder.onBind(listEvents[position])
    }

    override fun getItemCount(): Int = listEvents.size

    companion object{
        class EventViewHolder(view: View, var fragmentManager: FragmentManager) : RecyclerView.ViewHolder(view){
            val event_title : TextView = view.findViewById(R.id.event_title)
            val event_date : TextView = view.findViewById(R.id.event_date)
            val event_time : TextView = view.findViewById(R.id.event_time)
            val event_date_end : TextView = view.findViewById(R.id.event_date_end)
            val image : ImageView = view.findViewById(R.id.icon)
            val event_card : CardView = view.findViewById(R.id.event_card)

            fun onBind(event: Event){
                event_card.setOnClickListener {
                    fragmentManager.beginTransaction()
                        .add(R.id.frame, MoreEventFragment.newInstance(event))
                        .addToBackStack(null)
                        .commit()
                }
                event_title.text = event.title
                event_date.text = event.date
                event_date_end.text = event.date_end
                event_time.text = event.time
                image.setImageResource(event.image)
            }
        }
    }

    override fun onItemMove(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                listEvents = replace(listEvents, i, i+1)

            }
        }
        else{
            for (i in fromPosition downTo toPosition-1 step 1){
                listEvents = replace(listEvents, i, i+1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
    }

    override fun onItemDismiss(position: Int) {
        listEvents.removeAt(position)
        notifyItemRemoved(position)
    }
    fun replace(list: MutableList<Event>, fromPosition: Int, toPosition: Int):MutableList<Event>{
        val firstPair = list[fromPosition]
        val secondPair = list[toPosition]
        list[fromPosition] = secondPair
        list[toPosition] = firstPair
        return list
    }
}