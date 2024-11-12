package com.ps.swiggyclonenew.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ps.swiggyclonenew.R
import com.ps.swiggyclonenew.intent.MyIntent
import com.ps.swiggyclonenew.ui.SwiggyTopBar2
import com.ps.swiggyclonenew.ui.lottieanim.YummyAnim
import com.ps.swiggyclonenew.ui.reusables.CardItem
import com.ps.swiggyclonenew.ui.reusables.SearchBar

@Composable
fun SwiggyMainScreen(
    navController:NavController,
    userIntent:(MyIntent)->Unit
)
{
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFF5F5F5)),
        verticalArrangement = Arrangement.Top
    ) {
        // Add a scrollable container
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
        ) {
            item {
                SwiggyTopBar2(navController = navController, 16.dp)
            }
            item {
                Spacer(modifier = Modifier.height(8.dp)) // Space before cards
            }

            item {
                SearchBar(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    onSearch = { query ->
                        userIntent.invoke(
                            MyIntent.Search(query)
                        )
                        navController.navigate("filterscreen")
                        println("Search query: $query")
                    }
                )
            }

            // Add some space before the cards
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(140.dp)
                    ) {
                        YummyAnim(modifier = Modifier)
                    }
                }
            }

            // Cards Layout
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp), // Padding for the cards
                    verticalArrangement = Arrangement.spacedBy(16.dp) // Space between rows
                ) {
                    // Row for first two cards
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween // Space cards evenly
                    ) {
                        CardItem(
                            title = "FOOD DELIVERY",
                            subtitle1 = "WILD WEDNESDAY",
                            subtitle2 = "BUY 1 GET1 FREE",
                            imageResource = R.drawable.fooditem,
                            onClick = {navController.navigate("food")}
                        )

                        CardItem(
                            title = "INSTAMART",
                            subtitle1 = "GET ANYTHING INSTANTLY",
                            subtitle2 = "FREE DEAL AT 49",
                            imageResource = R.drawable.ic_cart_filled,
                            onClick = {navController.navigate("instamart")}
                        )
                    }

                    // Row for second two cards
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween // Space cards evenly
                    ) {
                        CardItem(
                            title = "DINEOUT",
                            subtitle1 = "SUBTITLE THREE",
                            subtitle2 = "FLAT 50% OFF",
                            imageResource = R.drawable.ic_cart_filled,
                            onClick = {navController.navigate("dineout")}
                        )

                        CardItem(
                            title = "GENIE",
                            subtitle1 = "PICK-UP & DROP",
                            subtitle2 = "Subtitle Orange",
                            imageResource = R.drawable.ic_cart_filled, // Replace with your image resource
                            onClick = {navController.navigate("genie")}
                        )
                    }
                }
            }

            // Placeholder for other UI components
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp), // Padding around the content
                    contentAlignment = Alignment.Center
                ) {
                    Column() {
                        Image(
                            painter = painterResource(id = R.drawable.liveitup), // Replace with your image resource
                            contentDescription = "Description of the image",
                            modifier = Modifier
                                .size(200.dp) // Set the desired size of the image
                                .clip(RoundedCornerShape(8.dp)) // Optional: Add rounded corners to the image
                        )
                        Text(
                            text = "Crafted with love in Mindstix, India",
                            style = MaterialTheme.typography.bodyMedium.copy(
                                fontSize = 20.sp, // Set the desired font size
                                color = Color.Gray // Set the text color to gray
                            ),
                            modifier = Modifier.padding(8.dp) // Optional: Add padding around the text
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSwiggyTopBar() {
    val fakeNavController = rememberNavController() // This will create a fake instance
//    SwiggyMainScreen(navController = fakeNavController)
}