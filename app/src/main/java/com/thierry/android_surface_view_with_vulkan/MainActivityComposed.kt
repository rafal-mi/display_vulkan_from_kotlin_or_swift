package com.thierry.android_surface_view_with_vulkan

import android.os.Bundle
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.thierry.android_surface_view_with_vulkan.ui.theme.ComposeVulkanTheme

class MainActivityComposed : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeVulkanTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainContent(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }

}

@Composable
fun MainContent(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.DarkGray)
                .weight(1f)
                .padding(8.dp),
            contentAlignment = Alignment.TopCenter
        ) {
            Column() {
                Text(text = "Compose Vulkan", fontSize = 32.sp)
            }
        }
        AndroidView(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
            factory = {
                VulkanSurfaceView(it)
            },
            update = { view ->
                // Update view properties when Compose state changes
            }
        )
    }

}