package com.example.composequotesapp.Screens

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.* // ktlint-disable no-wildcard-imports
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.composequotesapp.DataManager
import com.example.composequotesapp.Models.Quote

@Composable
fun QuoteDetails(quote: Quote) {
    BackHandler() {
        DataManager.switchPages(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxSize(1f)
            .background(
                Brush.sweepGradient(
                    colors = listOf(
                        Color(0xFFffffff),
                        Color(0xFFE3E3E3),
                    ),
                ),
            ),
    ) {
        Card(
            elevation = 4.dp,
            modifier = Modifier.padding(32.dp),
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .align(Alignment.Center)
                    .padding(16.dp, 24.dp),
            ) {
                Image(
                    imageVector = Icons.Filled.FormatQuote,
                    contentDescription = "Quote",
                    modifier = Modifier
                        .size(80.dp)
                        .rotate(180F),
                )
                Text(
                    text = quote.text ?: "No quote available",
                    style = MaterialTheme.typography.subtitle1,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                )
                Spacer(Modifier.height(4.dp))
                Text(
                    text = quote.author ?: "No author available",
                    style = MaterialTheme.typography.subtitle1,
                )
            }
        }
    }
}
