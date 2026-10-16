package com.example.miapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.miapp.ui.components.AppDrawer
import com.example.miapp.ui.components.AppTopBar
import com.example.miapp.ui.screens.GalleryScreen
import com.example.miapp.ui.screens.HomeScreen
import com.example.miapp.ui.screens.SlideshowScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {
    var pantallaActual by remember {
        mutableStateOf("Home")
    }
    AppDrawer(
        pantallaActual = pantallaActual,
        onPantallaSeleccionada = {
            pantallaActual = it
        }
    ) { abrirMenu ->
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                AppTopBar(
                    onMenuClick = {
                        abrirMenu()
                    }
                )
            }
        ) { innerPadding ->
            when (pantallaActual) {
                "Home" -> {
                    HomeScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                "Gallery" -> {
                    GalleryScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
                "Slideshow" -> {
                    SlideshowScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
