package com.example.composequotesapp.Screens // ktlint-disable package-name

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.composequotesapp.Models.Quote

@Composable
fun QuoteListItem(quote: Quote, onClick: (quote: Quote) -> Unit) {
    Card(
        elevation = 4.dp,
        modifier = Modifier
            .padding(8.dp)
            .clickable { onClick(quote) },
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp),
        ) {
            Image(
                imageVector = Icons.Filled.FormatQuote,
                colorFilter = ColorFilter.tint(Color.White),
                contentDescription = "quotes",
                alignment = Alignment.TopStart,
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.Black)
                    .rotate(180F),
            )
            Spacer(modifier = Modifier.padding(4.dp))

            Column(
                modifier = Modifier
                    .weight(1f),
            ) {
                Text(
                    text = quote.text ?: "No quote available",
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 8.dp),
                )
                Box(
                    modifier = Modifier
                        .background(Color.LightGray)
                        //  .background(Color(0xFFEEEEEE))
                        .fillMaxWidth(.4f)
                        .height(1.dp),
                )

                Text(
                    text = quote.author ?: "No author available",
                    style = MaterialTheme.typography.body2,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(top = 4.dp),
                )
            }
        }
    }
}
