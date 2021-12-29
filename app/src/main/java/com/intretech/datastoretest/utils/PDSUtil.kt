package com.intretech.datastoretest.utils

import android.util.Log
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.intretech.datastoretest.AnimalPreference
import com.intretech.datastoretest.BaseApplication
import com.intretech.datastoretest.ext.animalPreferences
import com.intretech.datastoretest.ext.dataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import java.io.IOException

/**
 * @PackageName:com.intretech.datastoretest.utils
 * @DESC:
 * @author:  YQ16685 Chanrey Lee
 * @date 2021/12/27 - 16:56
 **/
object PDSUtil {

    val TAG = this::class.java.simpleName

    const val dsName = "setting"
    private val nameKey = stringPreferencesKey("userName")

    private val context = BaseApplication.context


    suspend fun setUserName(name: String) {
        context!!.dataStore.edit {setting ->
            setting[nameKey] = name
        }
        
    }

    fun getUserName() : LiveData<String> {
        val userNameFlow = context!!.dataStore.data.map {
            it[nameKey] ?: ""
        }
        Log.w(TAG, "$userNameFlow")
        return userNameFlow.asLiveData()
    }

    suspend fun setAnimal(name: String) {
        context!!.animalPreferences.updateData {
            it.toBuilder()
                .setAnimalName(name)
                .setName(name)
                .setMonths(20)
                .build()
        }
    }

    suspend fun setAnimalName(name: String) {
        context!!.animalPreferences.updateData {
            it.toBuilder()
                .setAnimalName(name)
                .build()
        }
    }

    fun getAnimal() : LiveData<String> {
       return animalPreferencesFlow.map {
            it.animalName
        }.asLiveData()
    }


    private val animalPreferencesFlow = context!!.animalPreferences.data
        .catch { exception ->
            if (exception is IOException) {
                Log.e(TAG, "Error reading sort order preferences.", exception)
                emit(AnimalPreference.getDefaultInstance())
            } else {
                throw exception
            }
        }.map {
            it
        }

}
