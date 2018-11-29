package android.maheryhaja.mg.sm2s

import android.annotation.TargetApi
import android.arch.lifecycle.Observer
import android.content.Context
import android.content.Intent
import android.maheryhaja.mg.sm2s.common.AppLanguage
import android.maheryhaja.mg.sm2s.service.PreferenceSA.PreferenceSA
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import java.util.*

open class LocalizedActivity(val DEFAULT_LANG: String) : AppCompatActivity() {

    val localizedActivityVM: LocalizedActivityVM by viewModel()
    val preferenceSA: PreferenceSA by inject()


    fun setAppLanguage(lang: AppLanguage) {
        localizedActivityVM.setAppLanguage(lang)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        localizedActivityVM.appLanguageLiveData
                .observe(this, Observer {
                    it?.apply {
                        preferenceSA.writeString(DEFAULT_LANG, this.text)
                        updateBaseContextLocale(this@LocalizedActivity, this)

                        val intent = Intent(this@LocalizedActivity, this@LocalizedActivity::class.java)
                        startActivity(intent)
                        finish()
                    }
                })
    }

    override fun attachBaseContext(newBase: Context?) {
        newBase?.apply {
            super.attachBaseContext(updateBaseContextLocale(this, null))
        } ?: super.attachBaseContext(newBase)

    }

    fun updateBaseContextLocale(context: Context, appLanguage: AppLanguage?): Context {
        val locale = Locale(appLanguage?.text ?:
        preferenceSA.readString(DEFAULT_LANG)
                .let {
                    return@let if(it.equals("")) "fr" else it
                }
        )
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return updateResourcesLocale(context, locale)
        }

        return updateResourcesLocaleLegacy(context, locale)
    }

    @TargetApi(Build.VERSION_CODES.N)
    fun updateResourcesLocale(context: Context, locale: Locale): Context {
        val configuration = context.resources.configuration
        configuration.setLocale(locale)
        return context.createConfigurationContext(configuration)
    }

    @SuppressWarnings("deprecation")
    fun updateResourcesLocaleLegacy(context: Context, locale: Locale): Context {
        val displayMetrics = context.resources.displayMetrics
        val configuration = context.resources.configuration
        configuration.locale = locale
        context.resources.updateConfiguration(configuration, displayMetrics)
        return context
    }
}