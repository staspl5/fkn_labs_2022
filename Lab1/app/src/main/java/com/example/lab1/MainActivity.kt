package com.example.lab1

import android.content.res.Resources
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.chrisbanes.snapper.ExperimentalSnapperApi
import dev.chrisbanes.snapper.rememberSnapperFlingBehavior
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.DarkGray)
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                head()
                cards()

            }
        }
    }
}

@Composable
fun head() {
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

@OptIn(ExperimentalSnapperApi::class)
@Composable
fun cards() {
    val listCards = listOf(
        ItemRow(R.drawable.cap, "Captain America", Color(0xFF123EAB)),
        ItemRow(R.drawable.spider, "Spider-man", Color(0xFFBF9030)),
        ItemRow(R.drawable.iron, "Iron Man", Color(0xFFD91818)),
        ItemRow(R.drawable.dead, "Deadpool", Color(0xFF6C0303)),
        ItemRow(R.drawable.daredevil, "Daredevil", Color(0xFF2A0000)),
        ItemRow(R.drawable.thanos, "Thanos", Color(0xFF65247F))
    )
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    val back = remember {
        mutableStateOf(Color(0xFF123EAB))
    }

    LazyRow(modifier = Modifier
        .fillMaxSize()
        .scrollable(
            orientation = Orientation.Horizontal,
            state = rememberScrollableState { delta ->
                coroutineScope.launch {
                    // Animate scroll to the 10th item
                    if (listState.firstVisibleItemScrollOffset < Resources.getSystem().displayMetrics.widthPixels / 2) {
                        listState.animateScrollToItem(index = listState.firstVisibleItemIndex)
                    } else {
                        listState.animateScrollToItem(index = listState.firstVisibleItemIndex + 1)
                    }
                    back.value = listCards[listState.firstVisibleItemIndex].background
                }
                delta
            }
        )
        .background(color = back.value),
        state = listState,
        flingBehavior = rememberSnapperFlingBehavior(listState)) {
        itemsIndexed(listCards) { _, item ->
            card(item)
        }
    }
}


@Composable
fun card(itemRow: ItemRow) {
    Card(
        modifier = Modifier
            .padding(start = 20.dp, end = 20.dp, top = 20.dp)
            .size(320.dp, 440.dp)
            .animateContentSize(),
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

data class ItemRow(
    val imageId: Int,
    val title: String,
    val background: Color
)

