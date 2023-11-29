package functions

import com.google.firebase.Firebase
import com.google.firebase.Timestamp
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await
import model.ChadoContent
import model.MainCategory
import model.SubCategory

actual suspend fun getMainCate(): List<MainCategory> {
    return Firebase.firestore.collection("MainCate").get().await().documents.toMainCategory()
}

actual suspend fun getSubCate(): List<SubCategory> {
    return Firebase.firestore.collection("SubCate").get().await().documents.toSubCategory()
}

actual suspend fun getChadoContent(): List<ChadoContent> {
    return Firebase.firestore.collection("ChadoContent").get().await().documents.toChadoContent()
}

fun List<DocumentSnapshot>.toMainCategory(): List<MainCategory> {
    return this.map {
        MainCategory(
            id = it.id,
            title = it["title"] as? String ?: "",
            desc = it["desc"] as? String ?: "",
            has_image = it["has_image"] as? Boolean ?: false,
            enable = it["enable"] as? Boolean ?: false,
            sort = it["sort"] as? Int ?: 0,
            create_time = (it["create_time"] as? Timestamp)?.seconds ?: 0,
            update_time = (it["update_time"] as? Timestamp)?.seconds ?: 0,
        )
    }
}

fun List<DocumentSnapshot>.toSubCategory(): List<SubCategory> {
    return this.map {
        SubCategory(
            id = it.id,
            main_cate_id = it["main_cate_id"] as? String ?: "",
            title = it["title"] as? String ?: "",
            desc = it["desc"] as? String ?: "",
            has_image = it["has_image"] as? Boolean ?: false,
            enable = it["enable"] as? Boolean ?: false,
            sort = it["sort"] as? Int ?: 0,
            create_time = (it["create_time"] as? Timestamp)?.seconds ?: 0,
            update_time = (it["update_time"] as? Timestamp)?.seconds ?: 0,
        )
    }
}

fun List<DocumentSnapshot>.toChadoContent(): List<ChadoContent> {
    return this.map {
        ChadoContent(
            id = it.id,
            title = it["title"] as? String ?: "",
            desc = it["desc"] as? String ?: "",
            has_image = it["has_image"] as? Boolean ?: false,
            enable = it["enable"] as? Boolean ?: false,
            main_categories = it["main_categories"] as? List<String> ?: listOf(),
            sub_categories = it["sub_categories"] as? List<String> ?: listOf(),
            create_time = (it["create_time"] as? Timestamp)?.seconds ?: 0,
            update_time = (it["update_time"] as? Timestamp)?.seconds ?: 0,
        )
    }
}