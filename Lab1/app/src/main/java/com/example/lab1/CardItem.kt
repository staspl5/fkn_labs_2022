package com.example.lab1

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
import androidx.navigation.NavController

@Composable
fun CardItem(itemRow: ItemRow, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .size(320.dp, 440.dp)
            .animateContentSize()
            .clickable {
                       navController.navigate(Screen.InfoScreen.withArgs(itemRow.imageId.toString()))
            },
        shape = RoundedCornerShape(15.dp)
    ) {
        Image(
            painter = painterResource(id = itemRow.imageId),
            contentDescription = "marvelCard",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.BottomStart
        ) {
            Text(
                text = itemRow.title, modifier = Modifier.padding(start = 30.dp, bottom = 40.dp),
                style = TextStyle(color = Color.White, fontSize = 35.sp)
            )
        }
    }
}
