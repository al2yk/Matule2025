package com.example.matule2025.Domain.Repository

import android.content.Context
import android.content.SharedPreferences

object UserRepository {
    private lateinit var actSystem: SharedPreferences

     fun init(context: Context){
        actSystem = context.getSharedPreferences("actSystem",Context.MODE_PRIVATE)
    }

     var UserID:String
        get() = actSystem.getString("UserID", "")!!
        set(value) = actSystem.edit().putString("UserID",value).apply()

     var act:Int
        get() = actSystem.getInt("act", 0)
        set(value) = actSystem.edit().putInt("act",value).apply()


     var Token:String
        get() = actSystem.getString("Token", "")!!
        set(value) = actSystem.edit().putString("Token",value).apply()
}
