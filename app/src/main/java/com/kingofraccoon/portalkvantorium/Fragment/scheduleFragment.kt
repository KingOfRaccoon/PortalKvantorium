package com.kingofraccoon.portalkvantorium.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment

class ScheduleFragment: Fragment(){
    companion object{
        val tag = "schedule"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return WebView(requireContext()).apply { loadUrl("file:///android_asset/index.html") }
    }
}
