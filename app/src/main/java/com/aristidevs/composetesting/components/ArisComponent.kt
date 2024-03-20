package com.aristidevs.composetesting.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview

/****
 * Project: ComposeTesting
 * From: com.aristidevs.composetesting.components
 * Created by Arthur Dioses Reto on 19/03/24 at 9:43 AM
 * All rights reserved 2024.
 ****/

@Preview
@Composable
fun ArisComponent() {
    var name by rememberSaveable {
        mutableStateOf("Arthur")
    }

    Column(Modifier.fillMaxSize()) {
        TextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier.testTag("textFieldName")
        )
        Text(text = "Te llamas $name", modifier = Modifier.testTag("textGreeting"))
    }
}