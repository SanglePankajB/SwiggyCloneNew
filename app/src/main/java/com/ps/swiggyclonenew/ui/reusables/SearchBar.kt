package com.ps.swiggyclonenew.ui.reusables

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ps.swiggyclonenew.R
import kotlinx.coroutines.delay


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hintText: String = "Search for ",
    onSearch: (String) -> Unit
) {
    var textState by remember { mutableStateOf("") }
    val hints = listOf("'Milk'", "'Biryani'", "'Paneer'", "'Pizza'")  // Your array of texts
    var changingHintText by remember { mutableStateOf(hints[0]) }       // Initial text state

    // LaunchedEffect to run a loop that updates text every 1 second
    LaunchedEffect(Unit) {
        var index = 0
        while (true) {
            changingHintText = hints[index % hints.size]   // Update hintText
            index++                                // Move to the next hint
            delay(2000L)                           // Wait for 1 second
        }
    }

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(15.dp),
        color = Color.White,
        elevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp), // Padding for the row
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Search TextField
            TextField(
                value = textState,
                onValueChange = { newText ->
                    textState = newText
                },
                placeholder = {
                    Row {
                        Text(
                            text = hintText,
                            color = Color.Gray
                        )// Use AnimatedContent to apply the slide animation on text change
                        AnimatedContent(
                            targetState = changingHintText,
                            transitionSpec = {
                                slideInVertically { height -> height } + fadeIn() with
                                        slideOutVertically { height -> -height } + fadeOut()
                            }
                        ) { targetHint ->
                            Text(
                                text = targetHint,
                                color = Color.Gray
                            )
                        }
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    color = Color.Black,
                    fontSize = 14.sp,
                    lineHeight = 20.sp // Adjust line height for centering
                ),
                modifier = Modifier
                    .weight(1f) // TextField takes up available space
                    .padding(end = 8.dp) // Padding to avoid overlap with icons
                    .height(56.dp), // Set a fixed height
                maxLines = 1,
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search // Show search icon on the keyboard
                ),
                keyboardActions = KeyboardActions(
                    onSearch = { onSearch(textState) } // Trigger search when the user presses "Search" on the keyboard
                ),
            )

            // Search Icon
            IconButton(onClick = { onSearch(textState) }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Black
                )
            }
            // Vertical divider
            Spacer(
                modifier = Modifier
                    .width(1.dp) // Set the width of the vertical divider
                    .height(24.dp) // Adjust height to match your layout
                    .background(Color.LightGray) // Set the color of the divider
            )

            // Mic Icon
            IconButton(onClick = { /* Handle mic click */ }) {
                Icon(
                    modifier = Modifier.size(20.dp),
                    painter = painterResource(R.drawable.ic_mic_1),
                    contentDescription = "Mic",
                    tint = Color(0xFFFF5722)
                )
            }
        }
    }
}





@Preview(showBackground = true)
@Composable
fun PreviewSwiggyTopBar() {
    SearchBar(){}
}