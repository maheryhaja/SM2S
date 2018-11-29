package android.maheryhaja.mg.sm2s

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class SplashActivityVM: ViewModel() {
    var testText: MutableLiveData<String> = MutableLiveData()



    fun sayHello() {
        testText.value = "Bonjour le monde"
    }
}