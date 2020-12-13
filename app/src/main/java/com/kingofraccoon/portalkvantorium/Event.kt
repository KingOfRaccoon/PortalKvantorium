package com.kingofraccoon.portalkvantorium

import android.net.Uri

class Event(){
    var title = ""
    var text = ""
    var date = ""
    var date_end = ""
    var time = ""
    var image: Int = 0

    constructor(
        title: String,
        text: String,
        date: String,
        date_end: String,
        time: String,
        image: Int
    ): this(){
        this.title = title
        this.text = text
        this.date = date
        this.date_end = date_end
        this.time = time
        this.image = image
    }
}