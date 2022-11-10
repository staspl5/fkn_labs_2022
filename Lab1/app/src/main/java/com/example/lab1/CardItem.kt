package com.example.lab1

import android.util.Log
import androidx.compose.animation.animateContentSize
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
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun CardItem(itemRow: ItemRow, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .size(320.dp, 440.dp)
            .animateContentSize()
            .clickable {
                       navController.navigate(Screen.InfoScreen.withArgs(itemRow.id.toString()))
                Log.i("deb", itemRow.id.toString())
            },
        shape = RoundedCornerShape(15.dp)
    ) {
        AsyncImage(
            model = itemRow.url,
            contentDescription = "marvelCard",
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = Modifier.fillMaxSize(),
            Alignment.BottomStart
        ) {
            val offset = Offset(5.0f, 10.0f)
            Text(
                text = itemRow.title, modifier = Modifier.padding(start = 30.dp, bottom = 40.dp, end = 30.dp),
                style = TextStyle(color = Color.White, fontSize = 35.sp, shadow = Shadow(
                    color = Color.Black,
                    offset = offset,
                    blurRadius = 3f
                ))
            )
        }
    }
}
