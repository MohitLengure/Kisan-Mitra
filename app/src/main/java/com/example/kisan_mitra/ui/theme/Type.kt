package com.example.kisan_mitra.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.kisan_mitra.R

// Set of Material typography styles to start with
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)
val cantoraone=FontFamily(
    Font(R.font.cantoraone,FontWeight.Black)
)
val cambaybold=FontFamily(
    Font(R.font.cambaybold,FontWeight.Bold)
)
val cambayitalic=FontFamily(
    Font(R.font.cambayitalic,FontWeight.Bold)
)
val cambayregular=FontFamily(
    Font(R.font.cambayregular,FontWeight.Black)
)
val cambaybolditalic=FontFamily(
    Font(R.font.cambaybolditalic,FontWeight.Bold)
)