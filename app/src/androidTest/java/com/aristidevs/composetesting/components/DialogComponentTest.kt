package com.aristidevs.composetesting.components

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import org.junit.Rule
import org.junit.Test


/****
 * Project: ComposeTesting
 * From: com.aristidevs.composetesting.components
 * Created by Arthur Dioses Reto on 19/03/24 at 2:38 PM
 * All rights reserved 2024.
 */
class DialogComponentTest {
    @get: Rule
    val composeTestRule = createComposeRule()

    @Test
    fun whenDialogGetATrue_thenShowDialog() {
        composeTestRule.setContent {
            AddTaskDialog(show = true, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("dialog").assertIsDisplayed()
    }

    @Test
    fun whenDialogGetAFalse_thenDoNotShowDialog() {
        composeTestRule.setContent {
            AddTaskDialog(show = false, onDismiss = {}, onTaskAdded = {})
        }

        composeTestRule.onNodeWithTag("dialog").assertDoesNotExist()
    }

}