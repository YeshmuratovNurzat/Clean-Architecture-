package com.etoolkit.data.repository.storage

import android.content.Context

private const val SHARED_PREFERENCES_NAME = "shared_preferences"
private const val KEY_FIRST_NAME = "first_name"
private const val KEY_LAST_NAME = "last_name"

class SharedPrefUserStorage(context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {

        sharedPreferences.edit().putString(KEY_FIRST_NAME,user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME,user.lastName).apply()

        return true
    }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, " ")
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "Default last name")

        return User(firstName = "$firstName", lastName = "$lastName")
    }
}