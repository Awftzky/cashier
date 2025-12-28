package org.chevalierlabsas.cashier.home.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun SaveButton(
    modifier: Modifier = Modifier,
    onSave: () -> Unit
) {
    Button(
        modifier = modifier,
        onClick = onSave
    ) {
        Text(text = "Simpan Data") // Anda bisa ganti dengan stringResource
    }
}

@Preview
@Composable
fun SaveButtonPreview() {
    Surface {
        SaveButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            onSave = {}
        )
    }
}