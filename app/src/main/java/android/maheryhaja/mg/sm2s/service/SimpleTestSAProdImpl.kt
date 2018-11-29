package android.maheryhaja.mg.sm2s.service

import android.util.Log

class SimpleTestSAProdImpl : SimpleTestSA {
    override fun sayHello() {
        Log.d("test", "everything works properly in production")
    }
}