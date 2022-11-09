package com.example.lab1

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.AsyncImage

@Composable
fun InfoScreen(navController: NavController, id: Int?, listCards: List<ItemRow>) {
    //Text(text="Test $id")
    AsyncImage(model = listCards[id!!].url, contentDescription = null,
    modifier = Modifier.fillMaxSize(),
    contentScale = ContentScale.Crop)
    Box(
        modifier = Modifier.fillMaxSize(),
        Alignment.TopStart
    ){
        TextButton(onClick = {
            Log.e("deb", id.toString())
            navController.popBackStack()
        }) {
            Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = null,
            tint = Color.White
            )
            //Image(imageVector = ImageVector.vectorResource(id = R.drawable.back_arrow), contentDescription = null)
        }
    }
    Box(modifier = Modifier.fillMaxSize(),
    Alignment.BottomStart){
        //Column(modifier = Modifier.background(Color.Black).padding(start = 30.dp, bottom = 35.dp)) {
        val offset = Offset(5.0f, 10.0f)
        Column(modifier = Modifier.padding(start = 30.dp, bottom = 80.dp)) {
            Text(
                text = listCards[id].title, modifier = Modifier.padding(bottom = 20.dp, start=15.dp, end= 15.dp),
                style = TextStyle(color = Color.White, fontSize = 53.sp, shadow = Shadow(
                    color = Color.Black,
                    offset = offset,
                    blurRadius = 3f
                )
                )
            )
            Text(
                text = listCards[id].description, modifier = Modifier.padding(bottom = 20.dp, start=15.dp, end= 15.dp),
                style = TextStyle(color = Color.White, fontSize = 25.sp, shadow = Shadow(
                    color = Color.Black,
                    offset = offset,
                    blurRadius = 3f
                ))
            )
        }
    }
}
