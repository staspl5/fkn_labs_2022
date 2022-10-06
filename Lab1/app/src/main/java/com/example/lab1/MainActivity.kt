package com.example.lab1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lab1.ui.theme.Lab1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                Column(modifier = Modifier
                    .background(Color.Green)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally){
                        head()
                        cards()

                }
        }
    }
}

@Composable
fun head() {
    Column(modifier= Modifier
        .background(Color.Gray)
        .fillMaxHeight(0.3f)
        .fillMaxWidth(),
    verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally){
        Image(painter = painterResource(id = R.drawable.marvel), contentDescription = "marvelIcon",
            modifier = Modifier
                .padding(top = 25.dp, bottom = 30.dp)
                .size(130.dp, 50.dp),
        contentScale = ContentScale.Fit)
        Text(text = "Choose your hero", style = TextStyle(color = Color.White, fontSize = 35.sp))
    }
}

@Composable
fun cards(){
    LazyRow(modifier = Modifier.fillMaxSize()){
        itemsIndexed(listOf(ItemRow(R.drawable.h,"Example 1"), ItemRow(R.drawable.h, "Example 2"),
            ItemRow(R.drawable.h,"Example 3"),ItemRow(R.drawable.h,"Example 4"))){
            _,item -> card(item)
        }
    }
}

@Composable
fun card(itemRow: ItemRow){
    Card(modifier = Modifier.padding(start = 20.dp, end = 20.dp).size(320.dp, 440.dp),
    shape = RoundedCornerShape(15.dp)
    ) {
        Image(painter = painterResource(id = itemRow.imageId), contentDescription = "marvelCard")
        Box(modifier= Modifier.fillMaxSize(),
        Alignment.BottomStart){
            Text(text=itemRow.title, modifier = Modifier.padding(start = 30.dp, bottom=40.dp),
                style = TextStyle(color = Color.White,  fontSize = 35.sp))
        }
    }


}

data class ItemRow(
    val imageId: Int,
    val title: String
)

