package com.ps.swiggyclonenew.ui.reusables

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import androidx.compose.ui.unit.sp
import com.ps.swiggyclonenew.R


@Composable
fun BrandCard(title: String, img: Int, onClick: () -> Unit) {

    var isPressed by remember { mutableStateOf(false) }
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(70.dp)
            .height(100.dp)
            .padding(8.dp)
            .background(if (isPressed) Color.LightGray else Color.Transparent)
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth() // Adjust the size to fit your needs
                .clip(CircleShape) // Clip the icon to a circular shape
        ) {
            Icon(
                painter = painterResource(img),
                contentDescription = "Brand Icon",
                tint = Color.Unspecified
            )
        }
        Text(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            text = title,
            style = MaterialTheme.typography.bodyMedium.copy(color = Color.White),
            fontWeight = FontWeight.SemiBold,
            fontSize = 12.sp,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}


@Preview(showBackground = true)
@Composable
fun BrandCardPre() {
//    val fakeNavController = rememberNavController() // This will create a fake instance
    BrandCard("Biryani", R.drawable.ic_mcdonalds){}
}

@Composable
fun IconWithLabel(title: String, iconResId: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = title,
            modifier = Modifier
                .size(48.dp) // Adjust the size to fit your needs
                .padding(4.dp),
            tint = Color.Unspecified // Ensures the icon keeps its original colors
        )
        Text(
            text = title,
            style = MaterialTheme.typography.bodyMedium,
            color = Color.Black
        )
    }
}
