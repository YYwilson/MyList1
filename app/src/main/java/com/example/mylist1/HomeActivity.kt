package com.example.mylist1

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    private val mTag = HomeActivity::class.java.name
    private var appList = ArrayList<HomeGirdItem>()
    private var homeGridItemAdapter: HomeGridItemAdapter? = null
    private var context: Context? = null

    companion object {
        @JvmStatic
        var myDetailList = ArrayList<CityDetail>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        context = applicationContext

        var gridview = findViewById<GridView>(R.id.gridViewHome)

        var item0 = HomeGirdItem(R.drawable.outline_build_black_48, "Build")
        appList.add(item0)

        var item1 = HomeGirdItem(R.drawable.outline_pets_black_48, "Pets")
        appList.add(item1)

        var item2 = HomeGirdItem(R.drawable.outline_thumb_up_black_48, "Thumb")
        appList.add(item2)

        homeGridItemAdapter = HomeGridItemAdapter(context, R.layout.activity_home_item, appList)
        gridview!!.adapter = homeGridItemAdapter

        gridview.setOnItemClickListener { adapterView, view, i, l ->
            Log.e(mTag,"click ${appList[i].getName()}")

            when (i)
            {
                0->{
                  showDialog()
                }
                1->{
                    showDialog()
                }
                2->{
                    showDialog()
                }
            }
        }
    }

    override fun onBackPressed() {
        Log.e(mTag,"onBackPressed")
        super.onBackPressed()
    }

    private fun showDialog(){

        val promptView = View.inflate(context,R.layout.confirm_dialog,null)
        val alertDialogBuilder=AlertDialog.Builder(this).create()
        alertDialogBuilder.setView(promptView)

        val textViewMsg = promptView.findViewById<TextView>(R.id.textViewDialog)
        val btnCancel = promptView.findViewById<TextView>(R.id.btnDialogCancel)
        val btnConfirm = promptView.findViewById<TextView>(R.id.btnDialogConfirm)

        textViewMsg.text="對話方塊"
        btnCancel.text="取消"
        btnConfirm.text="確認"

        alertDialogBuilder.setCancelable(false)
        btnCancel!!.setOnClickListener {
            alertDialogBuilder.dismiss()

        }
        btnConfirm!!.setOnClickListener{
            alertDialogBuilder.dismiss()
        }
        alertDialogBuilder.show()
    }

}