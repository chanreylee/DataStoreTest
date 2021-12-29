package com.intretech.datastoretest.ext

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.dataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import com.intretech.datastoretest.AnimalPreference
import com.intretech.datastoretest.BaseApplication
import com.intretech.datastoretest.serializer.AnimalPreferencesSerializer
import org.jetbrains.annotations.NotNull

/**
 * @PackageName:com.intretech.datastoretest.ext
 * @DESC:
 * @author:  YQ16685 Chanrey Lee
 * @date 2021/12/27 - 17:54
 **/

// At the top level of your kotlin file:
val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "settings")

val Context.animalPreferences: DataStore<AnimalPreference> by dataStore(
   fileName = "animal_prefs.pb",
   serializer =AnimalPreferencesSerializer
)

suspend inline fun <reified T: Any> setPreference(@NotNull t: T) {
   when(T::class) {
      Int::class -> {}
   }
}
