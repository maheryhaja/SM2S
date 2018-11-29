package android.maheryhaja.mg.sm2s.service.PreferenceSA

interface PreferenceSA {

    fun writeString(key: String, value: String)
    fun readString(key: String): String
}