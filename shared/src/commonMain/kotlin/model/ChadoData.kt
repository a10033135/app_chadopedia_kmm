package model

data class ChadoData(
    val mainCategories: List<MainCategory> = listOf(),
    val subCategories: List<SubCategory> = listOf(),
    val chadoContents: List<ChadoContent> = listOf(),
)