package org.chevalierlabsas.cashier.home.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import org.jetbrains.compose.ui.tooling.preview.Preview
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cashier.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import cashier.composeapp.generated.resources.total_price_label

@Composable
fun TotalPriceHeader(
    modifier: Modifier = Modifier,
    totalPrice: Double
    ){
    Column(
        modifier = modifier
    ) {
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = stringResource(Res.string.total_price_label),
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Start
        )
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Rp.$totalPrice",
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.End
        )
    }
}


@Preview
@Composable
fun TotalPriceHeaderPreview() {
    Surface {
        TotalPriceHeader(
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp),
            totalPrice = 100000.00
        )
    }
}