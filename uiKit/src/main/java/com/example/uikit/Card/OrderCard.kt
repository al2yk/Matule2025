package com.example.uikit.Card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.ChipsTwo
import com.example.uikit.Button.MediumButtonRed
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.R
import com.example.uikit.UI.Card_Strok
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Success
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White

@Composable
fun OrderCard(
    num: Int,
    date: String,
    status: String,
    items: List<List<String>>,
    check:()->Unit,
    help:()->Unit,
    otmena:()->Unit
) {
    var isCheck by remember { mutableStateOf(false) }

    val totalCost = remember(items) {
        items.sumOf { item->
            item[0].toInt() * item[2].toInt()
        }.toString()
    }


    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardColors(
            containerColor = White,
            contentColor = White,
            disabledContainerColor = White,
            disabledContentColor = White
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "${totalCost} ₽",
                style = Typography().Headline_Reg,
                modifier = Modifier.align(Alignment.TopEnd)
            )
            Column {
                Text(
                    "Заказ №${num}",
                    style = Typography().Title3_Semi,
                    modifier = Modifier.padding(top = 2.dp)
                )
                SpacerHeight(8)
                Row {
                    Text(
                        "${date} • ",
                        style = Typography().Caption_Reg,
                        color = PlaceHolder
                    )
                    Text("${status}", style = Typography().Caption_Reg, color = Success)
                }
                SpacerHeight(12)
                Row(horizontalArrangement = Arrangement.Center) {
                    Icon(
                        painter = painterResource(R.drawable.file_text),
                        contentDescription = "",
                        tint = PlaceHolder,
                        modifier = Modifier.size(20.dp)
                    )
                    SpacerWi(8)
                    Text(
                        "Посмотреть",
                        style = Typography().Headline_Reg,
                        color = PlaceHolder,
                        modifier = Modifier.clickable { isCheck = !isCheck }
                    )
                }

                AnimatedVisibility(visible = isCheck) {
                    Column(modifier = Modifier.padding(top = 16.dp)) {
                        Divider(modifier = Modifier.width(335.dp), color = Card_Strok)
                        SpacerHeight(16)
                        Text(
                            "Описания",
                            style = Typography().Headline_Med,
                            color = PlaceHolder
                        )

                        SpacerHeight(12)
                        items.forEach { item ->
                            // Предполагаем, что item[0] - количество, item[1] - название, item[2] - цена
                            OrderCardComponent(
                                quantity = item[0].toInt(),
                                name = item[1],
                                price = item[2]
                            )
                        }

                        SpacerHeight(14)
                        Divider(modifier = Modifier.fillMaxWidth(), color = Card_Strok)
                        SpacerHeight(22)
                        Box(modifier = Modifier.fillMaxWidth()){
                            ChipsTwo(144,"Чек покупки",false) { check()}
                            Box(modifier = Modifier.align(Alignment.CenterEnd)){
                                ChipsTwo(143,"Помощь",false) { help()}
                            }
                        }
                        SpacerHeight(16)
                        MediumButtonRed("Отменить заказ"){
                            otmena()
                        }
                        SpacerHeight(124)
                    }
                }
            }
        }
    }
}
@Composable
fun OrderCardComponent(
    quantity: Int,
    name: String,
    price: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Text(
            "$name",
            style = Typography().Caption2_Reg,
            modifier = Modifier.padding(end = 70.dp)
        )
        Text(
            "$quantity x $price ₽",
            style = Typography().Text_Reg,
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
    SpacerHeight(8)
}
