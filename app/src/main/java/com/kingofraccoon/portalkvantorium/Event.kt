package com.kingofraccoon.portalkvantorium

class Event(){
    var title = ""
    var text = ""
    var date = ""
    var time = ""


    constructor(
        title: String,
        text: String,
        date: String,
        time: String
    ): this(){
        this.title = title
        this.text = text
        this.date = date
        this.time = time
    }
}