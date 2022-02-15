package com.dsorcelli.countries.presentation.countries_list.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dsorcelli.countries.domain.model.Country
import com.dsorcelli.countries.presentation.R
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun CountryFlag(
    imgUrl: String,
    modifier: Modifier = Modifier
) {

    GlideImage(
        imageModel = imgUrl,
        modifier = modifier
            .shadow(6.dp, shape = RoundedCornerShape(8.dp))
            .clip(RoundedCornerShape(8.dp)),
        contentScale = ContentScale.Crop,
        previewPlaceholder = R.drawable.ic_country_flag_it
    )

}

@Preview
@Composable
fun CountryFlagPreview() {
    CountryFlag(
        imgUrl = Country.mockIT().imgUrl
    )
}