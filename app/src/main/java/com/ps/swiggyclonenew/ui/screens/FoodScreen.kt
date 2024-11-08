package com.ps.swiggyclonenew.ui.screens

import android.widget.Toast
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
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
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
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
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
import com.ps.swiggyclonenew.intent.MyIntent
import com.ps.swiggyclonenew.ui.lottieanim.LocationAnim
import com.ps.swiggyclonenew.ui.lottieanim.YummyAnim
import com.ps.swiggyclonenew.ui.reusables.BrandCard
import com.ps.swiggyclonenew.ui.reusables.FoodBrandCard2
import com.ps.swiggyclonenew.ui.reusables.RestaurantBrandCard2


data class BrandItem (
    val name:String,
    val icon: Int
)


@Composable
fun FoodScreen(
    navController: NavController,
    viewModel: MainViewModel,
    userIntent: (MyIntent) -> Unit,
) {

    val mealList by viewModel.mealStateFlow.collectAsState()
    val restoList by viewModel.restoStateFlow.collectAsState()
    println("Restolist")
    println("Restolist--> $restoList")

    // Use LazyListState to observe scroll position
    val listState = rememberLazyListState()
    val scrollOffset = listState.firstVisibleItemScrollOffset

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Top
    ) {

        // Add a scrollable container
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            state = listState
//            contentPadding = PaddingValues(top = 8.dp) // Padding for top space
        ) {
//            item {
//                // Your TopBar
//                SwiggyTopBar(navController = navController, scrollOffset)
//            }
//            // Add some space before the searchbar
//            item {
//                Spacer(modifier = Modifier.height(8.dp)) // Space before cards
//            }
//
//            item {
//                // Search Bar
//                SearchBar(
//                    modifier = Modifier
//                        .padding(horizontal = 16.dp)
//                        .fillMaxWidth(),
//                    onSearch = { query ->
//                        userIntent.invoke(MyIntent.Search(query))
//                        println("Search query: $query")
//                    }
//                )
//            }
            item {
                LocationAndSearchBar(
                    scrollOffset,
                    navController = navController,
                    userIntent = userIntent
                )
            }

            item {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(
                            RoundedCornerShape(
                                bottomStart = 16.dp,
                                bottomEnd = 16.dp
                            )
                        )
                ) {
                    Column {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF461C2D))
                                .padding(start = 16.dp), // Ensures the Row takes the full width
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(120.dp)
                                    .weight(1f)
                            ) {
                                YummyAnim(modifier = Modifier.align(alignment = Alignment.Center))
                            }
                        }
                        LazyRow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF461C2D))
                                .padding(start = 16.dp, bottom = 24.dp), // Ensures the Row takes the full width
                        ){
                            val iconlist = listOf<BrandItem>(
                                BrandItem("KFC", R.drawable.ic_kfc_new),
                                BrandItem("Dominos", R.drawable.ic_dominospizza),
                                BrandItem("Mac'D", R.drawable.ic_mcdonalds),
                                BrandItem("Starbucks", R.drawable.ic_starbucks),
                                BrandItem("Pizzahut", R.drawable.ic_pizzahut),
                                BrandItem("KFC", R.drawable.ic_kfc_new),
                                BrandItem("KFC", R.drawable.ic_kfc_new),
                                BrandItem("KFC", R.drawable.ic_kfc_new),
                            )
                            item {
                                iconlist.forEach{item->
                                    BrandCard(item.name, item.icon){}
                                }
                            }
                        }
                    }
                }
            }

            item {
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Cards Layout
            item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(), // Padding for the cards
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "PANKAJ, WHAT'S ON YOUR MIND?",
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        maxLines = 1,
                        letterSpacing = .12.em,
                        fontWeight = FontWeight.Medium,
                    )
                    LazyRow {
                        item {
                            Column {
                                Row {
                                    mealList.forEach { meal ->
                                        FoodCategoryCard(
                                            meal.strCategory,
                                            meal.strCategoryThumb
                                        ) { }
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
                                        FoodCategoryCard(
                                            meal.strCategory,
                                            meal.strCategoryThumb
                                        ) { }
                                    }
                                }
                            }
                        }
                    }
                }

            }

            item {
                Column(
                    modifier = Modifier
                        .padding(vertical = 16.dp), // Padding for the cards
                ) {
                    Text(
                        "POPULAR BRANDS",
                        color = Color.Black,
                        fontFamily = FontFamily.SansSerif,
                        fontSize = 12.sp,
                        maxLines = 1,
                        letterSpacing = .12.em,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    LazyRow {
                        item {
                            restoList.take(8).forEach { resto ->
                                RestaurantBrandCard2(
                                    resto.restName,
                                    resto.restRating,
                                    resto.restServeTime,
                                    resto.restSubTitle,
                                    resto.restLocation,
                                    resto.restDeleveryType,
                                    resto.restThubnail,
                                    modifier = Modifier.padding(0.dp)
                                ) { }
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
                                "Filter",
                                modifier = Modifier
                                    .padding(end = 8.dp),
                                true
                            ) {}
                            FilterButton(
                                "Sort by", modifier = Modifier
                                    .padding(end = 8.dp),
                                true
                            ) {}
                            FilterButton(
                                "Fast Delivery", modifier = Modifier
                                    .padding(end = 8.dp),
                                false
                            ) {}
                            FilterButton(
                                "Pure veg", modifier = Modifier
                                    .padding(end = 8.dp),
                                false
                            ) {}
                            FilterButton(
                                "Offers", modifier = Modifier
                                    .padding(end = 8.dp),
                                false
                            ) {}
                            FilterButton(
                                "Less than 299", modifier = Modifier
                                    .padding(end = 8.dp),
                                false
                            ) {}
                            FilterButton(
                                "Rating 4+", modifier = Modifier
                                    .padding(end = 8.dp),
                                false
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

                    restoList.forEach { resto ->
                        RestaurantBrandCard(
                            resto.restName,
                            resto.restRating,
                            resto.restServeTime,
                            resto.restSubTitle,
                            resto.restLocation,
                            resto.restDeleveryType,
                            resto.restThubnail,
                            modifier = Modifier.padding(16.dp)
                        ) { }
                    }

//                    RestaurantBrandCard(
//                        "Hydrabady's",
//                        "4",
//                        "30-40 min",
//                        null,
//                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
//                        "FREE",
//                        R.drawable.burger,
//                        modifier = Modifier.padding(16.dp),
//                    ) {}
//                    RestaurantBrandCard(
//                        "Hydrabady's",
//                        "4",
//                        "30-40 min",
//                        null,
//                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
//                        "FREE",
//                        R.drawable.burger,
//                        modifier = Modifier.padding(16.dp),
//                    ) {}
//                    RestaurantBrandCard(
//                        "Hydrabady's",
//                        "4",
//                        "30-40 min",
//                        null,
//                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
//                        "FREE",
//                        R.drawable.burger,
//                        modifier = Modifier.padding(16.dp),
//                    ) {}
//                    RestaurantBrandCard(
//                        "Hydrabady's",
//                        "4",
//                        "30-40 min",
//                        null,
//                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
//                        "FREE",
//                        R.drawable.burger,
//                        modifier = Modifier.padding(16.dp),
//                    ) {}
//                    RestaurantBrandCard(
//                        "Hydrabady's",
//                        "4",
//                        "30-40 min",
//                        null,
//                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
//                        "FREE",
//                        R.drawable.burger,
//                        modifier = Modifier.padding(16.dp),
//                    ) {}
//                    RestaurantBrandCard(
//                        "Hydrabady's",
//                        "4",
//                        "30-40 min",
//                        null,
//                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
//                        "FREE",
//                        R.drawable.burger,
//                        modifier = Modifier.padding(16.dp),
//                    ) {}
//                    RestaurantBrandCard(
//                        "Hydrabady's",
//                        "4",
//                        "30-40 min",
//                        null,
//                        "Streetfood, Chaat, Sweets, Wakad. 3.5km",
//                        "FREE",
//                        R.drawable.burger,
//                        modifier = Modifier.padding(16.dp),
//                    ) {}

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

@Composable
fun LocationAndSearchBar(
    scrollOffset: Int,
    navController: NavController,
    userIntent: (MyIntent) -> Unit
) {

    //
    // Define the start and end colors for background, content, and address text
    val startBackgroundColor = Color(0xFF461C2D)
    val endBackgroundColor = Color(0xFFF5F5F5)

    // Calculate progress as a fraction between 0 and 1 based on scrollOffset
    val progress = (scrollOffset / 100f).coerceIn(0f, 1f)

    // Use lerp to interpolate colors based on progress
    val backgroundColor = lerp(startBackgroundColor, endBackgroundColor, progress)

    //


    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = backgroundColor
            )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            SwiggyTopBar(navController = navController, scrollOffset)
            Spacer(modifier = Modifier.height(16.dp))
            SearchBar(
                modifier = Modifier
                    .fillMaxWidth(),
                onSearch = { query ->
                    userIntent.invoke(
                        MyIntent.Search(query)
                    )
                    navController.navigate("filterscreen")
                }
            )
        }
    }
}

@Composable
fun FoodBrandCardWithDesciption(){
//    FoodBrandCard2("RS 100 OFF", "ABOVE RS 199", img) {}
}