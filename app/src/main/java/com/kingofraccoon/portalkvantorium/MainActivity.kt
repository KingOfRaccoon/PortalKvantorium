package com.kingofraccoon.portalkvantorium

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView

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

                R.id.profile -> {}
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
    fun FragmentManager.setFragment(fragment: Fragment){
        this.beginTransaction()
            .add(R.id.frame, fragment)
            .addToBackStack(null)
            .commit()
    }
}