package com.bassem.core.designsystem

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithContentDescription
import com.bassem.redditnews.common.CustomTopBar
import org.junit.Test

@OptIn(ExperimentalMaterial3Api::class)
class CustomTopBarTest : BaseComposeTest() {

    @Test
    fun topBar_displaysTitleAndBackButton_whenTitleAndBackClickProvided() {
        var backClicked = false

        composeTestRule.setContent {
            MaterialTheme {
                CustomTopBar(
                    title = "News",
                    onBackClick = { backClicked = true }
                )
            }
        }

        assertTextIsDisplayed("News")

        composeTestRule.onNodeWithContentDescription("Back").assertIsDisplayed()

        clickNodeWithDescription("Back")
        assert(backClicked)
    }

    @Test
    fun topBar_displaysDefaultTitle_whenTitleIsNull() {
        composeTestRule.setContent {
            MaterialTheme {
                CustomTopBar(
                    title = null
                )
            }
        }

        assertTextIsDisplayed("Untitled")
    }
}
