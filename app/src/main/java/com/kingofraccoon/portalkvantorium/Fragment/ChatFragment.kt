package com.kingofraccoon.portalkvantorium.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestoreException
import com.kingofraccoon.portalkvantorium.R
import com.kingofraccoon.portalkvantorium.adapters.CustomListAdapter
import com.kingofraccoon.portalkvantorium.firestore.FireStore

class ChatFragment: Fragment() {
    companion object{
        val tag = "fragmentchat"
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.chat_fragment, container, false)
        val listView : ListView = view.findViewById(R.id.list)
        val listAdapter = CustomListAdapter(requireContext(), mutableListOf())
        listView.adapter = listAdapter
        FireStore().fireStore.collection("chat")
                .document("chat")
                .addSnapshotListener(object : EventListener<DocumentSnapshot>{
                    override fun onEvent(value: DocumentSnapshot?, error: FirebaseFirestoreException?) {
                        listAdapter.setList((value?.get("mes") as Array<String>).toMutableList())
                    }
                })


        return view
    }
}