package com.example.kisan_mitra

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kisan_mitra.data.itemslinks


@Composable
fun itemlinkItem(ItemsLinks: itemslinks) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Row {
            ItemImage(item = ItemsLinks)
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            ) {
                Text(text = ItemsLinks.title, fontSize = 20.sp)
                TextButton(
                    onClick = {
                        showToast(mContext, "Website is opening")
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ItemsLinks.url))
                        mContext.startActivity(intent)
                    },

                ) {
                    Text(text = ItemsLinks.url, color = Color.Blue)
                }
                Text(text = "YouTube Link", fontSize = 16.sp)
                TextButton(
                    onClick = {
                        // Handle YouTube link click
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(ItemsLinks.videoLink))
                        mContext.startActivity(intent)
                    }
                ) {
                    Text(text = ItemsLinks.videoLink, color = Color.Blue)
                }
            }
        }
    }
    }


@Composable
private fun ItemImage(item: itemslinks) {
    Image(
        painter = painterResource(id = item.itemimageid),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .padding(8.dp)
            .size(84.dp)
            .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
    )
}




private fun showToast(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}

class kisanViewModel {



    }