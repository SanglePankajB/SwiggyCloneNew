package com.ps.swiggyclonenew.ui.reusables

import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.compose.rememberNavController
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.ps.swiggyclonenew.R
import com.ps.swiggyclonenew.ui.screens.FoodScreen

import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import coil.size.Size

@Composable
fun FoodBrandCard(title: String, subTitle: String, imageResource: Int, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp)) // Rounded corners
            .clickable(onClick = onClick)
            .width(130.dp)
            .height(150.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent) // Make background transparent
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            // Background Image
            Image(
                painter = painterResource(id = imageResource),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
                    .width(200.dp),
                contentScale = ContentScale.Crop // Adjust as necessary
            )

            // Clickable Heart Icon
            Icon(
                painter = painterResource(id = R.drawable.ic_heart), // Replace with your heart icon resource
                contentDescription = "Favorite",
                modifier = Modifier
                    .size(24.dp)
                    .align(Alignment.TopEnd)
                    .clickable { /* Handle click */ }
                    .padding(16.dp), // Padding around the icon
                tint = Color.Red // Set the tint color for the heart icon
            )

            // Text at the bottom left corner
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(start = 4.dp, bottom = 4.dp),
                verticalArrangement = Arrangement.spacedBy(0.dp) // Space between title and subtitle
            ) {
                Text(
                    text = title,
                    color = Color.White,
                    style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp), // Adjust text style as needed
                    modifier = Modifier.padding(0.dp) // No additional padding
                )
                Text(
                    text = subTitle,
                    color = Color.White.copy(alpha = 0.7f), // Slightly less opacity for subtext
                    style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp) // Adjust text style as needed
                )
            }
        }
    }
}



@Composable
fun FoodBrandCard2(title: String, subTitle: String, img: String, onClick: () -> Unit) {

        Box(modifier = Modifier.height(150.dp).width(130.dp))
        {
            val model = ImageRequest
                .Builder(LocalContext.current)
                .data(img)
                .size(Size.ORIGINAL)
                .build()

            val imageState = rememberAsyncImagePainter(model = model).state

            if(imageState is AsyncImagePainter.State.Success){
                Image(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .fillMaxSize(),
                    painter = imageState.painter,
                    contentDescription = null,
                    contentScale =  ContentScale.Crop
                )
                Icon(
                    imageVector = Icons.Rounded.Favorite, // Replace with your heart icon resource
                    contentDescription = "Favorite",
                    modifier = Modifier
                        .size(24.dp)
                        .align(Alignment.TopEnd)
                        .clickable { /* Handle click */ }
                        .padding(16.dp), // Padding around the icon
                    tint = Color.Red // Set the tint color for the heart icon
                )

                Column(
                    modifier = Modifier
                        .align(Alignment.BottomStart)
                        .padding(start = 4.dp, bottom = 4.dp),
                    verticalArrangement = Arrangement.spacedBy(0.dp) // Space between title and subtitle
                ) {
                    Text(
                        text = title,
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall.copy(fontSize = 14.sp), // Adjust text style as needed
                        modifier = Modifier.padding(0.dp) // No additional padding
                    )
                    Text(
                        text = subTitle,
                        color = Color.White.copy(alpha = 0.7f), // Slightly less opacity for subtext
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 12.sp) // Adjust text style as needed
                    )
                }

            }
            if(imageState is AsyncImagePainter.State.Loading){
                CircularProgressIndicator(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    color = Color.DarkGray
                )
            }
            if(imageState is AsyncImagePainter.State.Error){

                Icon(
                    modifier = Modifier
                        .size(50.dp)
                        .align(Alignment.Center),
                    imageVector = Icons.Rounded.Info,
                    contentDescription = null
                )
            }
        }
    }






@Preview(showBackground = true)
@Composable
fun PreviewFoodBrandCardScreen() {
//    val fakeNavController = rememberNavController() // This will create a fake instance
    FoodBrandCard2("RS 100 OFF", "ABOVE RS 199" ,"https://plus.unsplash.com/premium_photo-1698507574126-7135d2684aa2?w=800&auto=format&fit=crop&q=60&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxmZWF0dXJlZC1waG90b3MtZmVlZHw2fHx8ZW58MHx8fHx8") {}
}
