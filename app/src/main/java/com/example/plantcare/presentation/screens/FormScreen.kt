package com.example.plantcare.presentation.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.plantcare.COLOR
import com.example.plantcare.R
import com.example.plantcare.data.PlantModel
import com.example.plantcare.presentation.PlantViewModel
import kotlinx.coroutines.launch

@Composable
fun FormScreen(navController: NavController) {

    var name by remember { mutableStateOf("") }
    var waterFrequency by remember { mutableStateOf("0") }
    val plantViewModel = PlantViewModel()
    var selectedImageUri by remember {
        mutableStateOf<Uri?>(null)
    }
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia(),
        onResult = { uri -> selectedImageUri = uri }
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
    ) {

        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(COLOR)
        ) {
            Text(
                text = "Adicione sua planta",
                fontWeight = FontWeight(700),
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))


        Text(text = "Nome")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = name, onValueChange = { newName ->
            name = newName
        })

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Intervalo de tempo para regar")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = waterFrequency, onValueChange = { newWaterFrequency ->
            waterFrequency = newWaterFrequency
        })

        Spacer(modifier = Modifier.height(30.dp))

        Column (horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(1.dp, COLOR)
                .size(240.dp)){

            AsyncImage(
                modifier = Modifier.size(180.dp),
                model = selectedImageUri,
                contentDescription = null,
            )
            TextButton(modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
                    photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                }) {
                Text(
                    "Adicione Imagem"
                )
            }
        }


        Button(onClick = {
            if (name != "" || waterFrequency != "0") {
                val newPlant = PlantModel(
                    name = name,
                    waterFrequency = waterFrequency,
                    image = selectedImageUri
                )
                plantViewModel.viewModelScope.launch { plantViewModel.addPlant(newPlant) }
                navController.popBackStack()
            }
        }, modifier = Modifier.padding(top = 40.dp)) {
            Text(text = "Salvar")
        }
    }

}


@Preview(showSystemUi = true)
@Composable
private fun FormScreenPreview() {
    var name by remember { mutableStateOf("") }
    var waterFrequency by remember { mutableStateOf("0") }
//    val plantViewModel = PlantViewModel()
//    var selectedImageUri by remember {
//        mutableStateOf<Uri?>(null)
//    }
//    val photoPickerLauncher = rememberLauncherForActivityResult(
//        contract = ActivityResultContracts.PickVisualMedia(),
//        onResult = { uri -> selectedImageUri = uri }
//    )


    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxWidth()
    ) {

        Box(
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
                .background(COLOR)
        ) {
            Text(
                text = "Adicione sua planta",
                fontWeight = FontWeight(700),
                fontSize = 30.sp,
                fontFamily = FontFamily.Serif,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Spacer(modifier = Modifier.height(20.dp))


        Text(text = "Nome")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = name, onValueChange = { newName ->
            name = newName
        })

        Spacer(modifier = Modifier.height(30.dp))

        Text(text = "Intervalo de tempo para regar")
        Spacer(modifier = Modifier.height(10.dp))
        OutlinedTextField(value = waterFrequency, onValueChange = { newWaterFrequency ->
            waterFrequency = newWaterFrequency
        })

        Spacer(modifier = Modifier.height(30.dp))

        Column (horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .border(1.dp, COLOR)
                .size(240.dp)){

            Image(modifier = Modifier
                .size(180.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background), contentDescription = null)
            TextButton(modifier = Modifier.align(Alignment.CenterHorizontally),
                onClick = {
//                    photoPickerLauncher.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
                }) {
                Text(
                    "Adicione Imagem"
                )
            }
        }

//        Button(
//            onClick = {
//                if (name != "" || waterFrequency != "0") {
//                    val newPlant = PlantModel(
//                        name = name,
//                        waterFrequency = waterFrequency,
//                        imag
//                    )
////                plantViewModel.viewModelScope.launch { plantViewModel.addPlant(newPlant) }
////                navController.popBackStack()
//                }
//            },
//            modifier = Modifier.padding(top = 40.dp)
//        ) {
//            Text(text = "Salvar")
//        }
    }

}


