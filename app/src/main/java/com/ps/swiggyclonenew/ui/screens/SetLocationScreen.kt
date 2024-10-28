package com.ps.swiggyclonenew.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        // Top Bar with Back Button and Title
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = {
                    navController.popBackStack()
                } // Go back to the previous screen
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Enter your area or apartment name",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 18.sp),
                color = Color.Black
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Search Bar
        TextField(
            value = "", // Update this with your state
            onValueChange = { /* Update your search query here */ },
            placeholder = {
                Text(text = "Try JP Nagar, Siri Gardenia, etc.", color = Color.Gray)
            },
            leadingIcon = {
                Icon(imageVector = Icons.Default.Search, contentDescription = "Search Icon")
            },
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(8.dp))
                .background(Color(0xFFF5F5F5)),
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                cursorColor = Color.Black // Optional: Set cursor color
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Option 1: Use my current location
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle location click */ }
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Place,
                contentDescription = "Current Location Icon",
                tint = Color(0xFFF86729) // Orange color
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Use my current location",
                color = Color(0xFFF86729), // Orange color
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Arrow Right",
                tint = Color.Gray
            )
        }

        Divider(color = Color(0xFFF5F5F5))

        // Option 2: Add new address
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Handle add new address click */ }
                .padding(vertical = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = Icons.Default.Add,
                contentDescription = "Add New Address Icon",
                tint = Color(0xFFF86729) // Orange color
            )
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "Add new address",
                color = Color(0xFFF86729), // Orange color
                fontSize = 16.sp
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.Favorite,
                contentDescription = "Arrow Right",
                tint = Color.Gray
            )
        }

        Divider(color = Color(0xFFF5F5F5))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLocationScreen() {

//    LocationScreen()
}