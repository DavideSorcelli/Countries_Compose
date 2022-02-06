package com.dsorcelli.countries.presentation.countries_list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dsorcelli.countries.domain.model.Country
import com.dsorcelli.countries.presentation.countries_list.components.CountriesListItem


@Composable
fun CountriesListScreen(
    countries: List<Country>
) {

    Box(
        Modifier
            .fillMaxWidth()
            .background(Color.Transparent)
    ) {

        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            items(
                items = countries,
                itemContent = { country ->
                    CountriesListItem(country = country)
                }
            )
        }

        Spacer(
            Modifier
                .fillMaxWidth()
                .height(36.dp)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            MaterialTheme.colors.background,
                        )
                    )
                )
                .align(Alignment.BottomCenter)
        )

    }

}

@Preview
@Composable
fun CountriesListScreenPreview() {
    CountriesListScreen(countries = Country.mockList())
}