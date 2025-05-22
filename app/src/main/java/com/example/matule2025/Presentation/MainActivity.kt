package com.example.matule2025.Presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.example.matule2025.Di.networkModule
import com.example.matule2025.Presentation.navigation.Navigation
import com.example.matule2025.Presentation.ui.theme.Matule2025Theme
import com.example.networklib.data.network.AndroidNetworkMonitor
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {

    private lateinit var networkState:AndroidNetworkMonitor
    private val _isOnline = MutableStateFlow(false
    )
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //нужно запустить коин
        startKoin {
            androidContext(this@MainActivity)
            modules(networkModule)
        }
        enableEdgeToEdge()

        networkState = AndroidNetworkMonitor(this)
        _isOnline.value = networkState.isConnected()
        setContent {
            val isOnline by _isOnline.collectAsState()

            Matule2025Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) {

                 Navigation(isOnline)



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
                    /*
                                            TextFieldAndTitle("Имя",text){new->
                                                text=new
                                            }
                                            OTPBox(text){new->
                                                text=new
                                            }*/
                    /*
                                            MedicalCard("","Иван","Иванович","ivanov.ivanych@mail.ru"){}

                                            SpacerHeight(100)
                                            MedicalCardTwo("","Иван","Иванович", check){newcheck->
                                                check = newcheck
                                            }*/


                    /* AnalisysCard("Рубашка воскресенье для машинное вязание","16 февраля",true)*/

                    /*CardSmall("Рубашка воскресенье для машинного вязания",true,"300")*/
                    /*
                                            CardSmall2("Рубашка воскресенье для машинного вязания",true,"300")
                                            CardSmall2("Рубашка воскресенье для машинного вязания",true,"300")
                                            CardSmall2("Рубашка воскресенье для машинного вязания",true,"300")*/
                    /*
                                            val orderItems = listOf(
                                                listOf("1", "Рубашка воскресенье для машинного вязания", "300"),
                                                listOf("2", "Шорты вторник для машинного вязания", "9801")
                                            )

                                            OrderCard(
                                                num = 123,
                                                date = "12.05.2023",
                                                status = "Доставлен",
                                                items = orderItems,
                                                check ={},
                                                help = {},
                                                otmena = {}
                                            )*/
                    /*
                                            MedicalIndicatorCard(
                                                indicatorName = "Гематокрит",
                                                currentValue = "36.5",
                                                normalRange = "11.1 – 14.1",
                                                isHighlighted = true
                                            )*/

                    /*

                                            ResultTableCell("Гематокрит", 36.5,true)
                                            ResultTableCell("Гематокрит", 36.5,false)
                    */
                    /*
                                            GenderDropdownMenu()
                                            NameInputField_WithoutChangeBorder(text){new->
                                                text=new
                                            }*/
                    /*val sampleList = remember {
                        mutableStateListOf(
                            "Apple",
                            "Banana",
                            "Cherry",
                            "Date",
                            "Fig",
                            "Grape"
                        )
                    }
                    var searchText by remember { mutableStateOf("") }
                    val searchResults =
                        sampleList.filter { it.contains(searchText, ignoreCase = true) }


                    BigSearch(
                        onSearch = {text->
                            searchText=text
                        }
                    )

                    MediumSearch_WithClose(
                        onSearch = {text ->
                            searchText=text

                        }
                    )

                    LazyColumn {
                        items(searchResults) { item ->
                            Text(
                                text = item,
                                modifier = Modifier.padding(16.dp)
                            )
                        }
                    }*/

                    /*var selectedCategory by remember { mutableStateOf("Популярные") }
                    val categories =
                        listOf("Популярные", "Женщинам", "Мужчинам", "Детям", "Аксессуары")
                    Column {
                        ChipsLazyRow(
                            categories = categories,
                            selectedCategory = selectedCategory,
                            onCategoryClick = { category ->
                                selectedCategory = category
                            }
                        )
                    }
*/

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

