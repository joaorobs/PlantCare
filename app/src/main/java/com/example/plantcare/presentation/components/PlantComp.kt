package com.example.plantcare.presentation.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewModelScope
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.plantcare.R
import com.example.plantcare.data.PlantModel
import com.example.plantcare.presentation.PlantViewModel
import kotlinx.coroutines.launch

@Composable
fun PlantComposable(plantModel : PlantModel, onDelete : () -> Unit) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .border(width = 0.001.dp, color = Color.Black)
    ) {

        AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .align(Alignment.CenterVertically)
                .padding(start = 16.dp),
            model = plantModel.image,
            contentDescription = null,
            contentScale = ContentScale.Fit,
        )
        Column {
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, top = 40.dp),
                text = plantModel.name,
                fontWeight = FontWeight(700),
            )
            Text(
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp, end = 10.dp),
                text = "Essa planta necessita de água ${plantModel.waterFrequency} vezes por semana.",
                maxLines = 2,
                softWrap = true,
                fontWeight = FontWeight(400),
            )
            IconButton(modifier = Modifier
                .align(Alignment.End),
                onClick = onDelete
                ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
private fun PlantComposablePreview() {
}
