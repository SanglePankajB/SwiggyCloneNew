package com.ps.swiggyclonenew.ui.reusables

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.ui.res.painterResource
import com.ps.swiggyclonenew.R


@Composable
fun WelcomeOffersBottomSheet(
    onDismiss: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painter = painterResource(id = R.drawable.img_welcome),
            contentDescription = "Welcome Image",
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterHorizontally)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Welcome to Our App!",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = "Here are some amazing offers for you:",
            fontSize = 16.sp,
            color = Color.Gray,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Offers List
        OfferItem(
            offerTitle = "10% off on your first purchase!",
            offerDescription = "Use code FIRST10 at checkout."
        )
        OfferItem(
            offerTitle = "Free shipping on orders above $50",
            offerDescription = "No code required, valid for a limited time."
        )
        OfferItem(
            offerTitle = "Buy 1 Get 1 Free on selected items",
            offerDescription = "Available in our flash sale section."
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Dismiss Button
        Button(
            onClick = { onDismiss() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Text(text = "Start Shopping")
        }
    }
}


@Composable
fun OfferItem(offerTitle: String, offerDescription: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = offerTitle,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = Color(0xFFFF5722) // Use app theme or accent color
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = offerDescription,
            fontSize = 14.sp,
            color = Color.Gray
        )
    }
}
