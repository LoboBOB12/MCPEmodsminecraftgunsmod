package uz.akbarali.fashion.ui.modal

import android.content.Context
import android.content.SharedPreferences


object MySharedPreferences {

    private const val NAME = "akbarali2"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences


    fun init(context: Context) {
        preferences = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    fun save(key: String, value: Boolean) {
        val editor = preferences.edit()
        editor.putBoolean(key, value)
        editor.apply()
    }

    fun loadData(key: String): Boolean {
        return preferences.getBoolean(key, false)
    }
}

