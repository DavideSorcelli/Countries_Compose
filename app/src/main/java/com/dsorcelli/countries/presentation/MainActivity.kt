package com.dsorcelli.countries.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.dsorcelli.countries.domain.model.Country
import com.dsorcelli.countries.presentation.countries_list.CountriesListScreen
import com.dsorcelli.countries.presentation.ui.theme.CountriesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainActivityScreen()
        }
    }
}

@Composable
fun MainActivityScreen() {
    CountriesTheme {
        CountriesListScreen(countries = Country.mockList())
    }
}

@Preview
@Composable
fun MainActivityScreenPreview() {
    MainActivityScreen()
}