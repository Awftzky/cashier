package org.chevalierlabsas.cashier.home.presentation

import androidx.compose.foundation.lazy.items
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.chevalierlabsas.cashier.home.domain.Item
import androidx.compose.runtime.setValue
import org.jetbrains.compose.resources.stringResource
import androidx.compose.material3.Text
import cashier.composeapp.generated.resources.Res
import cashier.composeapp.generated.resources.app_name
import androidx.compose.material3.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cashier.composeapp.generated.resources.add_item_fab_label
import cashier.composeapp.generated.resources.all_item_label
import org.chevalierlabsas.cashier.home.data.DummyDataSource
import org.chevalierlabsas.cashier.home.presentation.components.HomeSeparator
import org.chevalierlabsas.cashier.home.presentation.components.ItemCard
import org.chevalierlabsas.cashier.home.presentation.components.SaveButton
import org.chevalierlabsas.cashier.home.presentation.components.Searchbar
import org.chevalierlabsas.cashier.home.presentation.components.SelectedItemChip
import org.chevalierlabsas.cashier.home.presentation.components.TotalPriceHeader
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    // STATE
    var totalPrice by remember { mutableStateOf(0.00) }
    val selectedItems = remember { mutableStateListOf<Item>() }
    var showSelectedItem by remember { mutableStateOf(true) }
    var showAllItem by remember { mutableStateOf(true) }
    var searchQuery by remember { mutableStateOf(value = "") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(Res.string.app_name))
                }
            )
        },

        // FLOATING ACTION
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { TODO("Add Item.") },
                containerColor = MaterialTheme.colorScheme.tertiary,
                text = { Text(text = stringResource(Res.string.add_item_fab_label)) },
                icon = {
                    Icon(
                        Icons.Filled.Add,
                        contentDescription = stringResource(Res.string.add_item_fab_label)
                    )
                }
            )
        }
    ) { PaddingValues ->

        // COLUMN SCREEN

        LazyColumn(
            contentPadding = PaddingValues,
        ) {
            // TOTAL PRICE
            item {
                TotalPriceHeader(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    totalPrice = totalPrice
                )
            }

            // SAVE BUTTON
            item {
                SaveButton(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    onSave = { TODO("Save data.") },
                )
            }
            item {
                HomeSeparator(
                    modifier = Modifier.padding(horizontal = 16.dp),
                    title = stringResource(Res.string.all_item_label), // Pastikan string ini ada
                    visible = showAllItem,
                    onAction = { visible ->
                        showAllItem = visible
                    }
                )
            }

            item {
                Searchbar(
                    modifier = Modifier.padding(horizontal = 16.dp).fillMaxWidth(),
                    value = searchQuery,
                    onValueChange = { query ->
                        searchQuery = query
                    }
                )
            }

            item {
                AnimatedVisibility(
                    visible = showSelectedItem,
                    enter = expandVertically(),
                    exit = shrinkVertically()
                ) {
                    FlowRow(
                        modifier = Modifier.padding(horizontal = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(4.dp),
                        horizontalArrangement = Arrangement.spacedBy(4.dp),
                        content = {
                            selectedItems.map { item ->
                                SelectedItemChip(
                                    onRemove = {
                                        selectedItems.remove(item)
                                        totalPrice -= item.price
                                    },
                                    item = item,
                                    modifier = Modifier.padding(horizontal = 4.dp)

                                )
                            }
                        }
                    )
                }
            }
            items(DummyDataSource().getData()) { item -> // Barang individu
                AnimatedVisibility(
                    visible = showAllItem,
                    enter = fadeIn(),
                    exit = fadeOut()
                ) {
                    ItemCard(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        item = item,
                        onEdit = { },
                        onAdd = {
                            selectedItems.add(item)
                            totalPrice += item.price
                        }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    Surface{
        HomeScreen()
    }
}