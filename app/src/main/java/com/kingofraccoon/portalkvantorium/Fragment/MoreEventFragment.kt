package com.kingofraccoon.portalkvantorium.Fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.kingofraccoon.portalkvantorium.Event
import com.kingofraccoon.portalkvantorium.R
import com.kingofraccoon.portalkvantorium.User

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

        val title :TextView = root.findViewById(R.id.event_title)
        val date : TextView =  root.findViewById(R.id.event_date)
        val date_end : TextView =  root.findViewById(R.id.event_date_end)
        val time : TextView =  root.findViewById(R.id.event_time)
        val text : TextView =  root.findViewById(R.id.text)
        val image : ImageView = root.findViewById(R.id.event_icon)

        title.setText(param1?.title)
        date.setText(param1?.date)
        date_end.setText(param1?.date_end)
        time.setText(param1?.time)
        text.setText(param1?.text)
        image.setImageResource(param1?.image!!)


        val button : Button = root.findViewById(R.id.take_part)
        button.setOnClickListener {
            button.setBackgroundColor(Color.rgb(255, 194, 186))
            button.setText("ВЫ ЗАРЕГИСТРИРОВАНЫ")
            User.prog += 5
            User.model += 5
            User.konstr += 5
            button.isClickable = false
        }


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