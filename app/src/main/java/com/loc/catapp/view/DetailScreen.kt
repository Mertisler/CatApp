package com.loc.catapp.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.loc.catapp.viewmodel.CatViewModel

@Composable
fun CatDetailScreen(catId: String, viewModel: CatViewModel = hiltViewModel()) {
    val cats by viewModel.cats.observeAsState()
    val cat = cats?.find { it.id == catId }

    if (cat == null) {
        Text(text = "Cat not found",
            modifier = Modifier.fillMaxSize(), style = MaterialTheme.typography.bodyLarge)
        return
    }

    val imageUrl = cat.url?: ""

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = cat.name, style = MaterialTheme.typography.displayMedium)
        Spacer(modifier = Modifier.height(16.dp))
        if (imageUrl.isNotEmpty()) {
            Image(
                painter = rememberAsyncImagePainter(imageUrl),
                contentDescription = "Cat Image",
                modifier = Modifier.size(200.dp)
            )
        } else {
            Text(text = "Image not available", style = MaterialTheme.typography.bodyMedium)
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = cat.description, style = MaterialTheme.typography.labelLarge)
    }
}
