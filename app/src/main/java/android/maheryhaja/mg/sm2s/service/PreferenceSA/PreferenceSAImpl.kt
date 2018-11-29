package android.maheryhaja.mg.sm2s.service.PreferenceSA

import android.content.Context
import android.content.SharedPreferences
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class PreferenceSAImpl : PreferenceSA, KoinComponent {

    val context: Context by inject()
    val preference: SharedPreferences = context.getSharedPreferences("sm2s_preference", Context.MODE_PRIVATE)

    override fun writeString(key: String, value: String) = preference.edit().run{
        putString(key, value)
        apply()
    }


    override fun readString(key: String): String = preference.getString(key, "")
}