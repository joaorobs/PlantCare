package com.example.plantcare.presentation.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.plantcare.data.PlantModel
import com.example.plantcare.navigation.FormScreen
import com.example.plantcare.presentation.PlantViewModel
import com.example.plantcare.presentation.components.HomeScreenTopBox
import com.example.plantcare.presentation.components.PlantComposable
import kotlinx.coroutines.launch

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(navController: NavController, viewModel: PlantViewModel) {

    val plantList by viewModel.plantList.observeAsState()

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(FormScreen)
                }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    ) {
        Column {
            HomeScreenTopBox()

            plantList?.let {
                LazyColumn(
                    content = {
                        itemsIndexed(it) { index, plant ->
                            PlantComposable(plantModel = plant, onDelete = {
                                viewModel.viewModelScope.launch { viewModel.deletePlant(plant.id) }
                            })
                        }

                    }
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
}