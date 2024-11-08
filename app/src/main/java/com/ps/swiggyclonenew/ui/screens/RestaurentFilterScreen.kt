package com.ps.swiggyclonenew.ui.screens


import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
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


@Composable
fun RestaurentFilterScreen(
    navController: NavController,
    viewModel: MainViewModel,
    userIntent: (MyIntent) -> Unit,
) {

    val filteredRestaurents by viewModel.filteredRestaurents.collectAsState()


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
                SearchHeader(onBackClick = {navController.popBackStack()}, userIntent = userIntent, onDropdownClick = {})
            }
            item {

                Column(
                ) {
                    Spacer(modifier = Modifier.height(8.dp))

                    filteredRestaurents.forEach { resto ->
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

                }

            }

        }
    }
}


@Composable
fun SearchHeader(
    onBackClick: () -> Unit,
    onDropdownClick: () -> Unit,
    userIntent: (MyIntent) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Box(
            Modifier.fillMaxWidth()
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier.padding(0.dp)
            ) {
                Icon(
                    modifier = Modifier.padding(0.dp),
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Back",
                    tint = Color.Black
                )
            }

//            Spacer(modifier = Modifier.width(40.dp))
            Row (
                modifier = Modifier.align(Alignment.Center)
            ){
                Text(
                    text = "Showing results in ",
                    style = MaterialTheme.typography.bodyMedium.copy(color = Color.Gray)
                )

                Text(
                    text = "Food",
                    style = MaterialTheme.typography.bodyMedium.copy(
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.clickable(onClick = onDropdownClick)
                )

                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown",
                    tint = Color.Black,
                    modifier = Modifier.size(16.dp)
                )
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        SearchBar2(
            onSearch = { query ->
                userIntent.invoke(
                    MyIntent.Search(query)
                )
                println("Searching for: $query")
            },
            onMicClick = {
                println("Mic icon clicked")
            }
        )

    }
}

@Composable
fun SearchBar2(
    onSearch: (String) -> Unit,
    onMicClick: () -> Unit
) {
    // MutableState to hold the search text
    var searchText by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .background(Color.White)
            .border(1.dp, color = Color.LightGray, shape = RoundedCornerShape(14.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxSize()
        ) {
            // Text input field with a placeholder
            BasicTextField(
                value = searchText,
                onValueChange = { searchText = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(horizontal = 14.dp),
                singleLine = true,
                decorationBox = { innerTextField ->
                    if (searchText.isEmpty()) {
                        Text("Search, Order, Enjoy, Repeat!", color = Color.LightGray, fontSize = 16.sp)
                    }
                    innerTextField()
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search // Show search icon on the keyboard
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { onSearch(searchText) } // Trigger search when the user presses "Search" on the keyboard
                ),

            )

            // Clear button to reset the search text
            if (searchText.isNotEmpty()) {
                IconButton(onClick = { searchText = "" }) {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        imageVector = Icons.Default.Clear,
                        contentDescription = "Clear",
                        tint = Color.Gray
                    )
                }
            }

            // Vertical divider between clear and mic/search button
            Spacer(
                modifier = Modifier
                    .width(1.dp)
                    .height(24.dp)
                    .background(Color.LightGray)
            )

            // Mic/search button to perform the search action
            IconButton(onClick = { onSearch(searchText) }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.ic_mic_1),
                    contentDescription = "Mic",
                    tint = Color(0xFFFF5722) // Using a color similar to orange
                )
            }
        }
    }
}







@Preview(showBackground = true)
@Composable
fun PreviewResultScreen() {
    val fakeNavController = rememberNavController() // This will create a fake instance
//    RestaurentFilterScreen(
//        navController = fakeNavController,
//    )
//    SearchHeader("pankaj",{},{}, {},{},{})
    SearchBar2(
        onSearch = { query ->
            // Perform search with the query
            println("Searching for: $query")
        },
        onMicClick = {
            // Perform action when mic icon is clicked
            println("Mic icon clicked")
        }
    )
}

