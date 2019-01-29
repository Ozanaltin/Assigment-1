package com.example.assignment1

import android.content.Context
import android.widget.Toast
import Color

fun Context.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
}

fun Any.getRandomColor(): Color {
    val size = Color.values().size
    return Color.values()[(Math.random() * size).toInt()]
}