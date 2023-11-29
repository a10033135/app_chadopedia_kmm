package repository

import functions.getChadoContent
import functions.getMainCate
import functions.getSubCate
import model.ChadoContent
import model.MainCategory
import model.SubCategory

class ChadoContentRepository {

    suspend fun <Data> getData(): List<Data> {
        if (!checkOfflineData()) {
            getOnlineData()
        }
        val mainCategory = getMainCate()
        val subCategory = getSubCate()
        val chadoContent = getChadoContent()

        return listOf()
    }

    // 檢查下載資料的時間正確，即通過
    fun checkOfflineData(): Boolean {
        return false
    }

    fun getOfflineData() {

    }

    fun getOnlineData() {

    }
}

//expect fun getDownloadDataTime(): Long