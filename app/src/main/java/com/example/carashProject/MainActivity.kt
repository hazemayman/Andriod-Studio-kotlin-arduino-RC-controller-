package com.example.carashProject


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.ImageView


import android.content.Intent as Intent

class MainActivity : AppCompatActivity() {
//    var listOfKeys = ArrayList<keys>()
//    var Adapter:keysAdaptor ?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        loadKeyToTheList()
//        Adapter = keysAdaptor(listOfKeys,this)
//        keySettings.adapter = Adapter
        val questionMark = findViewById<ImageView>(R.id.questionMark)
        val setting = findViewById<ImageView>(R.id.settings)


        questionMark.setOnClickListener{
            val intent = Intent(this,qustionClass::class.java)
            startActivity(intent)


        }
        setting.setOnClickListener{
            val intent = Intent(this,settings::class.java)
            startActivity(intent)

        }
    }
//    fun loadKeyToTheList() {
//        listOfKeys.add(keys("Down", "D", R.drawable.down))
//        listOfKeys.add(keys("Up", "U", R.drawable.up))
//        listOfKeys.add(keys("Left", "L", R.drawable.left))
//        listOfKeys.add(keys("Right", "R", R.drawable.right))
//        listOfKeys.add(keys("num 1", "1", R.drawable.num_1))
//        listOfKeys.add(keys("num 2", "2", R.drawable.num_2))
//        listOfKeys.add(keys("num 3", "3", R.drawable.num_3))
//        listOfKeys.add(keys("num 4", "4", R.drawable.num_4))
//        listOfKeys.add(keys("num 5", "5", R.drawable.num_5))
//        listOfKeys.add(keys("Stop", "S", R.drawable.stop))
//        listOfKeys.add(keys("Temp", "T", R.drawable.temp))
//        listOfKeys.add(keys("Maze", "M", R.drawable.maze))
//    }
//    class keysAdaptor:BaseAdapter{
//        var listOfKeysLocal = ArrayList<keys>()
//        var contex:Context ?= null
//        constructor( listOfKeys:ArrayList<keys> , contex:Context){
//            listOfKeysLocal = listOfKeys
//            this.contex = contex
//
//        }
//        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
//            val key = listOfKeysLocal[p0]
//            val inflator = contex!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//            val keysView = inflator.inflate(R.layout.button_ticket , null)
//            keysView.keyName.text = key.keyName
//            keysView.sendedValue.text = key.sendedValue
//            keysView.keyImage.setImageResource(key.keyImage!!)
//            return keysView
//        }
//
//        override fun getItem(p0: Int): Any {
//            return listOfKeysLocal[p0]
//
//        }
//
//        override fun getItemId(p0: Int): Long {
//            return p0.toLong()
//
//        }
//
//        override fun getCount(): Int {
//
//            return listOfKeysLocal.size
//        }
//
//    }
}


