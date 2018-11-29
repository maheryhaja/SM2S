package android.maheryhaja.mg.sm2s.service

import android.util.Log

class SimpleTestSAImpl: SimpleTestSA  {
    override fun sayHello() {
        Log.d("test", "working properly")
    }
}