package com.example.networklib.data.remote

import android.util.Log
import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import com.example.networklib.data.models.CategoryResponse
import com.example.networklib.data.models.ProductResponse
import com.example.networklib.data.models.ProfileRequest
import com.example.networklib.data.models.ProfileResponse
import com.example.networklib.data.models.RegistationResponse
import com.example.networklib.data.models.RegistrationRequest
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.request.url
import io.ktor.client.statement.bodyAsText
import io.ktor.http.HttpStatusCode
import io.ktor.http.isSuccess


class ApiServiceImpl(private val URl: String, private val client: HttpClient) : ApiService {

    override suspend fun login(request: AuthRequest): AuthResponse {
        val response = client.post {
            url("$URl/api/collections/users/auth-with-password")
            setBody(request)
        }

        if (!response.status.isSuccess()) {
            var errorBody = response.bodyAsText()
            Log.i("ApiServiceImpl. Login", errorBody)
            if (response.status == HttpStatusCode.BadRequest && errorBody?.contains(
                    "Failed to authenticate.",
                    ignoreCase = true
                ) == true
            ){
                throw UserIsNotFound("Нет такого пользователя")
            }
            throw ErrorM(errorBody ?: "Неизвестная ошибка")
        }


        return try {
            response.body()
        } catch (e: Exception) {
            throw Parse(e.message.toString())
        }

    }

    override suspend fun registration(request: RegistrationRequest): RegistationResponse {
        val response = client.post{
            url("$URl/api/collections/users/records")
            setBody(request)
        }

        if (response.status.value ==400){
            throw ErrorM(response.bodyAsText())
        }
        return try {
            response.body()
        }catch (e:Exception){
            throw Parse(e.message.toString())
        }
    }

    override suspend fun getcategory(): CategoryResponse {
        val response = client.get{
            url("$URl/api/collections/categories/records")

        }

        if (response.status.value==400){
            throw ErrorM(response.bodyAsText())
        }
        return try {
            response.body()
        }catch (e:Exception){
            throw Parse(e.message.toString())
        }
    }

    override suspend fun getProduct(): ProductResponse {
        val result = client.get {
            url("$URl/api/collections/product/records")
        }

        if (result.status.value==400){
            throw ErrorM(result.bodyAsText())
        }

        return try {
            result.body()
        }catch (e:Exception){
            throw Parse(e.message.toString())
        }
    }

    override suspend fun getProfile(request: ProfileRequest): ProfileResponse {
        val result = client.get {
            url("$URl/api/collections/users/records/${request.id}")
        }

        if (result.status.value==400){
            throw ErrorM(result.bodyAsText())
        }

        return try {
            result.body()
        }catch (e:Exception){
            throw Parse(e.message.toString())
        }
    }


}

class ErrorM(mes: String) : Exception(mes)
class Parse(mes: String) : Exception(mes)
class UserIsNotFound(mes: String) : Exception(mes)