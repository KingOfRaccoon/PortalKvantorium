package com.kingofraccoon.portalkvantorium.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.kingofraccoon.portalkvantorium.R


class ProfileFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        val nameUser: TextView = view.findViewById(R.id.full_name)
        val dateUser: TextView = view.findViewById(R.id.about)
        val sexUser: TextView = view.findViewById(R.id.sex)
        nameUser.text = ""
        dateUser.text = "14-02-1981"
        sexUser.text = "Мужской"
        return view
    }
}