package com.example.matule2025.Di

import com.example.matule2025.Presentation.viewModel.AuthViewModel
import com.example.matule2025.Presentation.viewModel.CreatePasswordViewModel
import com.example.matule2025.Presentation.viewModel.MainViewModel
import com.example.networklib.data.network.AndroidNetworkMonitor
import com.example.networklib.data.network.NetworkMonitor
import com.example.networklib.data.remote.ApiService
import com.example.networklib.data.remote.ApiServiceImpl
import com.example.networklib.data.repository.RepositoryImpl
import com.example.networklib.domain.repository.Repository
import com.example.networklib.domain.usecase.UseCase
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.androidx.compose.get
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.scope.get
import org.koin.dsl.module

val networkModule  = module {

    single<NetworkMonitor> {AndroidNetworkMonitor(get())}

    single {
        HttpClient(CIO){
            install(ContentNegotiation){
                json(
                    Json {
                        ignoreUnknownKeys =true
                        encodeDefaults = false
                        isLenient=true
                        useAlternativeNames=false
                    }
                )
            }
            defaultRequest {
                contentType(ContentType.Application.Json)
            }
            install(Logging){
                level=LogLevel.ALL
            }
            install(HttpTimeout){
                requestTimeoutMillis=15000
            }
        }
    }

    single<ApiService> { ApiServiceImpl("http://10.0.2.2:8090",get()) }

    single<Repository> { RepositoryImpl(get(),get()) }

    factory { UseCase(get()) }

    viewModel { AuthViewModel(get()) }
    viewModel { CreatePasswordViewModel(get()) }
    viewModel { MainViewModel(get()) }

}