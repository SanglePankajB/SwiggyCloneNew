package com.ps.swiggyclonenew.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController:NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        // Top bar with back arrow and Help button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {
                // Use navController to navigate to the LoginScreen
                navController.navigate("home")
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

            TextButton(onClick = { /* Handle Help action */ }) {
                Text(text = "Help", color = Color(0xFFFF5722)) // Light orange background
            }
        }

        LazyColumn {
            // User Info Section
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp)
                ) {
                    Text(
                        text = "PANKAJ SANGLE",
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold
                        ),
                        color = Color.Black
                    )
                    Text(
                        text = "+91 - 9309747109",
                        style = MaterialTheme.typography.titleMedium,
                        color = Color.Gray
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Edit Profile Button
                    TextButton(onClick = { /* Handle Edit Profile click */ }) {
                        Text(
                            text = "Edit Profile",
                            color = Color(0xFFFF5722), // Swiggy Orange color
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Edit Profile",
                            tint = Color(0xFFFF5722)
                        )
                    }
                }
            }
            item {
                Divider(color = Color.LightGray, thickness = 1.dp)
            }
            item {
                // Membership Card
                MembershipCard()
            }

            item {
                // List of profile options
                ProfileOptionItem(
                    title = "Swiggy HDFC Bank Credit Card",
                    subtitle = "Apply for the card and start earning cashbacks!",
                    onClick = { /* Handle click */ }
                )
                ProfileOptionItem(
                    title = "My Account",
                    subtitle = "Favourites, Hidden restaurants & Settings",
                    onClick = { /* Handle click */ }
                )
                ProfileOptionItem(
                    title = "My Eatlists",
                    subtitle = "View all your saved lists in one place",
                    showNewBadge = true,
                    onClick = { /* Handle click */ }
                )
                ProfileOptionItem(
                    title = "Addresses",
                    subtitle = "Share, Edit & Add New Addresses",
                    onClick = { /* Handle click */ }
                )
                ProfileOptionItem(
                    title = "Payments & Refunds",
                    subtitle = "Refund Status & Payment Modes",
                    onClick = { /* Handle click */ }
                )
                ProfileOptionItem(
                    title = "Swiggy Money & Gift Cards",
                    subtitle = "Account balance, Gift cards & Transaction History",
                    onClick = { /* Handle click */ }
                )
                ProfileOptionItem(
                    title = "Logout",
                    subtitle = "",
                    onClick = {
                        navController.navigate("login")
                    }
                )
            }
        }
    }
}

@Composable
fun MembershipCard() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            Text(
                text = "one membership",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = Color.Black
            )
            Spacer(modifier = Modifier.weight(1f))
            Button(
                modifier = Modifier.size(60.dp, 20.dp),
                onClick = { /* Handle Buy Now */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFBD9064)),
                contentPadding = PaddingValues(0.dp)

            ) {
                Text(text = "BUY NOW", color = Color.White, fontSize = 8.sp)
            }
        }
        Text(
            text = "Unlock UNLIMITED Free Deliveries on Food & Instamart. Buy Swiggy One",
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Gray
        )
        Divider(color = Color.LightGray, thickness = 1.dp, modifier = Modifier.padding(top = 8.dp))
    }
}

@Composable
fun ProfileOptionItem(
    title: String,
    subtitle: String,
    showNewBadge: Boolean = false,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge, color = Color.Black)
            if (showNewBadge) {
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "NEW",
                    color = Color(0xFFFF6D00),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                imageVector = Icons.Default.KeyboardArrowRight,
                contentDescription = "Arrow Right",
                tint = Color.Black
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(text = subtitle, style = MaterialTheme.typography.bodyMedium, color = Color.Gray)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProfileScreen() {
    val fakeNavController = rememberNavController()
    ProfileScreen(fakeNavController)
}