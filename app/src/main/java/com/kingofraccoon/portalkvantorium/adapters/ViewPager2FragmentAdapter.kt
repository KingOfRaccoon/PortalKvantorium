package com.kingofraccoon.portalkvantorium.adapters

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kingofraccoon.portalkvantorium.Fragment.AchievementFragment
import com.kingofraccoon.portalkvantorium.Fragment.SkillFragment

class ViewPager2FragmentAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        if (position == 0)
            return SkillFragment()
        else
            return AchievementFragment()
    }
}