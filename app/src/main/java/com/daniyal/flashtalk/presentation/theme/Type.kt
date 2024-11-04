package com.daniyal.flashtalk.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.R

val CarosFontFamily = FontFamily(
    Font(R.font.caros_soft_bold, FontWeight.Bold),
    Font(R.font.caros_soft_black, FontWeight.Black),
    Font(R.font.caros_soft, FontWeight.Normal),
    Font(R.font.caros_soft_extra_bold, FontWeight.ExtraBold),
    Font(R.font.caros_soft_extra_light, FontWeight.ExtraLight),
    Font(R.font.caros_soft_heavy, FontWeight.ExtraBold),
    Font(R.font.caros_soft_light, FontWeight.Light),
    Font(R.font.caros_soft_medium, FontWeight.Medium),
    Font(R.font.caros_soft_thin, FontWeight.Thin)
)

// Set of Material typography styles to start with
val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = CarosFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold
    ),
    headlineMedium = TextStyle(
        fontFamily = CarosFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold
    ),
    labelSmall = TextStyle(
        fontFamily = CarosFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Medium
    ),
    labelMedium = TextStyle(
        fontFamily = CarosFontFamily,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold
    ),


    // Story Item
    bodyMedium = TextStyle(
        fontFamily = CarosFontFamily,
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal
    ),

//    ChatItem
    titleMedium = TextStyle(
        fontFamily = CarosFontFamily,
        fontSize = 20.sp,
        fontWeight = FontWeight.Medium
    ),


)

