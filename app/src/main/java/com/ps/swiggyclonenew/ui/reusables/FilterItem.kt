package com.ps.swiggyclonenew.ui.reusables

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.ps.swiggyclonenew.ui.screens.FoodScreen
@Composable
fun FilterButton(
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {
    val borderColor = Color.Gray
    val backgroundColor = Color.White

    Button(
        onClick = onClick,
        modifier = modifier
            .border(
                width = 1.dp,
                color = borderColor,
                shape = RoundedCornerShape(16.dp)
            )
            .height(35.dp)
            .width(80.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = backgroundColor
        ),
        elevation = ButtonDefaults.buttonElevation(0.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxSize(), // Fill the button size
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                modifier = Modifier.padding(start = 8.dp),
                text = text,
                color = Color.Black, // Text color
                style = MaterialTheme.typography.bodySmall // Use smaller typography style
            )
            Icon(
                modifier = Modifier.padding(end = 8.dp)
                    .size(16.dp) ,
                imageVector = Icons.Default.ArrowDropDown, // Dropdown icon
                contentDescription = "Dropdown",
                tint = Color.Black, // Icon color
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Screen() {
//    val fakeNavController = rememberNavController() // This will create a fake instance
    FilterButton("Filters", modifier = Modifier
        .height(20.dp) // Button height
        .width(90.dp)  // Button width
        .padding(end = 8.dp)

        )  {}
}


