package com.example.matule2025

import com.example.uikit.Input.OTPBox
import com.example.uikit.Input.TextFieldAndTitle
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.matule2025.ui.theme.Matule2025Theme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Matule2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                    Column(
                        modifier = Modifier
                            .padding(horizontal = 20.dp, vertical = 5.dp)
                            .fillMaxSize()
                    ) {
                        var check by remember { mutableStateOf(false) }
                        var enabled by remember { mutableStateOf(false) }
                        var text by remember { mutableStateOf("") }
                        var text1 by remember { mutableStateOf("") }
                        var text2 by remember { mutableStateOf("") }
                        /* var count by remember { mutableStateOf(1) }

                         Counter(count) { newCount ->
                             count = newCount
                         }*/
                        /*
                                                var check by remember { mutableStateOf(false) }

                                                CheckBox(check){ newcheck->
                                                    check = newcheck
                                                }*/
                        /* var check by remember { mutableStateOf(false) }
                         var enabled by remember { mutableStateOf(true) }
                         Primary("Рубашка воскресенье для маашинного вязания","Мужская одежда","300",check,enabled){newcheck->
                             check=newcheck

                         }*/
                        /*
                                                Chips("Популярные",check){newcheck->
                                                    check=newcheck
                                                }*/
/*
                        Cart("500"){}
                        LogIn(VKonClick = {}, YanOnClick = {})

                        Message{}
                        Filter {  }

                        MenuButton("1")*/
/*
                        MedicalCard("","Иван","Иванович","ivanov.ivanych@mail.ru"){}
                        MedicalCardTwo("","Иван","Иванович", check){newcheck->
                            check = newcheck
                        }
                        MedicalCardTwo("","Иван","Иванович", check){newcheck->
                            check = newcheck
                        }*/

                        TextFieldAndTitle("Имя",text){new->
                            text=new
                        }
                        OTPBox(text){new->
                            text=new
                        }

                    }
                }
            }
        }
    }
}