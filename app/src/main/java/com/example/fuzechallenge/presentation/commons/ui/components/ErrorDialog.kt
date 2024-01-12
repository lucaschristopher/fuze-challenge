package com.example.fuzechallenge.presentation.commons.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.fuzechallenge.R
import com.example.fuzechallenge.presentation.commons.ui.theme.FuzeChallengeTheme
import com.example.fuzechallenge.presentation.commons.ui.theme.RedFuze

@Composable
internal fun ErrorDialog(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            onDismissRequest = {
                openDialog.value = false
            },
            title = {
                Text(text = stringResource(R.string.error_dialog_title))
            },
            text = {
                Text(text = stringResource(R.string.error_dialog_default_description))
            },
            confirmButton = {
                TextButton(onClick = {
                    onClick()
                    openDialog.value = false
                }) {
                    Text(
                        text = stringResource(id = R.string.reload_label).uppercase(),
                        color = RedFuze
                    )
                }
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ErrorDialogPreview() {
    FuzeChallengeTheme {
        ErrorDialog()
    }
}
