package com.kingofraccoon.portalkvantorium

import android.net.Uri

class Event(){
    var title = ""
    var text = ""
    var date = ""
    var time = ""
    lateinit var uri: Uri

    constructor(
        title: String,
        text: String,
        date: String,
        time: String,
    ): this(){
        this.title = title
        this.text = text
        this.date = date
        this.time = time
    }
}