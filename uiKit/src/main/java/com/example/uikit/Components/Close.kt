package com.example.uikit.Components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Description
import com.example.uikit.UI.Input_Icon

@Composable
fun Close() {

    Box(contentAlignment = Alignment.Center){
        Box(
            modifier = Modifier
                .size(24.dp)
                .alpha(0.3f)
                .clip(CircleShape)
                .background(Input_Icon), contentAlignment = Alignment.Center
        ) {
        }
        Icon(
            painter = painterResource(R.drawable.close),
            contentDescription = "",
            tint = Description,
            modifier = Modifier.size(15.dp).alpha(2f)
        )
    }

}