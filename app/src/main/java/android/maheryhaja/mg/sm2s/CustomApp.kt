package android.maheryhaja.mg.sm2s

import android.app.Application
import android.content.Context
import android.maheryhaja.mg.sm2s.modules.*
import com.facebook.stetho.Stetho
import me.everything.providers.stetho.ProvidersStetho
import org.koin.android.ext.android.startKoin

class CustomApp : Application() {
    override fun onCreate() {
        super.onCreate()

        //stetho

        val context: Context = this
        val providerStetho = ProvidersStetho(context)
        providerStetho.enableDefaults()



//        Stetho.initialize(
//                Stetho.newInitializerBuilder(context)
//                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(context))
//                        .enableWebKitInspector(providerStetho.defaultInspectorModulesProvider())
//                        .build()
//        )


        Stetho.initializeWithDefaults(this)

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