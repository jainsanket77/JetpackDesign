package com.example.jetpackdemo.data

import androidx.compose.ui.graphics.Color

data class PostModel(
    var id: Int? = 0,
    var name: String? = "",
    var profileUrl: String? = "",
    var caption: String? = "",
    var replies: Int? = 0,
    var likes: Int? = 0,
    var bgColor: Color? = null,
    var contentUrl: String? = "",
    var size: Int? = 0,
)

fun getPosts() = listOf(
    PostModel(
        name = "John Doe",
        profileUrl = "https://randomuser.me/api/portraits/men/1.jpg",
        caption = "Enjoying a beautiful day at the beach!"
    ),
    PostModel(
        name = "Jane Smith",
        likes = 256,
        replies = 49,
        profileUrl = "https://randomuser.me/api/portraits/women/2.jpg",
        caption = "Just got a new puppy! His name is Charlie and he's the cutest thing ever!"
    ),
    PostModel(
        name = "Michael Jones",
        profileUrl = "https://randomuser.me/api/portraits/men/3.jpg",
        caption = "Just finished a marathon! I'm so proud of myself!",
        replies = 1,
    ),
    PostModel(
        name = "Sarah Miller",
        likes = 108,
        replies = 27,
        profileUrl = "https://randomuser.me/api/portraits/women/4.jpg",
        caption = "Just got engaged to the love of my life! I'm so happy!"
    ),
    PostModel(
        name = "David Williams",
        likes = 89,
        profileUrl = "https://randomuser.me/api/portraits/men/5.jpg",
        caption = "Just graduated from college! I'm so excited to start my new job!"
    ),
    PostModel(
        name = "Jessica Brown",
        profileUrl = "https://randomuser.me/api/portraits/women/6.jpg",
        caption = "Just bought a new house! I'm so excited to move in!",
    ),
    PostModel(
        name = "Matthew Davis",
        profileUrl = "https://randomuser.me/api/portraits/men/7.jpg",
        caption = "Just got a promotion at work! I'm so proud of myself!"
    ),
    PostModel(
        name = "Ashley Green",
        likes = 135,
        profileUrl = "https://randomuser.me/api/portraits/women/8.jpg",
        caption = "Just had a baby! I'm so in love with my little one!"
    ),
    PostModel(
        name = "James Rodriguez",
        profileUrl = "https://randomuser.me/api/portraits/men/9.jpg",
        caption = "Just won a lottery! I'm so excited to start my new life!"
    ),
    PostModel(
        name = "Isabella Garcia",
        profileUrl = "https://randomuser.me/api/portraits/women/10.jpg",
        likes = 177,
        replies = 12,
        caption = "Just got a new car! I'm so excited to drive it!"
    ),
    PostModel(
        replies = 1,
        name = "Daniel Johnson",
        profileUrl = "https://randomuser.me/api/portraits/men/11.jpg",
        caption = "Just started a new business! I'm so excited to see it grow!"
    ),
    PostModel(
        name = "Emily Wilson",
        profileUrl = "https://randomuser.me/api/portraits/women/12.jpg",
        caption = "Just got a new job! I'm so excited to start my new career!"
    ),
    PostModel(
        name = "Robert Smith",
        profileUrl = "https://randomuser.me/api/portraits/men/13.jpg",
        caption = "Just bought a new boat! I'm so excited to take it out on the water!"
    ),
    PostModel(
        name = "Mary Johnson",
        profileUrl = "https://randomuser.me/api/portraits/women/14.jpg",
        replies = 5,
        caption = "Just got a new tattoo! I'm so happy with the way it turned out!"
    ),
    PostModel(
        name = "Christopher Williams",
        profileUrl = "https://randomuser.me/api/portraits/men/15.jpg",
        caption = "Just got a new haircut! I'm feeling so fresh!"
    ),
    PostModel(
        name = "Amanda Brown",
        profileUrl = "https://randomuser.me/api/portraits/women/16.jpg",
        caption = "Just got a new pet! I'm so excited to have a furry friend!"
    ),
)