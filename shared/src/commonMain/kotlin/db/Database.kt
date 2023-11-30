package db

import com.squareup.sqldelight.ColumnAdapter
import idv.tungfanhall.chadopedia.kmm.shared.cache.AppDatabase
import idv.tungfanhall.chadopedia.kmm.shared.cache.ChadoContent

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(
        driver = databaseDriverFactory.createDriver(),
        ChadoContentAdapter = ChadoContent.Adapter(
            main_categoriesAdapter = createMainCateIdAdapter(),
            sub_categoriesAdapter = createSubCateIdAdapter()
        )
    )

    val mainCategoriesQueries = database.mainCategoryQueries

    val subCategoriesQueries = database.subCategoryQueries

    val chadoContentQueries = database.chadoContentQueries

    private fun createMainCateIdAdapter(): ColumnAdapter<List<String>, String> {
        return object : ColumnAdapter<List<String>, String> {
            override fun decode(databaseValue: String): List<String> {
                return databaseValue.split(",")
            }

            override fun encode(value: List<String>): String {
                return value.joinToString(",")
            }
        }
    }

    private fun createSubCateIdAdapter(): ColumnAdapter<List<String>, String> {
        return object : ColumnAdapter<List<String>, String> {
            override fun decode(databaseValue: String): List<String> {
                return databaseValue.split(",")
            }

            override fun encode(value: List<String>): String {
                return value.joinToString(",")
            }
        }
    }
}