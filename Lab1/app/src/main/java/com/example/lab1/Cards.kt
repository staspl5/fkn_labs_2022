package com.example.lab1

import android.content.res.Resources
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.launch

@Composable
fun Cards() {
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
        state = listState) {
        itemsIndexed(listCards) { _, item ->
            CardItem(item)
        }
    }
}
