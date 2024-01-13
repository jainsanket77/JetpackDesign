package com.example.jetpackdemo.data

data class TopicItem(
    var name: String? = "",
    var imageUrl: String? = ""
)

fun getTopicItems() = listOf(
    TopicItem("Technology", "https://dummyimage.com/300x200/000/fff.png&text=Technology"),
    TopicItem("Politics", "https://dummyimage.com/300x200/000/fff.png&text=Politics"),
    TopicItem("Science", "https://dummyimage.com/300x200/000/fff.png&text=Science"),
    TopicItem("Health", "https://dummyimage.com/300x200/000/fff.png&text=Health"),
    TopicItem("Business", "https://dummyimage.com/300x200/000/fff.png&text=Business"),
    TopicItem("Entertainment", "https://dummyimage.com/300x200/000/fff.png&text=Entertainment"),
    TopicItem("Sports", "https://dummyimage.com/300x200/000/fff.png&text=Sports"),
    TopicItem("Travel", "https://dummyimage.com/300x200/000/fff.png&text=Travel"),
    TopicItem("Fashion", "https://dummyimage.com/300x200/000/fff.png&text=Fashion"),
    TopicItem("Food", "https://dummyimage.com/300x200/000/fff.png&text=Food")
)