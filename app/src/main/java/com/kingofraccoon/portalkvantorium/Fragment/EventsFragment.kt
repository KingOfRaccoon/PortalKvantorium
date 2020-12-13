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
                "IT-Fest",
                 "Открытый межрегиональный фестиваль информационных технологий «IT-Fest» в городе Севастополе.",
                "11.12.2020",
                "13.12.2020",
                "13.00",
                R.drawable.it_fest
            )
        )
        eventAdapter.addEvent(
            Event(
                "Кванториада",
                "Международное командное соревнование, участниками которого являются школьники до 18 лет, интересующиеся инженерным творчеством и изобретательством.",
                "23.11.2020",
                "24.12.2020",
                "13.00",
                R.drawable.kvantoriada
            )
        )
        eventAdapter.addEvent(
            Event(
                "Реальный сектор",
                "Межрегиональный конкурс технологических кейсов",
                "7.12.2020",
                "23.12.2020",
                "18.00",
                R.drawable.real_sector
            )
        )
        eventAdapter.addEvent(
            Event(
                "Цифровой прорыв",
                "Хакатон бла бла бла бла бла",
                "08.12.2020",
                "24.12.2020",
                "11.00",
                R.drawable.cifra
            )
        )
        val callback = SimpleItemTouchHelperCallback(eventAdapter)
        ItemTouchHelper(callback).attachToRecyclerView(recyclerView)
        return view
    }
}