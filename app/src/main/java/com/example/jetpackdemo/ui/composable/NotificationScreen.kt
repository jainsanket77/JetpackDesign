package com.example.jetpackdemo.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackdemo.R
import com.example.jetpackdemo.data.NotificationModel
import com.example.jetpackdemo.data.getNotifications
import com.example.jetpackdemo.ui.comonents.toolbars.NotificationToolbar

/**
 * Composable function that represents the home screen of the application.
 */

val notificationList = getNotifications()

@Composable
fun NotificationScreen(navController: NavHostController) {

    var expanded by remember { mutableStateOf(false) }

    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            NotificationToolbar(notificationList.size,
                onBackPressed = {
                    navController.navigateUp()
                }, onReadAllPressed = {
                })
            ShowNotifications(
                onNotificationItemClick = {
                }
            )
        }
    }
}

@Composable
fun ShowPopupMenu() {
    DropdownMenu(
        expanded = true,
        onDismissRequest = { }
    ) {
        DropdownMenuItem(
            text = { Text("Mark read") },
            onClick = { /* Handle Mark read! */ }
        )
        DropdownMenuItem(
            text = { Text("Settings") },
            onClick = { /*  */ }
        )
        Divider()
        DropdownMenuItem(
            text = { Text("Delete") },
            onClick = { /* Handle delete! */ }
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun ShowNotifications(
    onNotificationItemClick: ((NotificationModel) -> Unit)? = null,
) {
    val groupNotificationList = getNotifications().groupBy { it.date }
    // Constructing the new list using flatMap and map
    val notificationList = groupNotificationList.flatMap { (date, notification) ->
        listOf(NotificationModel(header = date)) + notification
    }

    LazyColumn(
        modifier = Modifier.padding(top = 12.dp)
    ) {
        itemsIndexed(notificationList) { i, item ->
            if (!item.header.isNullOrBlank())
                Text(
                    text = item.header ?: "",
                    color = Color.DarkGray,
                    fontSize = 16.sp,
                    style = TextStyle(fontWeight = FontWeight.Medium),
                    modifier = Modifier.padding(vertical = 4.dp)
                )
            else
                ElevatedCard(
                    onClick = {
                        onNotificationItemClick?.invoke(item)
                    },
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clip(RoundedCornerShape(12.dp))
                            .fillMaxWidth()
                            .background(item.backgroundColor ?: Color.White)
                            .padding(horizontal = 12.dp, vertical = 12.dp),
                    ) {
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier
                                .background(Color.Gray.copy(alpha = 0.20f), shape = RoundedCornerShape(8.dp))
                                .padding(8.dp),
                        ) {
                            Image(
                                painter = painterResource(id = item.image ?: R.drawable.ic_notification),
                                contentDescription = "Photos Description",
                                contentScale = ContentScale.Crop,
                                alignment = Alignment.Center
                            )
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 12.dp)
                        ) {
                            Text(
                                text = item.title ?: "",
                                color = Color.Black,
                                fontSize = 16.sp,
                                style = TextStyle(fontWeight = FontWeight.SemiBold),
                            )
                            Text(
                                text = item.body ?: "",
                                color = Color.Gray.copy(alpha = 0.80f),
                                fontSize = 14.sp,
                                maxLines = 2,
                                overflow = TextOverflow.Ellipsis,
                                style = TextStyle(fontWeight = FontWeight.W400),
                                modifier = Modifier.padding(vertical = 4.dp)
                            )
                        }
                    }
                }
        }
    }
}
