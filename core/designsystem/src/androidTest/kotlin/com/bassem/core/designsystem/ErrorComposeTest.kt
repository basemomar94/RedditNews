package com.bassem.core.designsystem


import androidx.compose.material3.MaterialTheme
import com.bassem.redditnews.common.ErrorCompose
import org.junit.Test

class ErrorComposeTest : BaseComposeTest() {

    @Test
    fun errorMessageIsDisplayedAndRetryButtonWorks() {
        var retryClicked = false
        val errorMessage = "Something went wrong"

        composeTestRule.setContent {
            MaterialTheme {
                ErrorCompose(
                    message = errorMessage,
                    onRetry = { retryClicked = true }
                )
            }
        }

        assertTextIsDisplayed(errorMessage)
        assertTextIsDisplayed("Retry")

        clickNodeWithText("Retry")
        assert(retryClicked)
    }
}
