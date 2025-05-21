import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.uikit.R
import com.example.uikit.UI.Accent
import com.example.uikit.UI.Black
import com.example.uikit.UI.Input_Backgroud
import com.example.uikit.UI.Input_Strok
import com.example.uikit.UI.PlaceHolder
import com.example.uikit.UI.localTypography

@Composable
fun NameInputField_WithoutChangeBorder(
    value: String, placeholde: String, isPassword: Boolean=false,
    onValChange: (String) -> Unit
) {
    var isWriting by remember { mutableStateOf(false) }
    var isVis by remember { mutableStateOf(true) }
    var colorBorder by remember { mutableStateOf(Input_Strok) }


    TextField(
        value = value,
        onValueChange = { onValChange(it) },
        singleLine = true,
        placeholder = {
            Text(
                placeholde, style = localTypography.current.Text_Reg, color = PlaceHolder
            )
        },
        trailingIcon = {
            if (isPassword) {
                val ic = if (isVis) R.drawable.closeeye else R.drawable.eye
                Icon(
                    painter = painterResource(ic),
                    contentDescription = "",
                    modifier = Modifier.clickable {
                        isVis=!isVis
                    })
            }
        },
        visualTransformation = if (!isVis || !isPassword) VisualTransformation.None else PasswordVisualTransformation(),
        shape = RoundedCornerShape(10.dp),
        colors = TextFieldDefaults.colors(
            disabledIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent,
            errorIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledTextColor = Black,
            cursorColor = Accent,
            focusedTextColor = Black,
            focusedContainerColor = Input_Backgroud,
            unfocusedTextColor = Black,
            unfocusedContainerColor = Input_Backgroud,
            disabledContainerColor = Input_Backgroud,
        ),
        maxLines = 1,
        modifier = Modifier
            .border(1.dp, colorBorder, RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .height(50.dp)//должно быть 48, но он кривой
            .clickable {
                isWriting = true
                colorBorder = Accent
            }
            .onFocusChanged { focusState ->
                isWriting = focusState.isFocused
                colorBorder = if (focusState.isFocused) Accent else Input_Strok
            }
    )
}


