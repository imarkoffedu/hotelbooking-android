package com.example.hotelbooking_android.presentation.common.hooks

import androidx.compose.runtime.Composable
import kotlinx.coroutines.launch

data class SubmissionState(
    val isLoading: Boolean,
    val errorMessage: String,
    val submit: () -> Unit
)

// here you can see a React monkey who tried
// to implement hook logic in Jetpack Compose (unfortunately with success)
@Composable
fun useStateHandler(
    onSubmit: (suspend () -> Unit)?,
    unknownErrorString: String = "An unknown error occurred"
): SubmissionState {

    // even wrote custom hooks
    val scope = useScope()
    var (isLoading, setIsLoading) = useState(false)
    var (errorMessage, setErrorMessage) = useState("")

    // in this place a React monkey fall in love with arrow functions in JavaScript
    // and forgot how to deal with "fun" :(
    val submit: () -> Unit = {
        if (onSubmit != null) {
            scope.launch {
                setIsLoading(true)
                setErrorMessage("")

                try {
                    onSubmit()
                } catch (e: Exception) {
                    setErrorMessage(e.message ?: unknownErrorString)
                } finally {
                    setIsLoading(false)
                }
            }
        }
    }

    // poor baby, kotlin does not allow to return states as { isLoading, errorMessage, submit }
    return SubmissionState(
        isLoading = isLoading,
        errorMessage = errorMessage,
        submit = submit
    )
}