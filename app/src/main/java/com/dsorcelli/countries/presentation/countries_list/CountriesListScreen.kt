package com.dsorcelli.countries.presentation.countries_list

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dsorcelli.countries.presentation.countries_list.components.CountriesListItem
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun CountriesListScreen(
    viewModel: CountriesListVM = viewModel()
) {

    val state = viewModel.state.value

    SwipeRefresh(
        modifier = Modifier.fillMaxSize(),
        state = rememberSwipeRefreshState(isRefreshing = state.refreshing),
        onRefresh = { viewModel.refresh() }
    ) {
        LazyColumn(
            contentPadding = PaddingValues(all = 18.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                items = state.countries,
                itemContent = { country ->
                    CountriesListItem(country = country)
                }
            )
        }
    }

}

@Preview
@Composable
fun CountriesListScreenPreview() {
    CountriesListScreen()
}