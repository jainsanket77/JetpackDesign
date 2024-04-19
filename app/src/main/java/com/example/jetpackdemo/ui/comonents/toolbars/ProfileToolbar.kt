package com.example.jetpackdemo.ui.comonents.toolbars

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackdemo.R

@Composable
fun ProfileToolbar(
    onMenuPressed: (() -> Unit)? = null,
    onNotificationPressed: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(onClick = { onMenuPressed?.invoke() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_menu),
                contentDescription = "ic_menu",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .border(2.dp, Color.Black, shape = CircleShape)
                    .padding(4.dp)
            )
        }

        IconButton(onClick = { onNotificationPressed?.invoke() }) {
            Icon(
                Icons.Outlined.Notifications,
                contentDescription = "ic_notification",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
                    .border(2.dp, Color.Black, shape = CircleShape)
                    .padding(4.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProfileToolbarPreview() {
    ProfileToolbar()
}