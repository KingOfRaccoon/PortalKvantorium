package com.kingofraccoon.portalkvantorium.Fragment

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.EventListener
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.QuerySnapshot
import com.kingofraccoon.portalkvantorium.R
import com.kingofraccoon.portalkvantorium.adapters.CustomListAdapter
import com.kingofraccoon.portalkvantorium.firestore.FireStore
import java.lang.StringBuilder
import java.util.*

class ChatFragment: Fragment() {
    var count = 0
    companion object{
        val tag = "fragmentchat"
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.chat_fragment, container, false)
        val listView : ListView = view.findViewById(R.id.list)
        val listAdapter = CustomListAdapter(requireContext(), mutableListOf())
        val button : ImageButton = view.findViewById(R.id.send)
        val editText : EditText = view.findViewById(R.id.add_mes)
        listView.adapter = listAdapter
        FireStore().firebase.getReference("chat")
                .addChildEventListener(object : ChildEventListener {
                    override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                        listAdapter.addString(snapshot.value.toString())
                        view.findViewById<ProgressBar>(R.id.progress).visibility = View.GONE

                    }

                    override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                        TODO("Not yet implemented")
                    }

                    override fun onChildRemoved(snapshot: DataSnapshot) {
                        TODO("Not yet implemented")
                    }

                    override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {
                        TODO("Not yet implemented")
                    }

                    override fun onCancelled(error: DatabaseError) {
                        TODO("Not yet implemented")
                    }
                })
        button.setOnClickListener {
            if (editText.text.isNotBlank()) {
                FireStore().firebase.getReference("chat")
                        .push()
                        .setValue(editText.text.toString())
                //push()
                editText.text.clear()
            }
        }
        return view
    }
}