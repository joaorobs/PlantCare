package com.example.plantcare.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.plantcare.COLOR

@Composable
fun HomeScreenTopBox() {
    Box(
        modifier = Modifier
            .height(200.dp)
            .fillMaxWidth()
            .background(COLOR)
    ) {
        Text(
            text = "PlantCare",
            fontWeight = FontWeight(700),
            fontSize = 30.sp,
            fontFamily = FontFamily.Serif,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
        )
        Text(
            text = "Remember when to water your plants.",
            fontWeight = FontWeight(700),
            fontSize = 10.sp,
            fontFamily = FontFamily.Serif,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 50.dp)
        )
    }
}