package com.example.storybook2

import NameInputField_WithoutChangeBorder
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.uikit.Button.Primary
import com.example.uikit.Components.Counter
import com.example.uikit.Components.SpacerHeight
import com.example.uikit.Components.ToggleSwitch
import com.example.uikit.Components.ToggleSwitchExample
import com.example.uikit.Input.TextFieldAndTitle
import com.example.uikit.R
import com.example.uikit.Select.GenderDropdownMenu
import com.example.uikit.UI.Accent

@Composable
fun StoryBook() {

    LazyColumn(
        modifier = Modifier.padding(horizontal = 20.dp, vertical = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Text("Иконки")

            Icon(painter = painterResource(R.drawable.uicon), contentDescription = "")
            Icon(painter = painterResource(R.drawable.send), contentDescription = "")
            Icon(painter = painterResource(R.drawable.eye), contentDescription = "")
            Icon(painter = painterResource(R.drawable.paperclip), contentDescription = "")
            Icon(painter = painterResource(R.drawable.mic), contentDescription = "")
            Icon(painter = painterResource(R.drawable.map), contentDescription = "")
            Icon(painter = painterResource(R.drawable.home), contentDescription = "")
            Icon(painter = painterResource(R.drawable.closeeye), contentDescription = "")
            Icon(painter = painterResource(R.drawable.filter), contentDescription = "")
            Icon(painter = painterResource(R.drawable.close), contentDescription = "")
            Icon(painter = painterResource(R.drawable.catalog), contentDescription = "")

            SpacerHeight(20)
            Text("Контролы")
            Text("Toggle")
            ToggleSwitch(false) { }
            ToggleSwitch(true) { }
            Text("Counter")
            Counter(1) { }
            Counter(10) { }

            SpacerHeight(20)
            Text("Логотип")
            Icon(
                painter = painterResource(R.drawable.logoapp),
                contentDescription = "",
                tint = Accent
            )
            SpacerHeight(20)

            Text("Primary")
            Primary(
                "Рубашка Воскресенье для машинного вязания",
                "Мужская одежда",
                "300",
                false,
                true
            ) { }
            Primary(
                "Рубашка Воскресенье для машинного вязания",
                "Мужская одежда",
                "300",
                true,
                true
            ) { }
            SpacerHeight(20)

            Text("Инпуты")
            TextFieldAndTitle("Имя","Введите имя",false,""){}
            NameInputField_WithoutChangeBorder("","Введите имя"){}
            GenderDropdownMenu("") { }
        }
    }
}