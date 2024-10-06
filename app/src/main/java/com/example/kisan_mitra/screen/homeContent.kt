package com.example.kisan_mitra.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.kisan_mitra.data.DataProvider
import com.example.kisan_mitra.itemlinkItem


@Composable
fun homeContent()
{

    val itemslink=remember{ DataProvider.itemList}
    Column (modifier = Modifier.padding(top = 310.dp , bottom = 80.dp)){

    LazyColumn(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 12.dp)
    ) {
        items(
            items = itemslink,
            itemContent = {
                itemlinkItem(ItemsLinks = it)
            })
    }
    }
}


