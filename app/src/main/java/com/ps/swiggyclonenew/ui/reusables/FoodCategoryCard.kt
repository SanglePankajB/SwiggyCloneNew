package com.ps.swiggyclonenew.ui.reusables
import android.widget.ImageView
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

@Composable
fun GlideImageComposable(
    imageUrl: String,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    AndroidView(
        modifier = modifier,
        factory = { context ->
            ImageView(context).apply {
                Glide.with(context)
                    .load(imageUrl)
                    .apply(RequestOptions().fitCenter())
                    .into(this)
            }
        }
    )
}

@Composable
fun FoodCategoryCard(title: String, imageUrl: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .clickable(onClick = onClick),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.Start
        ) {
            GlideImageComposable(
                imageUrl = imageUrl,
                modifier = Modifier
                    .size(56.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(bottom = 4.dp)
            )
            Text(
                text = title,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally),
                maxLines = 1
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun PreviewFoodScreen() {
//    val fakeNavController = rememberNavController() // This will create a fake instance
    FoodCategoryCard("Biryani", "https://www.themealdb.com/images/category/beef.png") {}
}

