package com.example.uikit.cell

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.SpacerWi
import com.example.uikit.R
import com.example.uikit.UI.Card_Strok
import com.example.uikit.UI.Error
import com.example.uikit.UI.Input_Icon
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.Success
import com.example.uikit.UI.Typography
import com.example.uikit.UI.localTypography


@Composable
fun ResultTableCell(title:String,result: Double, isNormal:Boolean){
    var color = if(isNormal) Success else Error

    Box(modifier = Modifier.fillMaxWidth().height(22.dp)){

        Box(modifier = Modifier.fillMaxWidth()) {

            Text(title, style = Typography().Caption2_Reg)

            Text(result.toString(), style = Typography().Caption2_Reg, modifier = Modifier.padding(start = 126.dp),color=color)

            Text("11.1-14.1", style = Typography().Caption2_Reg, modifier = Modifier.padding(start = 250.dp))

            Icon(
                painter = painterResource(R.drawable.right),
                contentDescription = "",
                tint = Input_Icon,
                modifier = Modifier.size(20.dp).align(Alignment.CenterEnd)
            )
        }

        androidx.compose.material3.Divider(modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter), color = Input_Strok)
    }
    SpacerHeight(9)
}