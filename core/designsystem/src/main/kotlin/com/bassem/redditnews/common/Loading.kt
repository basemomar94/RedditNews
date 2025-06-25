package com.bassem.redditnews.common

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Loading(modifier: Modifier = Modifier) {
    CircularProgressIndicator(modifier = modifier)

}

@Preview(showBackground = true)
@Composable
private fun LoadingPerview() {
    MaterialTheme {
        LoadingPerview()
    }
}