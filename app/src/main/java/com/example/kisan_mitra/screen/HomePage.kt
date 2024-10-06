package com.example.kisan_mitra.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastForEachIndexed
import com.example.kisan_mitra.R
import kotlinx.coroutines.delay

@Composable
@Preview
fun HomePage(modifier: Modifier = Modifier)
{
    val images= listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3,
        R.drawable.image4
    )
    ImageSliderWithIndicator(images= images)
    homeContent()



}


@Composable
fun ImageSliderItem(imageResId: Int)
{
    Image(painter = painterResource(id = imageResId),
        contentDescription =null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp)
    )
}


@Composable
fun Indicator(active: Boolean)
{
    val color = if (active) Color.White else Color.Gray
    val size = if (active) 10.dp else 10.dp
    Box(modifier= Modifier
        .clip(CircleShape)
        .background(color)
        .size(size)
    )
}

@Composable
fun ImageSliderWithIndicator(images: List<Int>)
{
    val currentIndex = remember{
        mutableStateOf(0)
    }
    LaunchedEffect(Unit) {
        while(true) {
            delay(3000)
            currentIndex.value = (currentIndex.value + 1) % images.size
        }
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(top = 100.dp)) {
        Box(modifier = Modifier
            .padding(10.dp)
            .weight(1f)
            )
        {
            ImageSliderItem(imageResId = images[currentIndex.value])
        }
        Row(
            modifier = Modifier
                .padding(start = 150.dp, bottom = 500.dp)
        )
        {
            images.fastForEachIndexed{ index, i ->
                Indicator(active =index==currentIndex.value)
                if(index<images.size-1)
                {
                    Spacer(modifier = Modifier.width(5.dp))
                }
            }
        }
    }
}
