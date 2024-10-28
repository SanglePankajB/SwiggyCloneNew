package com.ps.swiggyclonenew.ui.reusables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.ps.swiggyclonenew.R
import com.ps.swiggyclonenew.ui.screens.FoodScreen

@Composable
fun FoodBrandCard(title: String, subTitle: String, imageResource: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp)) // Rounded corners
            .clickable(onClick = onClick)
            .width(130.dp)
            .height(150.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent) // Make background transparent
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Image
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
                    .width(200.dp),
                contentScale = ContentScale.Crop // Adjust as necessary
            )

            // Clickable Heart Icon
            Icon(
                painter = painterResource(id = R.drawable.ic_heart), // Replace with your heart icon resource
                contentDescription = "Favorite",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .clickable { /* Handle click */ }
                    .padding(16.dp), // Padding around the icon
                tint = Color.Red // Set the tint color for the heart icon
            )

            // Text at the bottom left corner
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 4.dp, bottom = 4.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp) // Space between title and subtitle
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp), // Adjust text style as needed
                    modifier = Modifier.padding(0.dp) // No additional padding
                )
                Text(
                    text = subTitle,
                    color = Color.White.copy(alpha = 0.7f), // Slightly less opacity for subtext
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp) // Adjust text style as needed
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFoodBrandCardScreen() {
//    val fakeNavController = rememberNavController() // This will create a fake instance
    FoodBrandCard("RS 100 OFF", "ABOVE RS 199" ,R.drawable.burger) {}
}

