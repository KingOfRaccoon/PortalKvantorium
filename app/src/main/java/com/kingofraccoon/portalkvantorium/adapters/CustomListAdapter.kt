package com.kingofraccoon.portalkvantorium.adapters

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import com.kingofraccoon.portalkvantorium.R

class CustomListAdapter(context: Context, private var list: MutableList<String>):
        ArrayAdapter<String>(context, R.layout.support_simple_spinner_dropdown_item, list) {
    fun setList(listString: MutableList<String>){
        for (i in list.size until listString.size){
            list.add(listString[i])
            notifyDataSetChanged()
        }
    }
}