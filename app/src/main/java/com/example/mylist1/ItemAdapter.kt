package com.example.mylist1

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class ItemAdapter(context: Context?, resource: Int, objects: ArrayList<PostalCode>):
    ArrayAdapter<PostalCode>(context as Context, resource, objects) {

        private val layoutResourceId: Int = resource
        private var inflater: LayoutInflater=context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        private val items: ArrayList<PostalCode> =  objects
        private val mContext = context

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): PostalCode {
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

        val postalCode = items[position]
        holder.itemCity.text = postalCode.city
        holder.itemCode.text = postalCode.code

        return view
    }

    class ViewHolder (view: View) {
        var itemCity: TextView = view.findViewById(R.id.textViewCity)
        var itemCode: TextView = view.findViewById(R.id.textViewCode)

    }




}
