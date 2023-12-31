package model

import kotlinx.datetime.Clock

data class ChadoContent(
    val id: String = "",
    val title: String = "",
    val desc: String = "",
    val has_image: Boolean = false,
    val enable: Boolean = false,
    val main_categories: List<String> = listOf(),
    val sub_categories: List<String> = listOf(),
    val create_time: Long = Clock.System.now().toEpochMilliseconds(),
    val update_time: Long = Clock.System.now().toEpochMilliseconds(),
)