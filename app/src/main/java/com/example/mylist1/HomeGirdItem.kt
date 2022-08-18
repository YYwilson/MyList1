package com.example.mylist1

import android.security.identity.AccessControlProfileId

class HomeGirdItem (imgId: Int, name: String){
    private var imgId: Int = 0
    private var name:  String = ""

    init{
        this.imgId =  imgId
        this.name = name
    }

    fun getImgId(): Int{
        return imgId
    }

    fun getName(): String{
        return name
    }

}