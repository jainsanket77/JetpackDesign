package com.example.jetpackdemo.ui.composable.tab_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.jetpackdemo.R
import com.example.jetpackdemo.data.Inbox
import com.example.jetpackdemo.data.getInboxList
import com.example.jetpackdemo.ui.theme.getRandomColor

/**
 * Composable function that represents the home screen of the application.
 */


@Composable
fun InboxScreen(navController: NavHostController) {
    val chipsList = listOf("All", "Inbox", "Sent", "Drafts", "Spam")
    var selectedChipIndex by rememberSaveable { mutableStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
//            AppToolbar(onNotificationClick = {
//                navController.navigate(NavRoute.NOTIFICATION.title)
//            })
            Text(
                text = "Inbox",
                color = Color.Black,
                fontSize = 40.sp,
                maxLines = 1,
                fontFamily = FontFamily.SansSerif,
                overflow = TextOverflow.Ellipsis,
                style = TextStyle(fontWeight = FontWeight.Black),
            )
            Spacer(modifier = Modifier.padding(top = 12.dp))
            ChipInboxes(
                chipsList = chipsList,
                selectedItemIndex = selectedChipIndex,
                onChipClick = { index ->
                    selectedChipIndex = index
                },
            )
            ShowInboxList()
        }
    }
}

@Composable
fun ChipInboxes(
    chipsList: List<String>,
    selectedItemIndex: Int,
    onChipClick: (Int) -> Unit = {}
) {
    LazyRow {
        itemsIndexed(chipsList) { index, item ->
            FilterChip(
                label = {
                    Text(item, color = Color.Black)
                },
                selected = selectedItemIndex == index,
                onClick = {
                    onChipClick(index)
                },
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }
}

@Composable
fun ShowInboxList(
    onInboxItemClicks: ((Inbox) -> Unit)? = null
) {
    val inboxList = getInboxList()
//    val inboxList = groupInboxList.flatMap { (date, notification) ->
//        listOf(Inbox(header = date)) + notification
//    }
    inboxList.forEach {
        if (it.category.equals("Spam", ignoreCase = true)) {
            it.backgroundColor = Color.Red.copy(alpha = 0.16F)
            it.icon = R.drawable.ic_report
        } else
            it.backgroundColor = getRandomColor(it.title ?: "")
    }

    LazyColumn(
        modifier = Modifier.padding(top = 12.dp)
    ) {
        itemsIndexed(inboxList) { _, item ->
            if (!item.header.isNullOrEmpty())
                Text(
                    text = item.header ?: "",
                    color = Color.Black,
                    fontSize = 20.sp,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                    modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
                )
            else
                ElevatedCard(
                    onClick = {
                        onInboxItemClicks?.invoke(item)
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
                        if (item.icon != null)
                            Box(
                                modifier = Modifier
                                    .padding(end = 10.dp)
                            ) {
                                Image(
                                    painter = painterResource(id = item.icon ?: R.drawable.ic_notification),
                                    contentDescription = "Inbox icon",
                                    colorFilter = ColorFilter.tint(Color.Red),
                                    contentScale = ContentScale.Crop,
                                    alignment = Alignment.Center
                                )
                            }
                        Column {
                            Text(
                                text = item.title ?: "",
                                color = Color.Black,
                                fontSize = 18.sp,
                                style = TextStyle(fontWeight = FontWeight.Bold),
                                modifier = Modifier.padding(vertical = 2.dp)
                            )
                            Text(
                                text = item.body ?: "",
                                color = Color.Gray,
                                fontSize = 15.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = TextStyle(fontWeight = FontWeight.W400),
                                modifier = Modifier.padding(vertical = 2.dp)
                            )
                            Text(
                                text = item.date ?: "",
                                color = Color.Gray,
                                fontSize = 14.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = TextStyle(fontWeight = FontWeight.W400),
                                modifier = Modifier.padding(vertical = 2.dp)
                            )
                        }
                    }
                }
        }
    }

}

@Preview(showBackground = true)
@Composable
fun InboxScreenPreview() {
    InboxScreen(navController = NavHostController(LocalContext.current))
}