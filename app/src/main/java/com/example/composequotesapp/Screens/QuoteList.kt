package com.example.composequotesapp.Screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.example.composequotesapp.Models.Quote

@Composable
fun QuoteList(data: Array<Quote>, onClick: (quote: Quote) -> Unit) {
    Column {
        QuoteListItem(quote = Quote("Prepared", "By Manvitha"), onClick)
    }
    LazyColumn(content = {
        items(data) {
            QuoteListItem(quote = it, onClick)
        }
    })
}
