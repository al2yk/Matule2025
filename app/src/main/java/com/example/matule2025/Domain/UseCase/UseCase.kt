package com.example.matule2025.Domain.UseCase

import com.example.networklib.data.models.CategoryResponse
import com.example.networklib.data.models.AuthRequest
import com.example.networklib.data.models.AuthResponse
import com.example.networklib.data.models.NetworkResult
import com.example.networklib.data.models.ProductResponse
import com.example.networklib.data.models.ProfileRequest
import com.example.networklib.data.models.ProfileResponse
import com.example.networklib.data.models.RegistationResponse
import com.example.networklib.data.models.RegistrationRequest
import com.example.networklib.domain.repository.Repository

class UseCase(private val Repository: Repository) {
    suspend operator fun invoke(email: String, password: String): NetworkResult<AuthResponse> {
        return Repository.login(AuthRequest(email, password))
    }

    suspend operator fun invoke(
        email: String,
        password: String,
        confirmPassword: String,
        name: String,
        surname: String,
        lastname: String,
        dateBithday: String,
        gender: String,
        telegram: String
    ): NetworkResult<RegistationResponse> {
        return Repository.registration(
            RegistrationRequest(
                email,
                password,
                confirmPassword,
                name,
                surname,
                gender,
                telegram,
                dateBithday,
                lastname
            )
        )
    }


    suspend fun GetCategories():NetworkResult<CategoryResponse>{
        return Repository.getCategory()
    }

    suspend fun getProduct():NetworkResult<ProductResponse>{
        return Repository.getProduct()
    }

    suspend fun getProfile(id:String):NetworkResult<ProfileResponse>{
        return Repository.getProfile(ProfileRequest(id))
    }
}
