package com.kingofraccoon.portalkvantorium

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kingofraccoon.portalkvantorium.Fragment.ChatFragment
import com.kingofraccoon.portalkvantorium.Fragment.EventsFragment
import com.kingofraccoon.portalkvantorium.Fragment.ProfileFragment
import com.kingofraccoon.portalkvantorium.Fragment.ScheduleFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bnv)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.timetable -> supportFragmentManager.setFragment(ScheduleFragment(), ScheduleFragment.tag)

                R.id.fest -> supportFragmentManager.setFragment(EventsFragment(), EventsFragment.tag)

                R.id.chat -> supportFragmentManager.setFragment(ChatFragment(), ChatFragment.tag)

                R.id.profile -> supportFragmentManager.setFragment(ProfileFragment(), ProfileFragment.tag)
            }
            return@setOnNavigationItemSelectedListener true
        }

        val actBar = SpannableString(title)
        actBar.setSpan(ForegroundColorSpan(Color.rgb(78, 78, 78)), 0, title.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        supportActionBar?.setTitle(actBar)
    }
    fun FragmentManager.setFragment(fragment: Fragment, tag:String){
        val frag = this.findFragmentByTag(tag)
        if (frag != null) {
            this.beginTransaction()
                    .replace(R.id.frame, fragment)
                    .commit()
        }
        else{
            this.beginTransaction()
                    .add(R.id.frame, fragment, tag)
                    .addToBackStack(null)
                    .commit()
        }
    }
}