package com.example.matule2025.Presentation.screens.signInUp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.matule2025.Presentation.navigation.NavigationRoutes
import com.example.uikit.Components.Circle
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Description
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun CreatePassword4(controller:NavHostController) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(White)

    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 20.dp, vertical = 80.dp)
        ) {

            Text(
                "Пропустить",
                style = Typography().Text_Reg, modifier = Modifier.align(Alignment.End).clickable {
                    controller.navigate(NavigationRoutes.CREATEPROFILE)
                }, color = Accent
            )

            SpacerHeight(40)
            Text(
                "Cоздайте пароль",
                style = Typography().Caption2_Bold,
                fontSize = 24.sp, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            SpacerHeight(16)
            Text(
                "Для защиты ваших персональных данных",
                style = Typography().Text_Reg, modifier = Modifier.align(Alignment.CenterHorizontally), color = PlaceHolder
            )
            SpacerHeight(56)

            Row(modifier = Modifier.width(100.dp).height(16.dp).align(Alignment.CenterHorizontally)){
                Box(modifier = Modifier.size(16.dp).clip(CircleShape).border(1.dp,Accent, shape =CircleShape))
                SpacerWi(12)
                Box(modifier = Modifier.size(16.dp).clip(CircleShape).border(1.dp,Accent, shape =CircleShape))
                SpacerWi(12)
                Box(modifier = Modifier.size(16.dp).clip(CircleShape).border(1.dp,Accent, shape =CircleShape))
                SpacerWi(12)
                Box(modifier = Modifier.size(16.dp).clip(CircleShape).border(1.dp,Accent, shape =CircleShape))
            }
            SpacerHeight(60)

            Box(modifier = Modifier.padding(horizontal = 30.dp).fillMaxWidth().height(300.dp)){
                Circle(1) { }
                Circle(2, Modifier.align(Alignment.TopCenter)) { }
                Circle(3, Modifier.align(Alignment.TopEnd)) { }
                Circle(4, Modifier.align(Alignment.CenterStart)) { }
                Circle(5, Modifier.align(Alignment.Center)) { }
                Circle(6, Modifier.align(Alignment.CenterEnd)) { }
                Circle(7, Modifier.align(Alignment.BottomStart)) { }
                Circle(8, Modifier.align(Alignment.BottomCenter)) { }
                Circle(9, Modifier.align(Alignment.BottomEnd)) { }
            }
            SpacerHeight(30)
            Box(modifier = Modifier.padding(horizontal = 50.dp).fillMaxWidth()) {

                Circle(0, Modifier.align(Alignment.Center)) { }
                Icon(
                    painter = painterResource(R.drawable.mine1),
                    contentDescription = "",
                    tint = Black,
                    modifier = Modifier.align(Alignment.CenterEnd)
                )
            }
        }
    }
}
