package org.chevalierlabsas.cashier.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cashier.composeapp.generated.resources.Res
import cashier.composeapp.generated.resources.expand_desc
import org.jetbrains.compose.resources.stringResource

@Composable
fun HomeSeparator(
    modifier: Modifier = Modifier,
    title: String,
    visible: Boolean,
    onAction:(Boolean) -> Unit
){
    Row(
       modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = title,
            style = MaterialTheme.typography.labelLarge
        )
        Spacer(modifier = Modifier.width(12.dp))
        Box(
            modifier = Modifier.weight(1f)
                .height(2.dp).background(MaterialTheme.colorScheme.onBackground)
        )
        Spacer(modifier = Modifier.width(4.dp))
        IconButton(onClick = { onAction(!visible) }
        ){
            Icon(
                imageVector = if (visible) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = stringResource(Res.string.expand_desc)
            )
        }
    }
}

