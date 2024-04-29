package com.example.jetpackdemo.data

import androidx.compose.ui.graphics.Color

data class Inbox(
    var name: String? = "",
    var title: String? = "",
    var body: String? = "",
    var icon: Int? = null,
    var date: String? = "",
    var header: String? = "",
    val category: String? = "",
    var isMarkRead: Boolean? = false,
    var backgroundColor: Color? = null,
)

fun getInboxList() = listOf(
    Inbox(header = "Today"),
    Inbox(
        name = "John Doe",
        title = "New message from John Doe",
        body = "Hi there, I'm reaching out to you today to...",
        date = "10:00 PM",
        category = "Entertainment",
        isMarkRead = false,
    ),
    Inbox(
        name = "David Johnson",
        title = "Dinner invitation",
        body = "Would you like to join me for dinner on Saturday?",
        date = "05:15 PM",
        category = "Social",
        isMarkRead = false
    ),
    Inbox(
        name = "Jane Doe",
        title = "Meeting reminder",
        body = "Don't forget about our meeting tomorrow at 10:00 AM.",
        date = "11:46 PM",
        category = "Work",
        isMarkRead = true,
    ),
    Inbox(header = "2 days ago"),
    Inbox(
        name = "Acme Corporation",
        title = "New invoice",
        body = "Please find attached your invoice for the month of January.",
        date = "19 May 23, 11:00 PM",
        category = "Spam",
        isMarkRead = false,
    ),
    Inbox(
        name = "Sarah Smith",
        title = "Lunch invitation",
        body = "Would you like to join me for lunch on Friday?",
        date = "19 May 23, 09:46 PM",
        category = "Social",
        isMarkRead = true,
    ),
    Inbox(
        name = "Michael Jones",
        title = "Project update",
        body = "I've attached the latest project update for your review.",
        date = "19 May 23, 10:00 AM",
        category = "Work",
        isMarkRead = false,
    ),
    Inbox(
        name = "Lisa Brown",
        title = "Happy birthday!",
        body = "Wishing you a very happy birthday!",
        date = "19 May 23, 08:36 AM",
        category = "Social",
        isMarkRead = true,
    ),
    Inbox(header = "1 week ago"),
    Inbox(
        name = "Emily Wilson",
        title = "Movie recommendation",
        body = "I saw a great movie last night, I think you'd really enjoy it.",
        date = "13 May 23, 09:46 PM",
        category = "Entertainment",
        isMarkRead = true
    ),
    Inbox(
        name = "Robert Smith",
        title = "Work progress report",
        body = "I've made significant progress on the project this week.",
        date = "12 May 23, 04:46 PM",
        category = "Work",
        isMarkRead = false
    ),
    Inbox(
        name = "David Johnson",
        title = "Dinner invitation",
        body = "Would you like to join me for dinner on Saturday?",
        date = "10 May 23, 12:46 AM",
        category = "Social",
        isMarkRead = false
    ),
    Inbox(
        name = "Emily Wilson",
        title = "Movie recommendation",
        body = "I saw a great movie last night, I think you'd really enjoy it.",
        date = "10 May 23, 10:46 AM",
        category = "Entertainment",
        isMarkRead = true
    ),
    Inbox(header = "2 weeks ago"),
    Inbox(
        name = "Robert Smith",
        title = "Work progress report",
        body = "I've made significant progress on the project this week.",
        date = "7 May 23, 12:00 AM",
        category = "Work",
        isMarkRead = false
    ),
    Inbox(header = "3 weeks ago"),
    Inbox(
        name = "Karen Brown",
        title = "Upcoming event",
        body = "Don't forget about the upcoming event next week.",
        date = "1 May 23, 03:32 PM",
        category = "Events",
        isMarkRead = true
    ),
    Inbox(header = "1 month ago"),
    Inbox(
        name = "Michael Jones",
        title = "New job opportunity",
        body = "I heard about a job opportunity that might be a good fit for you.",
        date = "26 Apr 23, 08:49 PM",
        category = "Career",
        isMarkRead = false
    ),
    Inbox(header = "2 month ago"),
    Inbox(
        name = "Sarah Miller",
        title = "Travel plans",
        body = "I'm planning a trip next month, would you like to come with me?",
        date = "13 Mar 23, 04:56 AM",
        category = "Travel",
        isMarkRead = true
    ),
    Inbox(
        name = "William Davis",
        title = "Book recommendation",
        body = "I've been reading a great book lately, I think you'd really enjoy it.",
        date = "10 Mar 23, 11:06 PM",
        category = "Books",
        isMarkRead = false
    ),
    Inbox(
        name = "Jennifer Wilson",
        title = "Health advice",
        body = "I've been feeling under the weather lately, do you have any advice?",
        date = "7 Mar 23, 04:12 PM",
        category = "Health",
        isMarkRead = true
    ),
    Inbox(header = "3 month ago"),
    Inbox(
        name = "Christopher Smith",
        title = "Financial advice",
        body = "I'm looking for some financial advice, do you have any recommendations?",
        date = "27 Feb 23, 07:46 PM",
        category = "Finance",
        isMarkRead = false
    ),
    Inbox(
        name = "Amanda Johnson",
        title = "Home improvement tips",
        body = "I'm planning to do some home improvements, do you have any tips?",
        date = "14 Feb 23, 10:04 AM",
        category = "Home",
        isMarkRead = true
    )
)