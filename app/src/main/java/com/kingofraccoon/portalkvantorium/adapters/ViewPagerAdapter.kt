package com.kingofraccoon.portalkvantorium.adapters

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.kingofraccoon.portalkvantorium.Fragment.AchievementFragment
import com.kingofraccoon.portalkvantorium.Fragment.SkillFragment
import com.kingofraccoon.portalkvantorium.R

private val TAB_TITLES = arrayOf(
    R.string.tab_text_1,
    R.string.tab_text_2
)
class ViewPagerAdapter(private val context: Context, fm: FragmentManager):
    FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {

        return when (position){
            0 -> SkillFragment()
            else -> AchievementFragment()}
    }
    override fun getPageTitle(position: Int): CharSequence {
        return context.resources.getString(TAB_TITLES[position])
    }
/*
class ViewPagerAdapter (fragment: Fragment): FragmentStateAdapter(fragment){
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        if (position == 0)
            return SkillFragment()
        else
            return AchievementFragment()
    }
*/

    override fun getCount(): Int = 2
}