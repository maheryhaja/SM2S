package android.maheryhaja.mg.sm2s

import android.app.Application
import android.maheryhaja.mg.sm2s.modules.*
import org.koin.android.ext.android.startKoin

class CustomApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val modules = if (BuildConfig.BUILD_VARIANT.equals("prod")) mutableListOf(ProductionModule) else mutableListOf(TestModule)
        modules.apply {
            add(StoreIOModule)
            add(CommonModule)
            add(ViewModelModule)
            add(LanguageModule)
        }
        startKoin(this, modules)
    }
}