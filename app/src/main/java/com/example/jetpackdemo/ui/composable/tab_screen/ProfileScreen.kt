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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.jetpackdemo.data.PostModel
import com.example.jetpackdemo.data.getAuthorList
import com.example.jetpackdemo.ui.comonents.toolbars.AppToolbar
import com.example.jetpackdemo.ui.navigation.NavRoute
import com.example.jetpackdemo.ui.theme.getRandomLiteColor

/**
 * Composable function that represents the home screen of the application.
 */
@Composable
fun ProfileScreen(navController: NavHostController) {

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
//            ProfileToolbar(
//                onBackPressed = {
//                    navController.navigateUp()
//                }, onMenuPressed = {
//                })
            AppToolbar(onNotificationClick = {
                navController.navigate(NavRoute.NOTIFICATION.title)
            })
            ShowProfileDetails()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ShowProfileDetails() {
    val index = (1..99).random()
    val personModel = getAuthorList()[index]
    val gender = personModel.gender ?: ""
    val postCounts = (1..19).random()
    val personImage = "https://randomuser.me/api/portraits/$gender/$index.jpg"

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = personModel.name ?: "",
            color = Color.DarkGray,
            fontSize = 32.sp,
            maxLines = 1,
            fontFamily = FontFamily.Monospace,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontWeight = FontWeight.Black),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = personModel.occupation ?: "",
            color = Color.DarkGray.copy(alpha = 0.60F),
            fontSize = 14.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontWeight = FontWeight.Bold),
            modifier = Modifier
                .padding(top = 2.dp)
                .align(Alignment.CenterHorizontally)
        )

        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .padding(horizontal = 12.dp)
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = "23K",
                    color = Color.Black,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontWeight = FontWeight.Black),
                )
                Text(
                    text = "FOLLOWS",
                    color = Color.DarkGray.copy(alpha = 0.70F),
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                )
            }

            Box {
                Image(
                    painter = rememberAsyncImagePainter(model = personImage),
                    contentDescription = "Author Description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(start = 2.dp, top = 2.dp, bottom = 2.dp)
                        .size(100.dp)
                        .clip(CircleShape)
                        .border(1.dp, Color.Gray, CircleShape)
                )
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(vertical = 4.dp)
            ) {
                Text(
                    text = postCounts.toString(),
                    color = Color.Black,
                    fontSize = 16.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontWeight = FontWeight.Black),
                )
                Text(
                    text = "POSTS",
                    color = Color.DarkGray.copy(alpha = 0.70F),
                    fontSize = 12.sp,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    style = TextStyle(fontWeight = FontWeight.Bold),
                )
            }
        }
        ShowProfilePosts(postCounts)
//        RatingBar(rating = 3.7f, spaceBetween = 3.dp)
    }
}

@Composable
fun ShowProfilePosts(count: Int) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
    ) {
        val postList = (1..count).map {
            PostModel(
                contentUrl = "https://picsum.photos/200?random=${(1..30).random() + 1}",
                bgColor = getRandomLiteColor()
            )
        }

        itemsIndexed(postList) { _, item ->
            ElevatedCard {
                Box(
                    Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(item.bgColor ?: Color.LightGray)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        val painter = rememberAsyncImagePainter(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(item.contentUrl)
                                .build()
                        )
                        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                            CircularProgressIndicator()
                        }
                        Image(
                            painter = painter,
                            contentDescription = "Photos Description",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(15.dp))
                        )
                    }
                }
            }
        }
    }
}
