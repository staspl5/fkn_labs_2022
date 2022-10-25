package com.example.lab1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Head() {
    Column(
        modifier = Modifier
            .background(Color.DarkGray)
            .fillMaxHeight(0.3f)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.marvel), contentDescription = "marvelIcon",
            modifier = Modifier
                .padding(top = 25.dp, bottom = 30.dp)
                .size(130.dp, 50.dp),
            contentScale = ContentScale.Fit
        )
        Text(text = "Choose your hero", style = TextStyle(color = Color.White, fontSize = 35.sp))
    }
}
