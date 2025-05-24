package com.example.matule2025.Presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.matule2025.Di.networkModule
import com.example.matule2025.Domain.Repository.UserRepository
import com.example.matule2025.Presentation.navigation.Navigation
import com.example.networklib.data.network.AndroidNetworkMonitor
import com.example.uikit.UI.Matule2025UiKit
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.GlobalContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    private lateinit var networkState:AndroidNetworkMonitor
    private val _isOnline = MutableStateFlow(false
    )
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


       if (GlobalContext.getOrNull()==null){
           //нужно запустить коин
           startKoin {
               androidContext(this@MainActivity)
               modules(networkModule)
           }
       }

        enableEdgeToEdge()

        networkState = AndroidNetworkMonitor(this)
        _isOnline.value = networkState.isConnected()


        UserRepository.init(this)
        setContent {
            val isOnline by _isOnline.collectAsState()

            Matule2025UiKit {
                MaterialTheme {
                    Scaffold(modifier = Modifier.fillMaxSize()) {
                        Navigation(isOnline)
                    }
                }

            }
        }

        lifecycleScope.launch {
            while (true){
                _isOnline.value = networkState.isConnected()
                delay(2000)
            }
        }
    }
}

