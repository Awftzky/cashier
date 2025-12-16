package org.chevalierlabsas.cashier.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.chevalierlabsas.cashier.home.domain.Item
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun ItemList(
    item: Item,
    modifier: Modifier = Modifier,
){
    Box(
        modifier = modifier
            .background(
                color = Color(0xFF8B7B8B), // Warna ungu keabu-abuan seperti di gambar
                shape = RoundedCornerShape(12.dp)
            )
            .padding(16.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Item kiri - Informasi produk
            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = item.name,
                    style = MaterialTheme.typography.titleSmall.copy(
                        fontWeight = FontWeight.Normal,
                        fontSize = 14.sp
                    ),
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Rp. ${item.price.toInt().toString().replace(Regex("(\\d)(?=(\\d{3})+$)"), "$1.")}",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 16.sp
                    ),
                    color = Color.White
                )
            }

            // Item kanan - Tombol aksi
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Tombol Edit
                IconButton(
                    onClick = { /* Handle edit */ },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }

                // Tombol Add
                IconButton(
                    onClick = { /* Handle add */ },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ItemlistPreview() {
    Surface {
        ItemList(
            item = Item(
                id = 1,
                userId = 1,
                name = "Telur 0.5 KG",
                price = 12000.0
            )
        )
    }
}