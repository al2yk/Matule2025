package com.example.uikit.Modal

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.example.uikit.Components.Close
import com.example.uikit.UI.Typography
import com.example.uikit.UI.White
import com.example.uikit.UI.localTypography

@Composable
fun ModalBackground(sm: Int, Text: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8, 8, 0, 0))
                .fillMaxWidth()
                .height(sm.dp)
                .background(White)
        ) {
            Text(
                Text,
                style = Typography().Title2_SemiBold,
                modifier = Modifier.padding(top = 24.dp, start = 20.dp, end = 40.dp)
            )
            Box(modifier = Modifier.align(Alignment.TopEnd).padding(end = 20.dp, top = 24.dp)) {
                Close()
            }

        }
    }
}