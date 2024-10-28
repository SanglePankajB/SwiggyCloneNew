package com.ps.swiggyclonenew.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.Surface
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.ps.swiggyclonenew.ui.screens.LoginScreen
import com.ps.swiggyclonenew.ui.screens.SwiggyMainScreen


@Composable
fun SwiggyTopBar(navController: NavController) {
    Column {
        TopAppBar(
            backgroundColor = MaterialTheme.colorScheme.background,
            contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp), // Top bar padding
            elevation = 0.dp,
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween // Profile icon to the right
            ) {
                // Left part with location and address
                Column(
                    modifier = Modifier.weight(1f) // Column takes up the space of Row except Profile
                ) {
                    // First row with icon and label
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = "Location Icon",
                            tint = Color.Black,
                            modifier = Modifier.size(20.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Home", // Your location label
                            color = Color.Black,
                            fontSize = 14.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.height(4.dp))

                    // Second row with address
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "1234, Swiggy Street, Food City", // Your address
                            color = Color.Gray,
                            fontSize = 12.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                // Profile icon on the right
                IconButton(onClick = {
                    // Use navController to navigate to the LoginScreen
                    navController.navigate("profile")
                }) {
                    Icon(
                        imageVector = Icons.Default.Person,
                        contentDescription = "Profile Icon",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(32.dp)
                            .clip(CircleShape)
                            .background(Color.LightGray) // You can change this to an image if needed
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSwiggyTopBar() {
    val fakeNavController = rememberNavController()
    SwiggyTopBar(fakeNavController)
}
