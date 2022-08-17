package com.example.mylist1

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView

class MainActivity : AppCompatActivity() {

    private val mTag = MainActivity::class.java.name
    val myList = ArrayList<PostalCode>()
    //val myList2 = ArrayList<CityDetail>()
    private var adapter : ArrayAdapter<String> ?= null
    private var myAdapter : ItemAdapter ?= null
    private var context: Context?=null

    companion object{
        @JvmStatic var myDetailList = ArrayList<CityDetail>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        context = applicationContext

        val listview = findViewById<ListView>(R.id.liseview1)
        val btnadd = findViewById<Button>(R.id.btnAdd)

        val item1 = PostalCode("Taipei","100",  200000, 2000)
        myList.add(item1)
        val item2 = PostalCode("Taichung","400",  100000, 1000)
        myList.add(item2)
        val item3 = PostalCode("Tainan","700", 300000, 3000)
        myList.add(item3)




        //adapter = ArrayAdapter( this, android.R.layout.simple_list_item_1, myList)
        myAdapter = ItemAdapter(this,R.layout.listview_item, myList)
        //listview.adapter = adapter
        listview.adapter = myAdapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
            Log.e(mTag,"click $i")

            myDetailList.clear()

            val detailItem1 = CityDetail("城市", myList[i].city)
            myDetailList.add(detailItem1)
            val detailItem2 = CityDetail("區號", myList[i].code)
            myDetailList.add(detailItem2)
            val detailItem3 = CityDetail("人口", myList[i].people.toString())
            myDetailList.add(detailItem3)
            val detailItem4 = CityDetail("面績", myList[i].area.toString())
            myDetailList.add(detailItem4)

            val intent = Intent(context, DetailActivity::class.java)
            startActivity(intent)
        }


    }



}