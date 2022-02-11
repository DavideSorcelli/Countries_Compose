package com.dsorcelli.countries.presentation.countries_list.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dsorcelli.countries.domain.model.Country


@Composable
fun CountriesListItem(
    country: Country
) {

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        elevation = 2.dp,
        backgroundColor = Color.White
    ) {
        Row(
            modifier = Modifier
                .height(65.dp)
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CountryFlag(imgUrl = country.imgUrl, modifier = Modifier.fillMaxWidth(0.2f))
            Row {
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = country.name,
                    style = MaterialTheme.typography.h5,
                    color = Color.DarkGray,
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = country.code,
                    style = MaterialTheme.typography.h5,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.width(8.dp))
            }
        }
    }

}


@Preview
@Composable
fun CountriesListItemPreview() {
    CountriesListItem(
        country = Country.mockIT()
    )
}