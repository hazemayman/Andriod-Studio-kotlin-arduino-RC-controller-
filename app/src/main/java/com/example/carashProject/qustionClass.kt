package com.example.carashProject
import android.app.Activity
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast

class qustionClass:Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.questionmark)
        val DisplayMetrics = DisplayMetrics();
        windowManager.defaultDisplay.getMetrics(DisplayMetrics)
        var width = DisplayMetrics.widthPixels
        var height = DisplayMetrics.heightPixels
        window.setLayout((width *0.8).toInt(),(height*0.8).toInt())
        Toast.makeText(this, "Credit", Toast.LENGTH_SHORT).show()
    }
}