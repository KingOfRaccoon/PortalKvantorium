package com.kingofraccoon.portalkvantorium

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kingofraccoon.portalkvantorium.Fragment.EventsFragment
import com.kingofraccoon.portalkvantorium.Fragment.ProfileFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bnv)
        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.timetable -> {}

                R.id.fest -> supportFragmentManager.setFragment(EventsFragment())

                R.id.chat -> {}

                R.id.profile -> supportFragmentManager.setFragment(ProfileFragment())
            }
            return@setOnNavigationItemSelectedListener true
        }

        val actBar = SpannableString(title)
        actBar.setSpan(ForegroundColorSpan(Color.rgb(78, 78, 78)), 0, title.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
        supportActionBar?.setTitle(actBar)
    }
    fun FragmentManager.setFragment(fragment: Fragment){
        this.beginTransaction()
            .add(R.id.frame, fragment)
            .addToBackStack(null)
            .commit()
    }
}