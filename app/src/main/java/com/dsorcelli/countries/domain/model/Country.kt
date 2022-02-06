package com.dsorcelli.countries.domain.model

data class Country(
    val code: String,
    val name: String,
    val imgUrl: String
) {

    companion object {
        fun mockIT(): Country {
            return Country(
                code = "IT",
                name = "Italy",
                imgUrl = "https://flagcdn.com/h240/it.png"
            )
        }
        fun mockFR(): Country {
            return Country(
                code = "FR",
                name = "France",
                imgUrl = "https://flagcdn.com/h240/fr.png"
            )
        }
        fun mockList(): List<Country> {
            return listOf(
                mockIT(),
                mockFR(),
                mockIT(),
                mockFR(),
                mockIT(),
                mockFR(),
                mockIT(),
                mockFR(),
                mockIT(),
                mockFR(),
                mockIT(),
                mockFR(),
                mockIT(),
                mockFR(),
                mockIT(),
                mockFR()
            )
        }
    }

}