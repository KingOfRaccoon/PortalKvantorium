package com.kingofraccoon.portalkvantorium.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.kingofraccoon.portalkvantorium.Event
import com.kingofraccoon.portalkvantorium.R

private const val ARG_PARAM1 = "param1"

class MoreEventFragment : Fragment() {
    var param1: Event? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_more_event, container, false)

        var title :TextView = root.findViewById(R.id.event_title)
       // title = param1?.title

        val date = param1?.date
        val date_end = param1?.date
        val time = param1?.time
        val text = param1?.text



        return root
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Event) =
            MoreEventFragment().apply {
                this.param1=param1
            }
    }
}