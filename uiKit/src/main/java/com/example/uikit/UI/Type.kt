package com.example.uikit.UI

import androidx.compose.material3.Typography
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.uikit.R


data class Typo(
    val Title1_SemiBold:TextStyle = TextStyle(),
    val Title1_Heavy:TextStyle = TextStyle(),
    val Title2_Regular:TextStyle = TextStyle(),
    val Title2_SemiBold:TextStyle = TextStyle(),
    val Title2_Heavy:TextStyle = TextStyle(),
    val Title3_Reg:TextStyle = TextStyle(),
    val Title3_Med:TextStyle = TextStyle(),
    val Title3_Semi:TextStyle = TextStyle(),
    val Headline_Reg:TextStyle = TextStyle(),
    val Headline_Med:TextStyle = TextStyle(),
    val Text_Reg:TextStyle = TextStyle(),
    val Text_Med:TextStyle = TextStyle(),
    val Caption_Reg:TextStyle = TextStyle(),
    val Caption_Semi:TextStyle = TextStyle(),
    val Caption2_Reg:TextStyle = TextStyle(),
    val Caption2_Bold:TextStyle = TextStyle(),
    )



val Typography = Typo(
    //SEMI BOLD
    Title1_SemiBold = TextStyle(
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.semibold)),
        color = Black
    ),
    Title2_SemiBold = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.semibold)),
        color = Black
    ),
    Title3_Semi = TextStyle(
        fontSize = 17.sp,
        fontFamily = FontFamily(Font(R.font.semibold)),
        color = Black
    ),
    Caption_Semi = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.semibold)),
        color = Black
    ),




    //HEAVY
    Title1_Heavy = TextStyle(
        fontSize = 24.sp,
        fontFamily = FontFamily(Font(R.font.heavy)),
        color = Black
    ),
    Title2_Heavy = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.heavy)),
        color = Black
    ),



    //REGULAR
    Title2_Regular = TextStyle(
        fontSize = 20.sp,
        fontFamily = FontFamily(Font(R.font.regular)),
        color = Black
    ),
    Title3_Reg = TextStyle(
        fontSize = 17.sp,
        fontFamily = FontFamily(Font(R.font.regular)),
        color = Black
    ),
    Headline_Reg = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.regular)),
        color = Black
    ),
    Text_Reg = TextStyle(
        fontSize = 15.sp,
        fontFamily = FontFamily(Font(R.font.regular)),
        color = Black
    ),
    Caption_Reg = TextStyle(
        fontSize = 14.sp,
        fontFamily = FontFamily(Font(R.font.regular)),
        color = Black
    ),
    Caption2_Reg = TextStyle(
        fontSize = 12.sp,
        fontFamily = FontFamily(Font(R.font.regular)),
        color = Black
    ),



    //MEDIUM
    Title3_Med = TextStyle(
        fontSize = 17.sp,
        fontFamily = FontFamily(Font(R.font.medium)),
        color = Black
    ),
    Headline_Med = TextStyle(
        fontSize = 16.sp,
        fontFamily = FontFamily(Font(R.font.medium)),
        color = Black
    ),
    Text_Med = TextStyle(
        fontSize = 15.sp,
        fontFamily = FontFamily(Font(R.font.medium)),
        color = Black
    ),

    //Bold
    Caption2_Bold = TextStyle(
        fontSize = 15.sp,
        fontFamily = FontFamily(Font(R.font.bold)),
        color = Black
    ),)

val localTypography = staticCompositionLocalOf { Typography }