package functions

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import model.ChadoData
import org.koin.core.component.KoinComponent


private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = LocalRepository.PreferencesName.USER)

actual class LocalRepository(private val dataStore: DataStore<Preferences>) : KoinComponent {

    private val TAG = LocalRepository::class.java.simpleName

    object PreferencesName {
        const val USER = "user_preferences"

    }

    private object PreferencesKeys {
        val CATEGORY_MAIN = intPreferencesKey("main_category")
        val CATEGORY_SUB = intPreferencesKey("sub_category")
        val CONTENT_CHADO = intPreferencesKey("chado_content")
    }

    val mainCategoriesFlow: Flow<ChadoData> = dataStore.data
        .catch { exception ->
            // dataStore.data throws an IOException when an error is encountered when reading data
        }
        .map { pref ->
            return@map ChadoData()
        }


}