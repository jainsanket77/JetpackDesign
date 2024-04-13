package com.example.jetpackdemo.ui.comonents.toolbars

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
fun AppToolbar(
    onNotificationClick: () -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
//            text = stringResource(id = R.string.app_name).lowercase(),
            text = "Demo",
            fontSize = 32.sp,
            textAlign = TextAlign.Center,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight(900),
            style = MaterialTheme.typography.bodyLarge,
            color = Color.Black
        )
        IconButton(onClick = { onNotificationClick.invoke() }) {
            Icon(
                painter = painterResource(id = R.drawable.ic_notification2),
                contentDescription = "ic_notification",
                tint = Color.Black,
                modifier = Modifier.size(32.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AppToolbarPreview() {
    AppToolbar(onNotificationClick = {
        Log.d("TAG", "Notification click")
    })
}