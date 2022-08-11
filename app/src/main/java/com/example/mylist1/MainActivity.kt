package com.example.mylist1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private val mTag = MainActivity::class.java.name
    private val myList = ArrayList<String>()
    private val myList2 = ArrayList<PostalCode>()
    private var adapter : ArrayAdapter<String> ?= null
    private var myAdapter : ItemAdapter ?= null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listview = findViewById<ListView>(R.id.liseview1)
        val btnadd = findViewById<Button>(R.id.btnAdd)

        if (myList2.isEmpty()){
            var taipei = PostalCode("Taipei","100")
            myList2.add(taipei)
            var taichung = PostalCode("Taichung","400")
            myList2.add(taichung)
            var tainan = PostalCode("Tainan","700")
            myList2.add(tainan)
        }

        myList.add("Taipie")
        myList.add("Taichung")
        myList.add("Tainan")

        //adapter = ArrayAdapter( this, android.R.layout.simple_list_item_1, myList)
        myAdapter = ItemAdapter(this,R.layout.listview_item, myList2)
        //listview.adapter = adapter
        listview.adapter = myAdapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
            Log.e(mTag,"click $i")
            Log.e(mTag,"city ${myList2[i].city}")
        }

        btnadd.setOnClickListener{
            //myList.add("Kaohsiung")
            if (myList.isNotEmpty()) {
                myList.removeAt(0)
                if (adapter != null) {
                    adapter?.notifyDataSetChanged()
                }
            }
        }
    }
}