package com.example.jetpackdemo.ui.composable.tab_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.jetpackdemo.R
import com.example.jetpackdemo.data.getPosts
import com.example.jetpackdemo.ui.theme.getRandomLiteColor

/**
 * Composable function that represents the home screen of the application.
 */
@Composable
fun SearchScreen(navController: NavHostController) {
    var selectedChipIndex by rememberSaveable { mutableIntStateOf(0) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color.White
    ) {
        Column {
            SearchTextField()
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            ShowSearchChipItems(selectedChipIndex,
                onChipClick = { index ->
                    selectedChipIndex = index
                }
            )
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            RecentSearchList()
            HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))
            ShowUserList()
        }
    }
}

@Preview
@Composable
fun SearchScreenPreview() {
    SearchScreen(navController = NavHostController(LocalContext.current))
}

@Preview(showBackground = true)
@Composable
fun RecentSearchList() {
    val recentSearchList = listOf("Dark image", "Paris eiffel tower", "John Doe Posts")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
    ) {
        Text(
            text = "Recent Search",
            color = Color.Gray,
            fontSize = 14.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 4.dp)
        )
        LazyColumn() {
            itemsIndexed(recentSearchList) { _, item ->
                Row {
                    Text(
                        text = item,
                        color = Color.Black,
                        fontSize = 16.sp,
                        style = TextStyle(fontWeight = FontWeight.Medium),
                        modifier = Modifier
                            .padding(vertical = 4.dp)
                            .weight(1F)
                    )
                    Icon(
                        imageVector = Icons.Default.Clear,
                        contentDescription = "ic_notification",
                        tint = Color.Black,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ShowUserList() {
    val postList = getPosts()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp),
    ) {
        Text(
            text = "Explore the users",
            color = Color.Gray,
            fontSize = 14.sp,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(vertical = 8.dp)
        )
        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            horizontalArrangement = Arrangement.spacedBy(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
        ) {
            itemsIndexed(postList) { _, post ->
                Box(
                    Modifier
                        .padding(2.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .fillMaxWidth()
                        .border(width = 0.2.dp, color = Color.LightGray, RoundedCornerShape(8.dp))
                        .background(post.bgColor ?: getRandomLiteColor(from = 236)),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 8.dp, vertical = 13.dp)
                    ) {
                        Text(
                            text = post.name ?: "",
                            color = Color.Black,
                            fontSize = 14.sp,
                            style = TextStyle(fontWeight = FontWeight.SemiBold),
                            modifier = Modifier.padding(horizontal = 6.dp)
                        )
                        Image(
                            painter = rememberAsyncImagePainter(model = post.profileUrl),
                            contentDescription = "Person Description",
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.BottomEnd,
                            modifier = Modifier
                                .padding(top = 18.dp, end = 8.dp)
                                .size(32.dp)
                                .clip(CircleShape)
                                .border(1.dp, Color.Gray, CircleShape)
                                .align(alignment = Alignment.End)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ShowSearchChipItems(
    selectedItemIndex: Int,
    onChipClick: (Int) -> Unit = {}
) {
    val chipsList = listOf("All", "Photos", "Videos", "Posts", "Inbox")
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    ) {
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
fun SearchTextField(onFilterItemClick: (() -> Unit)? = null) {
    var searchText by rememberSaveable { mutableStateOf("") }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 10.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {

        TextField(
            value = searchText,
            modifier = Modifier
                .background(Color.Gray.copy(alpha = 0.5F), RoundedCornerShape(16.dp))
                .weight(1f),
            onValueChange = {
                searchText = it
            },
            textStyle = TextStyle(fontSize = 14.sp),
            leadingIcon = { Icon(Icons.Filled.Search, "Search") },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            label = { Text("What are you looking for?", fontSize = 12.sp) }
        )

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