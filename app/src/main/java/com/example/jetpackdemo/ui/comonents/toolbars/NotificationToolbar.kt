package com.example.jetpackdemo.ui.comonents.toolbars

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowLeft
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackdemo.R

@Composable
fun NotificationToolbar(
    count: Int?,
    onBackPressed: (() -> Unit)? = null,
    onReadAllPressed: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        IconButton(
            modifier = Modifier
                .padding(start = 4.dp)
                .size(48.dp)
                .border(1.dp, Color.Gray.copy(alpha = 0.20f), shape = RoundedCornerShape(16.dp)),
            onClick = { onBackPressed?.invoke() }
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowLeft,
                contentDescription = "",
                tint = Color.Black,
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Notifications",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight(500),
                style = MaterialTheme.typography.bodySmall,
                color = Color.Black
            )
            if ((count ?: 0) > 0)
                Text(
                    text = " ${count ?: 0} ",
                    fontSize = 12.sp,
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight(500),
                    color = Color.DarkGray,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .background(Color.DarkGray.copy(alpha = 0.05f), shape = CircleShape)
                        .padding(3.dp)
                )

        }
        IconButton(onClick = { onReadAllPressed?.invoke() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_read_all),
                contentDescription = "ic_read_all",
                tint = Color.Black,
                modifier = Modifier
                    .size(24.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NotificationToolbarPreview() {
    NotificationToolbar(10)
}