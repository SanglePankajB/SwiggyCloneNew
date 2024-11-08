package com.ps.swiggyclonenew.ui.reusables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material3.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.ps.swiggyclonenew.R

@Composable
fun RestaurantBrandCard(
    title: String,
    rating: String,
    timeToServe: String,
    subTitle: String? = null,
    location: String,
    deliveryType: String? = null,
    img: String,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
    ) {
        FoodBrandCard2("RS 100 OFF", "ABOVE RS 199", img) {}

        // Description Section below the image
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp), // Padding for the text section
            verticalArrangement = Arrangement.spacedBy(4.dp) // Space between each line
        ) {
            Text(
                text = title,
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ), // Title style
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Rating Icon
                Image(
                    painter = painterResource(id = R.drawable.ic_rating),
                    contentDescription = "Rating Star",
                    modifier = Modifier.size(16.dp) // Set the size of the rating star
                )
                Spacer(modifier = Modifier.width(4.dp)) // Space between star and rating text
                Text(
                    text = "$rating · $timeToServe mins",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold), // Rating and time style
                    maxLines = 1
                )
            }

            subTitle?.let {
                Text(
                    text = subTitle,
                    color = Color.Black.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp), // Subtitle style
                    maxLines = 1
                )
            }
            Text(
                text = location,
                color = Color.Gray,
                style = MaterialTheme.typography.bodySmall, // Location style
                maxLines = 2,
            )
            Spacer(modifier = Modifier.height(4.dp))
            deliveryType?.let {
            DisabledButton(
                "FREE DELiVERY",
                modifier = Modifier.size(width = 80.dp, height = 20.dp)
            )
            }
        }
    }
}

@Composable
fun RestaurantBrandCard2(
    title: String,
    rating: String,
    timeToServe: String,
    subTitle: String? = null,
    location: String,
    deliveryType: String? = null,
    img: String,
    modifier: Modifier,
    onClick: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(start = 16.dp)
    ) {
        FoodBrandCard2("RS 100 OFF", "ABOVE RS 199", img) {}

        // Description Section below the image
        Column(
            modifier = Modifier
                .fillMaxWidth(), // Padding for the text section
            verticalArrangement = Arrangement.spacedBy(4.dp) // Space between each line
        ) {
            Text(
                text = title,
                color = Color.Black,
                style = MaterialTheme.typography.headlineSmall.copy(
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                ), // Title style
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                // Rating Icon
                Image(
                    painter = painterResource(id = R.drawable.ic_rating),
                    contentDescription = "Rating Star",
                    modifier = Modifier.size(16.dp) // Set the size of the rating star
                )
                Spacer(modifier = Modifier.width(4.dp)) // Space between star and rating text
                Text(
                    text = "$rating · $timeToServe mins",
                    color = Color.Gray,
                    style = MaterialTheme.typography.bodySmall.copy(fontWeight = FontWeight.Bold), // Rating and time style
                    maxLines = 1
                )
            }

            subTitle?.let {
                Text(
                    text = subTitle,
                    color = Color.Black.copy(alpha = 0.7f),
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp), // Subtitle style
                    maxLines = 1
                )
            }
        }
    }
}


@Composable
fun DisabledButton(
    text: String,
    gradientStartColor: Color? = null,
    textColor: Color? = null,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = { /* Do nothing since it's disabled */ },
        modifier = modifier,
        enabled = false, // Disable the button
        elevation = ButtonDefaults.buttonElevation(0.dp), // No elevation
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent // Make the container transparent
        )
    ) {
        // Gradient background with Box
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            gradientStartColor ?: Color(0xFFABA3CC), // Start color
                            Color(0xFFFAF7F7)  // End color
                        )
                    )
                ),
            contentAlignment = Alignment.Center // Center text inside the box
        ) {
            Text(
                text = text,
                color = textColor ?: Color(0xFF00238B), // Dark blue text
                style = MaterialTheme.typography.bodySmall.copy(
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 8.sp // Small font size
                ),
                maxLines = 1,
                letterSpacing = .06.em
            )
        }
    }
}

