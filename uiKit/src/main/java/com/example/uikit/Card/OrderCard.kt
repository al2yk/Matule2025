package com.example.uikit.Card

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.uikit.Button.Chips
import com.example.uikit.Button.ChipsTwo
import com.example.uikit.Button.MediumButtonRed
import com.example.uikit.Components.CheckBox
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.R
import com.example.uikit.UI.Black
import com.example.uikit.UI.Card_Strok
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Success
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun OrderCard(num: Int, Cost: String, date: String, status: String) {

    var isCheck by remember { mutableStateOf(false) }



    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardColors(
            containerColor = White,
            contentColor = White,
            disabledContainerColor = White,
            disabledContentColor = White
        )
    ) {
        /* CardBackground(116, Input_Strok)*/
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                "${Cost} ₽",
                style = localTypography.current.Headline_Reg,
                modifier = Modifier.align(Alignment.TopEnd)
            )
            Column {

                Text(
                    "Заказ №${num} ₽",
                    style = localTypography.current.Title3_Semi,
                    modifier = Modifier.padding(top = 2.dp)
                )
                SpacerHeight(8)
                Row {
                    Text(
                        "${date} • ",
                        style = localTypography.current.Caption_Reg,
                        color = PlaceHolder
                    )
                    Text("${status}", style = localTypography.current.Caption_Reg, color = Success)
                }
                SpacerHeight(12)
                Row(horizontalArrangement = Arrangement.Center) {
                    Icon(
                        painter = painterResource(R.drawable.file_text),
                        contentDescription = "",
                        tint = PlaceHolder,
                        modifier = Modifier
                            .size(20.dp)
                    )
                    SpacerWi(8)
                    Text(
                        "Посмотреть",
                        style = localTypography.current.Headline_Reg,
                        color = PlaceHolder, modifier = Modifier.clickable {
                            isCheck = !isCheck
                        }
                    )
                }

                AnimatedVisibility(
                    visible = isCheck,
                ) {

                    Column(
                        modifier = Modifier.padding(top = 16.dp)
                    ) {

                        Divider(modifier = Modifier.width(335.dp), color = Card_Strok)
                        SpacerHeight(16)
                        Text(
                            "Описания",
                            style = localTypography.current.Headline_Med,
                            color = PlaceHolder
                        )

                        SpacerHeight(12)
                        OrderCardComponent(2,"Рубашка воскресенье дял машинного вязания","300")
                        OrderCardComponent(1,"Шорты вторник для машинного вязания","980")
                        SpacerHeight(14)
                        Divider(modifier = Modifier.fillMaxWidth(), color = Card_Strok)
                        SpacerHeight(22)
                        Box(modifier = Modifier.fillMaxWidth()){
                            ChipsTwo(144,"Чек покупки",false) { }
                            Box(modifier = Modifier.align(Alignment.CenterEnd)){
                                ChipsTwo(143,"Помощь",false) { }
                            }
                        }
                        SpacerHeight(16)
                        MediumButtonRed("Отменить заказ"){}
                        SpacerHeight(124)
                    }
                }
            }
        }
    }
}


@Composable
fun OrderCardComponent(count:Int,Title:String,Cost:String){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(40.dp)
    ) {
        Text(
            Title,
            style = localTypography.current.Caption2_Reg,
            modifier = Modifier.padding(end = 70.dp)

        )
       Text(
            "${count}   x ${Cost} ₽",
            style = localTypography.current.Text_Reg,
            modifier = Modifier.align(Alignment.TopEnd)
        )
    }
    SpacerHeight(8)
}

@Composable
fun OrderListScreen() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        OrderItem(
            orderNumber = "123456",
            date = "26 апреля, 14:00",
            status = "Оплачен",
            totalPrice = "2580 ₽",
            items = listOf(
                OrderItemInfo("Рубашка Воскресенье для машинного вязания", "300 ₽", 1),
                OrderItemInfo("Шорты Вторник для машинного вязания", "690 ₽", 1)
            )
        )

        OrderItem(
            orderNumber = "123456",
            date = "26 апреля, 14:00",
            status = "Оплачен",
            totalPrice = "2500 ₽",
            items = listOf(
                OrderItemInfo("Рубашка Воскресенье для машинного вязания", "300 ₽", 1),
                OrderItemInfo("Шорты Вторник для машинного вязания", "690 ₽", 1)
            )
        )
    }
}

@Composable
fun OrderItem(
    orderNumber: String,
    date: String,
    status: String,
    totalPrice: String,
    items: List<OrderItemInfo>
) {
    var isExpanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            // Заголовок заказа
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column {
                    Text(
                        text = "Заказ № $orderNumber",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Text(
                        text = "$date • $status",
                        color = Color.Gray,
                        fontSize = 14.sp
                    )
                }

                Text(
                    text = totalPrice,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            // Кнопка "Посмотреть"
            Text(
                text = "Посмотреть",
                color = Color.Blue,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .clickable { isExpanded = !isExpanded }
            )

            // Раскрывающаяся секция с деталями
            AnimatedVisibility(
                visible = isExpanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier.padding(top = 16.dp)
                ) {
                    Divider(modifier = Modifier.padding(bottom = 8.dp))

                    Text(
                        text = "Описания",
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )

                    items.forEach { item ->
                        OrderItemRow(item)
                    }

                    Spacer(modifier = Modifier.size(16.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "Чек покупки", color = Color.Blue)
                        Text(text = "Помощь", color = Color.Blue)
                    }

                    Button(
                        onClick = { /* Отменить заказ */ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp)
                    ) {
                        Text(text = "Отменить заказ")
                    }
                }
            }
        }
    }
}

@Composable
fun OrderItemRow(item: OrderItemInfo) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = item.name,
            modifier = Modifier.weight(1f),
            maxLines = 2
        )
        Text(
            text = "${item.quantity} x ${item.price}",
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

data class OrderItemInfo(
    val name: String,
    val price: String,
    val quantity: Int
)