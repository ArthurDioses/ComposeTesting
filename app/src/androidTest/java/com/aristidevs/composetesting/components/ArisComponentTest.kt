package com.aristidevs.composetesting.components

import androidx.compose.ui.test.assertContentDescriptionContains
import androidx.compose.ui.test.assertContentDescriptionEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertIsNotFocused
import androidx.compose.ui.test.assertIsNotSelected
import androidx.compose.ui.test.assertIsOff
import androidx.compose.ui.test.assertIsOn
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.doubleClick
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.longClick
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onFirst
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performImeAction
import androidx.compose.ui.test.performScrollTo
import androidx.compose.ui.test.performTextClearance
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTextReplacement
import androidx.compose.ui.test.performTouchInput
import androidx.compose.ui.test.swipe
import androidx.compose.ui.test.swipeDown
import androidx.compose.ui.test.swipeLeft
import androidx.compose.ui.test.swipeRight
import androidx.compose.ui.test.swipeUp
import org.junit.Rule
import org.junit.Test

/****
 * Project: ComposeTesting
 * From: com.aristidevs.composetesting.components
 * Created by Arthur Dioses Reto on 19/03/24 at 10:03 AM
 * All rights reserved 2024.
 */
class ArisComponentTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun myFirstTest() {
        composeTestRule.setContent {
            ArisComponent()
        }
        //FINDER
        composeTestRule.onNodeWithText("Arthur", ignoreCase = true)
        composeTestRule.onNodeWithTag("component1")
        composeTestRule.onNodeWithContentDescription("superImage")

        composeTestRule.onAllNodesWithText("a")//hace match con una sola letra que contenga el compose
        composeTestRule.onAllNodesWithTag("component1")
        composeTestRule.onAllNodesWithContentDescription("visualIcon")

        //ACTIONS
        composeTestRule.onNodeWithText("Arthur", ignoreCase = true).performClick()
        composeTestRule.onAllNodesWithText("a").onFirst().performClick()
        composeTestRule.onNodeWithText("Arthur").performTouchInput {
            longClick()
            doubleClick()
            swipeDown()
            swipeUp()
            swipeLeft()
            swipeRight()
        }
        composeTestRule.onNodeWithText("Arthur").performScrollTo().performClick()
            .performTextInput("")
        composeTestRule.onNodeWithText("Arthur").performImeAction()
        composeTestRule.onNodeWithText("Arthur").performTextClearance()
        composeTestRule.onNodeWithText("Arthur").performTextInput("Test")
        composeTestRule.onNodeWithText("Arthur").performTextReplacement("Reemplazar")

        //ASSERTIONS
        composeTestRule.onNodeWithText("Arthur").assertExists()
        composeTestRule.onNodeWithText("Arthur").assertDoesNotExist()
        composeTestRule.onNodeWithText("Arthur").assertContentDescriptionEquals("aeafsa")
        composeTestRule.onNodeWithText("Arthur").assertContentDescriptionContains("dsdfsdf")
        composeTestRule.onNodeWithText("Arthur").assertIsDisplayed()
        composeTestRule.onNodeWithText("Arthur").assertIsNotDisplayed()
        composeTestRule.onNodeWithText("Arthur").assertIsEnabled()
        composeTestRule.onNodeWithText("Arthur").assertIsNotEnabled()
        composeTestRule.onNodeWithText("Arthur").assertIsSelected()
        composeTestRule.onNodeWithText("Arthur").assertIsNotSelected()
        composeTestRule.onNodeWithText("Arthur").assertIsFocused()
        composeTestRule.onNodeWithText("Arthur").assertIsNotFocused()
        composeTestRule.onNodeWithText("Arthur").assertIsOn()
        composeTestRule.onNodeWithText("Arthur").assertIsOff()
        composeTestRule.onNodeWithText("Arthur").assertTextEquals("")
        composeTestRule.onNodeWithText("Arthur").assertTextContains("Arthur")
    }

    @Test
    fun whenComponentStart_thenVerifyContentIsArthur() {
        composeTestRule.setContent {
            ArisComponent()
        }

        composeTestRule.onNodeWithText("Arthur", ignoreCase = true).assertExists()
        composeTestRule.onNodeWithTag("textFieldName").assertTextContains("Arthur")
    }

    @Test
    fun whenNameIsAdded_thenVerifyTextContainGreeting() {
        composeTestRule.setContent {
            ArisComponent()
        }

        composeTestRule.onNodeWithTag("textFieldName").performTextClearance()
        composeTestRule.onNodeWithTag("textFieldName").performTextReplacement("Felipe")
        composeTestRule.onNodeWithTag("textGreeting").assertTextEquals("Te llamas Felipe")
    }

}