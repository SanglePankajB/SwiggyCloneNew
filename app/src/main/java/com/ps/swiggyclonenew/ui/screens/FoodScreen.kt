package com.ps.swiggyclonenew.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ps.swiggyclonenew.R
import com.ps.swiggyclonenew.ui.SwiggyTopBar
import com.ps.swiggyclonenew.ui.reusables.CardItem
import com.ps.swiggyclonenew.ui.reusables.FilterButton
import com.ps.swiggyclonenew.ui.reusables.FoodBrandCard
import com.ps.swiggyclonenew.ui.reusables.FoodCategoryCard
import com.ps.swiggyclonenew.ui.reusables.RestaurantBrandCard
import com.ps.swiggyclonenew.ui.reusables.SearchBar
import com.ps.swiggyclonenew.viewmodels.MainViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.ps.swiggyclonenew.ui.lottieanim.LocationAnim
import com.ps.swiggyclonenew.ui.lottieanim.YummyAnim


@Composable
fun FoodScreen(
    navController: NavController,
    viewModel: MainViewModel = hiltViewModel()
) {
    val mealList by viewModel.mealStateFlow.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Top
    ) {

        // Add a scrollable container
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
//            contentPadding = PaddingValues(top = 8.dp) // Padding for top space
        ) {
            item {
                // Your TopBar
                SwiggyTopBar(navController = navController)
            }
            // Add some space before the searchbar
            item {
                Spacer(modifier = Modifier.height(8.dp)) // Space before cards
            }

            item {
                // Search Bar
                SearchBar(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .fillMaxWidth(),
                    onSearch = { query ->
                        // Handle search action here
                        println("Search query: $query")
                    }
                )
            }
            item {
                Spacer(modifier = Modifier.height(20.dp))
            }

            // Add some space before the cards
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(), // Ensures the Row takes the full width
                ) {
                    Box(
                        modifier = Modifier
                            .height(120.dp)
                            .weight(1f)
                    ) {
                        LocationAnim(modifier = Modifier)
                    }
                    Box(
                        modifier = Modifier
                            .width(140.dp)
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
                ) {
                    Text("PANKAJ, WHAT'S ON YOUR MIND?")
                    LazyRow {
                        item {
                            Column {
                                Row {
                                    mealList.forEach { meal ->
                                        FoodCategoryCard(meal.strCategory, meal.strCategoryThumb) { }
                                    }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
                                }
                                Row {
                                    mealList.forEach { meal ->
                                        FoodCategoryCard(meal.strCategory, meal.strCategoryThumb) { }
                                    }

//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
//                                    FoodCategoryCard("Biryani", R.drawable.chicken) { }
//                                    FoodCategoryCard("Biryani", R.drawable.ic_location) { }
                                }
                            }
                        }
                    }
                }

            }

            item {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp), // Padding for the cards
                ) {
                    Text("POPULAR BRANDS")
                    Spacer(modifier = Modifier.height(8.dp))

                    LazyRow {
                        items(8) { index -> // Use `items` to manage the count of cards
                            FoodBrandCard(
                                title = "RS 100 OFF",
                                subTitle = "ABOVE RS 199",
                                imageResource = R.drawable.burger,
                                onClick = {}
                            )
                            if (index < 7) { // Add padding only if it's not the last item
                                Spacer(modifier = Modifier.width(12.dp)) // Spacer between items
                            }
                        }
                    }
                }
            }

            item {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 16.dp), // Padding for the cards
                ) {
                    LazyRow {
                        item {
                            FilterButton(
                                "Filter", modifier = Modifier
                                    .padding(end = 8.dp)
                            ) {}
                            FilterButton(
                                "Filter1", modifier = Modifier
                                    .padding(end = 8.dp)
                            ) {}
                            FilterButton(
                                "Filter2", modifier = Modifier
                                    .padding(end = 8.dp)
                            ) {}
                            FilterButton(
                                "Filter3", modifier = Modifier
                                    .padding(end = 8.dp)
                            ) {}
                            FilterButton(
                                "Filter4", modifier = Modifier
                                    .padding(end = 8.dp)
                            ) {}
                            FilterButton(
                                "Filter5", modifier = Modifier
                                    .padding(end = 8.dp)
                            ) {}
                            FilterButton(
                                "Filter6", modifier = Modifier
                                    .padding(end = 8.dp)
                            ) {}
                        }
                    }
                }
            }

            item {

                Column(
                ) {
                    Text(
                        "101 restraurants to explore",
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    RestaurantBrandCard(
                        "Hydrabady's",
                        "4",
                        "30-40 min",
                        null,
                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
                        "FREE",
                        R.drawable.burger,
                        modifier = Modifier.padding(16.dp),
                    ) {}
                    RestaurantBrandCard(
                        "Hydrabady's",
                        "4",
                        "30-40 min",
                        null,
                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
                        "FREE",
                        R.drawable.burger,
                        modifier = Modifier.padding(16.dp),
                    ) {}
                    RestaurantBrandCard(
                        "Hydrabady's",
                        "4",
                        "30-40 min",
                        null,
                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
                        "FREE",
                        R.drawable.burger,
                        modifier = Modifier.padding(16.dp),
                    ) {}
                    RestaurantBrandCard(
                        "Hydrabady's",
                        "4",
                        "30-40 min",
                        null,
                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
                        "FREE",
                        R.drawable.burger,
                        modifier = Modifier.padding(16.dp),
                    ) {}
                    RestaurantBrandCard(
                        "Hydrabady's",
                        "4",
                        "30-40 min",
                        null,
                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
                        "FREE",
                        R.drawable.burger,
                        modifier = Modifier.padding(16.dp),
                    ) {}
                    RestaurantBrandCard(
                        "Hydrabady's",
                        "4",
                        "30-40 min",
                        null,
                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
                        "FREE",
                        R.drawable.burger,
                        modifier = Modifier.padding(16.dp),
                    ) {}
                    RestaurantBrandCard(
                        "Hydrabady's",
                        "4",
                        "30-40 min",
                        null,
                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
                        "FREE",
                        R.drawable.burger,
                        modifier = Modifier.padding(16.dp),
                    ) {}

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
fun PreviewFoodScreen() {
    val fakeNavController = rememberNavController() // This will create a fake instance
    FoodScreen(navController = fakeNavController)
}

