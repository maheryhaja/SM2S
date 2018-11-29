package android.maheryhaja.mg.sm2s

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.maheryhaja.mg.sm2s.common.AppLanguage

class LocalizedActivityVM: ViewModel() {
    var appLanguageLiveData: MutableLiveData<AppLanguage> = MutableLiveData()

    fun setAppLanguage(appLanguage: AppLanguage) {
        appLanguageLiveData.postValue(appLanguage)
    }


}