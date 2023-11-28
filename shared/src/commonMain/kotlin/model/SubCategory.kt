package model

import kotlinx.datetime.Clock

data class SubCategory(
    val doc_id: String = "",
    val main_cate_id: String = "",
    val title: String = "",
    val desc: String = "",
    val has_image: Boolean = false,
    val enable: Boolean = false,
    val sort: Int = 0,
    val create_time: Long = Clock.System.now().toEpochMilliseconds(),
    val update_time: Long = Clock.System.now().toEpochMilliseconds(),
)