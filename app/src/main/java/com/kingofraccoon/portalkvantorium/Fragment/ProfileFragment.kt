package com.kingofraccoon.portalkvantorium.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TableLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.kingofraccoon.portalkvantorium.R
import com.kingofraccoon.portalkvantorium.adapters.ViewPagerAdapter


class ProfileFragment: Fragment() {

    companion object{
        val tag = "fragmentprofile"
    }

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

        val viewPagerAdapter = ViewPagerAdapter(requireContext(), requireFragmentManager())

        val tabs : TabLayout = view.findViewById(R.id.tab_layout)
        val viewPager2 : ViewPager = view.findViewById(R.id.view_pager2)

        viewPager2.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager2 as ViewPager)

        return view
    }
}