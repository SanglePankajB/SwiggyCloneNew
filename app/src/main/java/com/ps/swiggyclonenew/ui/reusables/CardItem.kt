package com.ps.swiggyclonenew.ui.reusables

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.PermissionChecker.PermissionResult
import com.ps.swiggyclonenew.R

@Composable
fun CardItem(title: String, subtitle1: String, subtitle2: String, imageResource: Int, onClick:()->Unit) {
    Card(
        modifier = Modifier
            .size(175.dp) // Fixed size for square cards
            .clip(RoundedCornerShape(24.dp)) // Rounded corners
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(start = 16.dp, top = 16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            // Title
            BasicText(
                text = title,
                style = MaterialTheme.typography.titleLarge.copy(
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    fontSize = 16.sp
                ),
                maxLines = 1,
                modifier = Modifier.padding(end = 16.dp)
            )
            // Subtitle 1
            BasicText(
                text = subtitle1,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color.Gray
                )
            )
            // Subtitle 2
//            BasicText(
//                text = subtitle2,
//                style = MaterialTheme.typography.bodyMedium.copy(
//                    color = Color(0xFFFFA500) // Orange color
//                )
//            )
            DisabledButton(subtitle2, Color(0xFFF3A880), Color(0xFFF84E19),modifier = Modifier.size(width = 80.dp, height = 20.dp))

            // Image at the bottom right
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier
                    .size(60.dp)
                    .align(Alignment.End) // Align image to the bottom end of the card
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun showCard(){
    CardItem(
        title = "DINEOUT",
        subtitle1 = "SUBTITLE THREE",
        subtitle2 = "FLAT 50% OFF",
        imageResource = R.drawable.ic_cart_filled,
        onClick = {}
    )
}
