package repository

import db.Database
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class ChadoDataRepository : KoinComponent {

    private val database by inject<Database>()

    suspend fun getData() {
        if (!checkOfflineData()) {
            getOnlineData()
        }
    }

    // 檢查下載資料的時間正確，即通過
    fun checkOfflineData(): Boolean {
        return false
    }

    fun getOnlineData() {

    }
}

//expect fun getDownloadDataTime(): Long