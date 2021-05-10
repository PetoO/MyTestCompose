package com.example.testcompose

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.example.testcompose.ui.theme.TestComposeTheme
import org.junit.Rule
import org.junit.Test

class MyComposeTest {

    @get:Rule
    // createComposeRule() if you don't need access to the activityTestRule
    val composeTestRule = createComposeRule()
//    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun myTest() {
        // Start the app
        composeTestRule.setContent {
            TestComposeTheme {
                HomeScreen()
            }
        }

        composeTestRule.onNodeWithText("Profile").performClick()

        composeTestRule.onNodeWithText("Profile Page").assertIsDisplayed()
    }
}