package com.kingofraccoon.portalkvantorium.Fragment

import android.content.Intent
import android.net.Uri
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
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.kingofraccoon.portalkvantorium.Event
import com.kingofraccoon.portalkvantorium.MainActivityLoadPhoto
import com.kingofraccoon.portalkvantorium.R
import com.kingofraccoon.portalkvantorium.adapters.EventAdapter
import com.kingofraccoon.portalkvantorium.adapters.SimpleItemTouchHelperCallback
import java.time.LocalDate
import java.util.*
import androidx.fragment.app.FragmentManager as FragmentManager1

class EventsFragment: Fragment() {

    companion object{
        val tag = "fragmentevent"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.events_fragment, container, false)
        val recyclerView : RecyclerView = view.findViewById(R.id.recycler_event)
        val fab : FloatingActionButton = view.findViewById(R.id.photo)
        fab.setOnClickListener {
            requireActivity().startActivity(Intent(requireContext(), MainActivityLoadPhoto::class.java))
        }
        val eventAdapter = EventAdapter(requireFragmentManager())
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = eventAdapter
        eventAdapter.addEvent(
            Event(
                "dlfsdkfl",
                 "dlfdsf;sdlfsd;",
                "${Date().date}",
                "13.00"
            )
        )
        eventAdapter.addEvent(
            Event(
                "dlfsdkfl",
                "dlfdsf;sdlfsd;",
                "${Date().date}",
                "13.00"
            )
        )
        val callback = SimpleItemTouchHelperCallback(eventAdapter)
        ItemTouchHelper(callback).attachToRecyclerView(recyclerView)
        return view
    }
}