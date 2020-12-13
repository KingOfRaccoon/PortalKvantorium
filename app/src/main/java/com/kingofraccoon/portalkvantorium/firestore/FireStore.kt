package com.kingofraccoon.portalkvantorium.firestore

import android.util.Log
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import com.kingofraccoon.portalkvantorium.Event

class FireStore {
    val tag_events = "events"
    val fireStore = FirebaseFirestore.getInstance()
    val firebase = FirebaseDatabase.getInstance()

    fun writeEvent(event: Event){
        val hashMap = hashMapOf(
            "title" to event.title,
            "text" to event.text,
            "date" to event.date,
            "time" to event.time,
            "uri" to event.uri.toString()
        )
        fireStore.collection(tag_events)
            .document(event.title)
            .set(hashMap)
            .addOnSuccessListener {
                Log.d("TAG", "DocumentSnapshot successfully written!")
            }
            .addOnFailureListener {
                    e -> Log.d("TAG", "Error writing document ${e.message}")
            }

    }
}