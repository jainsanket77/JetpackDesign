package com.example.jetpackdemo.data

import androidx.compose.ui.graphics.Color
import com.example.jetpackdemo.R
import com.example.jetpackdemo.ui.theme.getRandomLiteColor

data class NotificationModel(
    var title: String? = "",
    var body: String? = "",
    var image: Int? = 0,
    var date: String? = "",
    var header: String? = "",
    var isMarkRead: Boolean? = false,
    var backgroundColor: Color? = null,
)

fun getNotificationColor() = getRandomLiteColor(240)

fun getNotifications() = listOf(
    NotificationModel(
        title = "New message from John",
        body = "Hey! How are you doing today?",
        image = R.drawable.ic_message,
        backgroundColor = getNotificationColor(),
        date = "Today"
    ),
    NotificationModel(
        title = "New offer from Amazon",
        body = "Get 20% off your next purchase with code SUMMER20",
        image = R.drawable.ic_discount,
        backgroundColor = getNotificationColor(),
        date = "Today"
    ),
    NotificationModel(
        title = "Your flight is delayed",
        backgroundColor = getNotificationColor(),
        body = "Your flight to New York has been delayed by 2 hours.",
        image = R.drawable.ic_air_plane,
        date = "Today"
    ),
    NotificationModel(
        title = "Upcoming event: Team meeting",
        backgroundColor = getNotificationColor(),
        body = "Don't forget about our team meeting tomorrow at 11:00 AM.",
        image = R.drawable.ic_group,
        date = "Yesterday"
    ),
    NotificationModel(
        title = "New article: The future of AI",
        body = "Check out this interesting article about the future of artificial intelligence.",
        backgroundColor = getNotificationColor(),
        image = R.drawable.ic_web,
        date = "Yesterday"
    ),
    NotificationModel(
        title = "Your order has been shipped",
        body = "Your order from Etsy has been shipped and is expected to arrive on Friday.",
        backgroundColor = getNotificationColor(),
        image = R.drawable.ic_shipping,
        date = "5 days ago"
    ),
    NotificationModel(
        backgroundColor = getNotificationColor(),
        title = "New message from Sarah",
        body = "Hey! I'm going to be in town next week. Let's catch up!",
        image = R.drawable.ic_message,
        date = "2 weeks ago"
    ),
    NotificationModel(
        title = "Upcoming event: Product launch",
        body = "Our new product is launching next month! Stay tuned for more details.",
        backgroundColor = getNotificationColor(),
        image = R.drawable.ic_calendar,
        date = "2 weeks ago"
    ),
    NotificationModel(
        title = "New offer from Nike",
        body = "Get 30% off your next purchase with code NIKE30",
        backgroundColor = getNotificationColor(),
        image = R.drawable.ic_discount,
        date = "1 month ago"
    ),
    NotificationModel(
        title = "Your flight is cancelled",
        body = "Your flight to San Francisco has been cancelled due to weather.",
        backgroundColor = getNotificationColor(),
        image = R.drawable.ic_airplanemode_inactive,
        date = "1 month ago"
    ),
    NotificationModel(
        title = "New article: The ethics of facial recognition",
        body = "This article explores the ethical implications of facial recognition technology.",
        image = R.drawable.ic_web,
        backgroundColor = getNotificationColor(),
        date = "2 months ago"
    )
)
