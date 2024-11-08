package com.ps.swiggyclonenew.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.IconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.navigation.NavController
import com.ps.swiggyclonenew.R

@Composable
fun SwiggyTopBar(
    navController: NavController,
    scrollOffset: Int,
    padding: Dp? = 0.dp
    ) {

    // Define the start and end colors for background, content, and address text
    val startBackgroundColor = Color(0xFF461C2D)
    val endBackgroundColor = Color(0xFFF5F5F5)

    val startContentColor = Color.White
    val endContentColor = Color.Black

    val startAddressColor = Color.LightGray
    val endAddressColor = Color.Gray

    val iconStartColor =  Color.White
    val iconEndColor =  Color(0xFFFF5722)

    // Calculate progress as a fraction between 0 and 1 based on scrollOffset
    val progress = (scrollOffset / 100f).coerceIn(0f, 1f)

    // Use lerp to interpolate colors based on progress
    val backgroundColor = lerp(startBackgroundColor, endBackgroundColor, progress)
    val contentColor = lerp(startContentColor, endContentColor, progress)
    val addressColor = lerp(startAddressColor, endAddressColor, progress)
    val iconColor = lerp(iconStartColor, iconEndColor, progress)

    Column {
            TopAppBar(
                backgroundColor = backgroundColor,
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = padding!!), // Top bar padding
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
                            .clickable {
                                navController.navigate("setlocation")
                            }
                    ) {
                        // First row with icon and label
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.ic_navigation),
                                contentDescription = "Location Icon",
                                tint = iconColor,
                                modifier = Modifier.size(20.dp)
                                    .padding(bottom = 4.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = "Hinjawadi Village", // Your location label
                                color = contentColor,
                                fontSize = 16.sp,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                fontWeight = FontWeight.ExtraBold,
                            )
                            Icon(
                                imageVector = Icons.Default.KeyboardArrowDown,
                                contentDescription = "Dropdown",
                                tint = Color.Gray,
                                modifier = Modifier.size(24.dp) // Set the size as per your design needs
                            )
                        }

                        Spacer(modifier = Modifier.height(4.dp))

                        // Second row with address
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "1234, Swiggy Street, Food City", // Your address
                                color = addressColor,
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


@Composable
fun SwiggyTopBar2(
    navController: NavController,
    padding: Dp? = 0.dp
) {

    Column {
        TopAppBar(
            backgroundColor = Color(0xFFF5F5F5),
            contentPadding = PaddingValues(vertical = 8.dp, horizontal = padding!!), // Top bar padding
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
                        .clickable {
                            navController.navigate("setlocation")
                        }
                ) {
                    // First row with icon and label
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.ic_navigation),
                            contentDescription = "Location Icon",
                            tint = Color(0xFFFF5722),
                            modifier = Modifier.size(20.dp)
                                .padding(bottom = 4.dp)
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = "Hinjawadi Village",
                            color = Color.Black,
                            fontFamily = FontFamily.SansSerif,
                            fontSize = 16.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.ExtraBold,
                        )

                        Icon(
                            imageVector = Icons.Default.KeyboardArrowDown,
                            contentDescription = "Dropdown",
                            tint = Color.Gray,
                            modifier = Modifier.size(24.dp) // Set the size as per your design needs
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


//@Preview(showBackground = true)
//@Composable
//fun PreviewSwiggyTopBar() {
//    val fakeNavController = rememberNavController()
////    SwiggyTopBar(fakeNavController)
//}
