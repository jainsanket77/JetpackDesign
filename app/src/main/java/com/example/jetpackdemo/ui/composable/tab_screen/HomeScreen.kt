package com.example.jetpackdemo.ui.composable.tab_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MailOutline
import androidx.compose.material.icons.outlined.Send
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.jetpackdemo.R
import com.example.jetpackdemo.data.PostModel
import com.example.jetpackdemo.data.getAuthorList
import com.example.jetpackdemo.data.getPosts
import com.example.jetpackdemo.data.getTopicItems
import com.example.jetpackdemo.ui.comonents.toolbars.AppToolbar
import com.example.jetpackdemo.ui.navigation.NavRoute
import com.example.jetpackdemo.ui.theme.getRandomLiteColor

/**
 * Composable function that represents the home screen of the application.
 */
@Composable
fun HomeScreen(navController: NavHostController) {
    var selectedTabItem by rememberSaveable { mutableStateOf("All") }
    var showFilterSheet by remember { mutableStateOf(false) }

    if (showFilterSheet) {
        FilterBottomSheet() {
            showFilterSheet = false
        }
    }
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
            AppToolbar(onNotificationClick = {
                navController.navigate(NavRoute.NOTIFICATION.title)
            })
            HomeTextTabs(
                selectedTabItem,
                onTabItemClick = {
                    if (!it.isNullOrEmpty()) selectedTabItem = it
                }, onFilterItemClick = {
                    showFilterSheet = true
                })

            when (selectedTabItem) {
                "All" -> ShowAllItems()
                "Photos" -> ShowPhotos()
                "Videos" -> ShowVideos()
                "Posts" -> ShowPosts()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeTextTabs(
    selectedTabItem: String,
    onTabItemClick: ((String?) -> Unit)? = null,
    onFilterItemClick: (() -> Unit)? = null
) {
    val tabs = listOf("All", "Photos", "Videos", "Posts")
    val tabIndex = tabs.indexOfFirst { it == selectedTabItem }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LazyRow(modifier = Modifier.wrapContentWidth()) {
            items(tabs.size) { index ->
                ClickableText(
                    text = AnnotatedString(tabs[index]),
                    style = TextStyle(
                        color = if (index == tabIndex) Color.Black else Color.Gray,
                        fontSize = 16.sp,
                        fontWeight = if (index == tabIndex) FontWeight.SemiBold else FontWeight.Normal
                    ),
                    modifier = Modifier
                        .drawBehind {
                            val strokeWidthPx = 2.dp.toPx()
                            val verticalOffset = size.height - 2.sp.toPx()
                            if (index == tabIndex)
                                drawLine(
                                    color = Color.Black,
                                    strokeWidth = strokeWidthPx,
                                    start = Offset(0f, verticalOffset),
                                    end = Offset(size.width, verticalOffset)
                                )
                        }
                        .padding(8.dp),
                    onClick = {
                        onTabItemClick?.invoke(tabs[index])
                    }
                )
            }
        }
        IconButton(onClick = {
            onFilterItemClick?.invoke()
        }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_filter),
                contentDescription = "ic_notification",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
    }
}

@Composable
fun ShowAllItems() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp
    ) {
        val allItemList = (0..50).map {
            PostModel(
                contentUrl = "https://picsum.photos/200?random=${it + 1}",
                size = (100..200).random(),
                bgColor = getRandomLiteColor()
            )
        }
        itemsIndexed(allItemList) { i, item ->
//            val height = (100..200).random()
//            val randomLiteColor = getRandomLiteColor()
            Box(
                Modifier
                    .padding(2.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .height((item.size ?: 200).dp)
                    .background(item.bgColor ?: Color.LightGray),
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    val painter = rememberAsyncImagePainter(
                        model = ImageRequest.Builder(LocalContext.current).data(item.contentUrl).build()
                    )
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                    Image(
                        painter = painter,
                        contentDescription = "Photos Description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
            }
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun ShowPosts() {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalItemSpacing = 8.dp
    ) {
        val postList = getPosts()
        postList.forEach {
            it.bgColor = getRandomLiteColor(240)
        }
        itemsIndexed(postList) { _, post ->
//            val post = postList[i]
            Box(
                Modifier
                    .padding(2.dp)
                    .clip(RoundedCornerShape(15.dp))
                    .fillMaxWidth()
                    .background(post.bgColor ?: getRandomLiteColor()),
            ) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(
                            painter = rememberAsyncImagePainter(model = post.profileUrl),
                            contentDescription = "Person Description",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .padding(start = 6.dp)
                                .size(32.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Gray, CircleShape)
                        )
                        Text(
                            text = post.name ?: "",
                            color = Color.Black,
                            fontSize = 14.sp,
                            style = TextStyle(fontWeight = FontWeight.SemiBold),
                            modifier = Modifier.padding(horizontal = 6.dp)
                        )
                    }
                    Text(
                        text = post.caption ?: "",
                        color = Color.Black.copy(alpha = 0.70f),
                        fontSize = 16.sp,
                        style = TextStyle(fontWeight = FontWeight.Medium),
                        modifier = Modifier.padding(horizontal = 6.dp, vertical = 10.dp)
                    )

                    if ((post.likes ?: 0) > 0 || (post.replies ?: 0) > 0) {
                        val likeReplies: String = if ((post.replies ?: 0) > 0 && (post.likes ?: 0) > 0)
                            "${post.replies} reply  ●  ${post.likes} likes"
                        else if ((post.replies ?: 0) > 0)
                            "${post.replies} reply"
                        else
                            "${post.likes} likes"

                        Text(
                            text = likeReplies,
                            color = Color.Black.copy(alpha = 0.40f),
                            fontSize = 14.sp,
                            style = TextStyle(fontWeight = FontWeight.Medium),
                            modifier = Modifier.padding(horizontal = 6.dp, vertical = 10.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShowVideos() {
    LazyColumn {
        itemsIndexed((0..50).toList()) { i, item ->
            val randomLiteColor = getRandomLiteColor()
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://picsum.photos/300/500?random=${i + 1}")
                    .build()
            )
            Box(
                Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .height(500.dp)
                    .background(randomLiteColor),
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                    Image(
                        painter = painter,
                        contentDescription = "Photos Description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                AuthorView()
                Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                    ActionButtonView()
                }
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(color = Color.Black.copy(alpha = 0.6f))
                        .align(Alignment.BottomStart)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_volume_up),
                        tint = Color.White, contentDescription = "",
                        modifier = Modifier.padding(6.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowPhotos() {
    LazyColumn {
        itemsIndexed((0..50).toList()) { i, item ->
            val randomLiteColor = getRandomLiteColor()
            val painter = rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://picsum.photos/200/300?random=${i + 1}")
                    .build()
            )
            Box(
                Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .fillMaxWidth()
                    .height(250.dp)
                    .background(randomLiteColor),
            ) {
                Box(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                        CircularProgressIndicator()
                    }
                    Image(
                        painter = painter,
                        contentDescription = "Photos Description",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                AuthorView()
                Box(modifier = Modifier.align(Alignment.BottomEnd)) {
                    ActionButtonView()
                }
            }
        }
    }
}

@Composable
fun AuthorView() {
    val index = (1..99).random()
    val personModel = getAuthorList()[index]
    val personName = personModel.name ?: ""
    val gender = personModel.gender ?: ""
    val personImage = "https://randomuser.me/api/portraits/$gender/$index.jpg"
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(color = Color.White),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = rememberAsyncImagePainter(model = personImage),
            contentDescription = "Author Description",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                .size(32.dp)
                .clip(CircleShape)
                .border(1.dp, Color.Gray, CircleShape)
        )
        Text(
            text = personName, style = TextStyle(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(start = 4.dp, end = 6.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ActionButtonView() {
    Row(
        modifier = Modifier
            .padding(horizontal = 8.dp, vertical = 8.dp)
            .clip(RoundedCornerShape(32.dp))
            .background(color = Color.Black.copy(alpha = 0.3f)),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder, contentDescription = "",
            tint = Color.White, modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
        )
        Icon(
            imageVector = Icons.Outlined.MailOutline, contentDescription = "",
            tint = Color.White, modifier = Modifier.padding(horizontal = 8.dp, vertical = 6.dp)
        )
        Icon(
            imageVector = Icons.Outlined.Send, contentDescription = "",
            tint = Color.White, modifier = Modifier.padding(horizontal = 10.dp, vertical = 6.dp)
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        FilterList()
    }
}

@Preview(showBackground = true)
@Composable
fun FilterList() {
    LazyColumn {
        items(getTopicItems()) { topic ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = topic.imageUrl),
                    contentDescription = "Topic Description",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .padding(vertical = 4.dp, horizontal = 8.dp)
                        .size(50.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Gray, CircleShape)
                )
                Text(
                    text = topic.name ?: "",
                    fontSize = 18.sp,
                    modifier = Modifier.padding(end = 20.dp)
                )
            }
        }
    }

}


@OptIn(ExperimentalLayoutApi::class)
@Composable
fun HomeTabs() {
    var tabIndex by rememberSaveable { mutableIntStateOf(0) }

    val tabs = listOf("All", "Photos", "Videos", "Photos")

    FlowRow(modifier = Modifier.padding(8.dp)) {
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = Color.White,
            modifier = Modifier.wrapContentSize(),
            divider = {}
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index },
                )
            }
        }
        when (tabIndex) {
            0 -> {}
            1 -> {}
            2 -> {}
            3 -> {}
        }
    }
}