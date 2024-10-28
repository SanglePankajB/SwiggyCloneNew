package com.ps.swiggyclonenew.ui.reusables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    hintText: String = "Search...",
    onSearch: (String) -> Unit
) {
    var textState by remember { mutableStateOf("") }

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
                    onSearch(newText) // Trigger search action on text change
                },
                placeholder = {
                    Text(
                        text = hintText,
                        color = Color.Gray
                    )
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
            )

            // Search Icon
            IconButton(onClick = { onSearch(textState) }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search",
                    tint = Color.Black
                )
            }

            // Mic Icon
            IconButton(onClick = { /* Handle mic click */ }) {
                Icon(
                    imageVector = Icons.Default.Call,
                    contentDescription = "Voice Search",
                    tint = Color.Black
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