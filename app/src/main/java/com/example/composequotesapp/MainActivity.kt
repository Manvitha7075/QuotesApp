package com.example.composequotesapp

import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.composequotesapp.Models.Quote
import com.example.composequotesapp.Screens.QuoteDetails
import com.example.composequotesapp.Screens.QuoteListScreen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.IO).launch {
            // delay(10000)
            DataManager.loadAssestsFromFile(applicationContext)
        }
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    if (DataManager.isDataLoaded.value) {
        if(DataManager.currentPage.value == Pages.LISTING){
            QuoteListScreen(data = DataManager.data) {
                DataManager.switchPages(it)
            }
        }
        else{
            DataManager.currentQuote?.let { QuoteDetails(quote = it) }
        }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f),
        ) {
            Text(
                text = "Loading.....",
                style = MaterialTheme.typography.h6,
            )
        }
    }
}

enum class Pages {
    LISTING,
    DETAIL,
}
