package com.example.carashProject

import android.app.Activity
import android.app.AlertDialog
import android.os.Bundle
import android.util.DisplayMetrics
import android.widget.Toast

import android.content.Context
import kotlinx.android.synthetic.main.button_ticket.view.*
import kotlinx.android.synthetic.main.settings.*

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.edit_text_layout.*
import kotlinx.android.synthetic.main.edit_text_layout.view.*


var condition = false
var listOfKeys = ArrayList<keys>()
class settings:Activity(){

    var Adapter:keysAdaptor ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)
        if(condition){

        }else{
            loadKeyToTheList()
            condition = true
        }
        Adapter = keysAdaptor(listOfKeys,this)
        gridSettings.adapter = Adapter
        var DisplayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(DisplayMetrics)
        var width:Int =  DisplayMetrics.widthPixels
        var height:Int = DisplayMetrics.heightPixels
        window.setLayout((width * 0.85).toInt() , (height * 0.85).toInt())
        Toast.makeText(this, "Setup", Toast.LENGTH_SHORT).show()
//        val builder = AlertDialog.Builder(contex).create()
//
//
//        // Display the alert dialog on app interface
//        // Set the alert dialog title
//        builder.setTitle("determine ${keysView.keyName} value")
//
//        // Display a message on alert dialog
//        builder.setMessage("the desired value : ")
//
//        // Set a positive button and its click listener on alert dialog
//        builder.setButton(AlertDialog.BUTTON_NEGATIVE,"cancel" , {
//                _,_ -> Toast.makeText(contex, "pressed Negative button", Toast.LENGTH_SHORT).show()
//        })
//        builder.setButton(AlertDialog.BUTTON_POSITIVE,"save" , {
//                _,_ -> Toast.makeText(contex, "pressed positive button", Toast.LENGTH_SHORT).show()
//        })
//        builder.setButton(AlertDialog.BUTTON_NEUTRAL,"Maybe" , {
//                _,_ -> Toast.makeText(contex, "pressed neutral button", Toast.LENGTH_SHORT).show()
//        })
//        builder.show()
    }
    fun loadKeyToTheList() {
        listOfKeys.add(keys("left-Up", "Q", R.drawable.left_up))
        listOfKeys.add(keys("Up", "U", R.drawable.up))
        listOfKeys.add(keys("right-up", "E", R.drawable.right_up))
        listOfKeys.add(keys("Left", "L", R.drawable.left))
        listOfKeys.add(keys("Stop", "S", R.drawable.stop))
        listOfKeys.add(keys("Right", "R", R.drawable.right))
        listOfKeys.add(keys("left-down", "Z", R.drawable.left_down))
        listOfKeys.add(keys("Down", "D", R.drawable.down))
        listOfKeys.add(keys("right-down", "c", R.drawable.right_down))
        listOfKeys.add(keys("num 1", "1", R.drawable.num_1))
        listOfKeys.add(keys("num 2", "2", R.drawable.num_2))
        listOfKeys.add(keys("num 3", "3", R.drawable.num_3))
        listOfKeys.add(keys("num 4", "4", R.drawable.num_4))
        listOfKeys.add(keys("num 5", "5", R.drawable.num_5))
        listOfKeys.add(keys("Temp", "T", R.drawable.temp))
        listOfKeys.add(keys("Maze", "M", R.drawable.maze))
    }
    inner class keysAdaptor:BaseAdapter{
        var listOfKeysLocal = ArrayList<keys>()
        var contex:Context ?= null
        constructor( listOfKeys:ArrayList<keys> , contex:Context){
            listOfKeysLocal = listOfKeys
            this.contex = contex

        }
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            val key = listOfKeysLocal[p0]
            val inflator = contex!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val keysView = inflator.inflate(R.layout.button_ticket , null)
            keysView.keyName.text = key.keyName
            keysView.sendedValue.text = key.sendedValue
            keysView.keyImage.setImageResource(key.keyImage!!)

            keysView.setOnClickListener {

                val editTextDialog = AlertDialog.Builder(contex).create()
                editTextDialog.setTitle("Detremine value")
                editTextDialog.setMessage("please enter yourh desired Value")
                val editView = inflator.inflate(R.layout.edit_text_layout , null)
                editView.inputText.hint = keysView.sendedValue.text.toString()
                editTextDialog.setView(editView)
                //editTextDialog.inputText.hint = "d"
                editTextDialog.setButton(AlertDialog.BUTTON_POSITIVE , "save",{
                    _,_ ->
                    val text = editTextDialog.inputText.text
                    update_key_list(p0,text.toString())
                    Toast.makeText(contex,"changed", Toast.LENGTH_SHORT).show()
                })
                editTextDialog.setButton(AlertDialog.BUTTON_NEGATIVE , "cancel",{
                        _,_ ->
                })
                editTextDialog.show()



            }
            return keysView
        }

        override fun getItem(p0: Int): Any {
            return listOfKeysLocal[p0]

        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()

        }

        override fun getCount(): Int {

            return listOfKeysLocal.size
        }

    }
    fun update_key_list(index:Int,value:String){
        listOfKeys[index].sendedValue = value
        Adapter!!.notifyDataSetChanged()
    }
}