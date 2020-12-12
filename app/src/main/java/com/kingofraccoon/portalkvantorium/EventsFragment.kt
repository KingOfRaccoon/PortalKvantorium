package com.kingofraccoon.portalkvantorium

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kingofraccoon.portalkvantorium.adapters.EventAdapter
import com.kingofraccoon.portalkvantorium.adapters.SimpleItemTouchHelperCallback
import java.time.LocalDate

class EventsFragment: Fragment() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.events_fragment, container, false)
        val recyclerView : RecyclerView = view.findViewById(R.id.recycler_event)
        val eventAdapter = EventAdapter()
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = eventAdapter
        eventAdapter.addEvent(
            Event(
                "dlfsdkfl",
                "dlfdsf;sdlfsd;",
                "${LocalDate.now()}",
                "13.00"
            )
        )
        val callback = SimpleItemTouchHelperCallback(eventAdapter)
        ItemTouchHelper(callback).attachToRecyclerView(recyclerView)
        return view
    }
}