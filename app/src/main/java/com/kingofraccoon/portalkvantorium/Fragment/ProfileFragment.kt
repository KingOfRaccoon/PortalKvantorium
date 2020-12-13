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
import com.google.android.material.tabs.TabLayoutMediator
import com.kingofraccoon.portalkvantorium.R
import com.kingofraccoon.portalkvantorium.adapters.ViewPager2FragmentAdapter
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
        nameUser.text = "Филонов Сергей Сергеевич"
        dateUser.text = "14-02-2003"
        sexUser.text = "Мужской"

/*        val viewPager2 : ViewPager2 = view.findViewById(R.id.view_pager2)
        viewPager2.adapter = ViewPagerAdapter(this)*/

        val tabs : TabLayout = view.findViewById(R.id.tab_layout)
        val viewPager2 : ViewPager2 = view.findViewById(R.id.view_pager2)
        viewPager2.adapter = ViewPager2FragmentAdapter(this)
        TabLayoutMediator(tabs, viewPager2){ tab: TabLayout.Tab, i: Int ->
            when(i){
                0 -> tab.text = "Навыки"
                1 -> tab.text = "Достижения"
            }
            viewPager2.currentItem = i
        }.attach()
        viewPager2.currentItem = 0

        return view
    }
}