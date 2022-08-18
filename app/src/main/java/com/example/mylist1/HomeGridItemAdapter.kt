package com.example.mylist1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class HomeGridItemAdapter (context: Context?, resource: Int, objects: ArrayList<HomeGirdItem>):
ArrayAdapter<HomeGirdItem>(context as Context, resource, objects) {

    private val layoutResourceId: Int = resource
    private var inflater: LayoutInflater=context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    private val items: ArrayList<HomeGirdItem> =  objects
    private val mContext = context

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): HomeGirdItem {
        return items[position]
    }


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view: View
        val holder: ViewHolder
        if (convertView == null || convertView.tag == null) {
            view = inflater.inflate(layoutResourceId, null)
            holder = ViewHolder(view)

            view.tag = holder
        } else {
            view = convertView
            holder = view.tag as ViewHolder
        }

        val homeGirdItem = items[position]
        holder.icon.setImageResource(homeGirdItem.getImgId())
        holder.header.text=homeGirdItem.getName()

        return view
    }

    class ViewHolder (view: View) {
        var icon: ImageView = view.findViewById(R.id.imageViewHomeGrid)
        var header: TextView = view.findViewById(R.id.textViewHomeGird)

    }

}