package com.example.networklib.data.remote

import android.util.Log
import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText



class ApiServiceImpl (private val URl:String,private val client: HttpClient):ApiService{

    override suspend fun login(request: AuthRequest): AuthResponse {
        val response = client.post{
            url("$URl/api/collections/users/auth-with-password")
            setBody(request)
        }

        if (response.status.value==400){
            val er =response.bodyAsText()
            Log.d("ApiServiceImpl.Login",er)
            throw ErrorM(er)
        }

        return try {
            response.body()
        }
        catch (e:Exception){
            throw Parse(e.message.toString())
        }

    }

}
class ErrorM(mes:String):Exception(mes)
class Parse(mes:String):Exception(mes)