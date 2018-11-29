package android.maheryhaja.mg.sm2s.modules

import android.content.Context
import android.maheryhaja.mg.sm2s.service.ContactSA.ContactSA
import android.maheryhaja.mg.sm2s.service.ContactSA.ContactSAImpl
import android.maheryhaja.mg.sm2s.service.PreferenceSA.PreferenceSA
import android.maheryhaja.mg.sm2s.service.PreferenceSA.PreferenceSAImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val CommonModule = module{
    single<ContactSA> { ContactSAImpl() }
    single<PreferenceSA> {PreferenceSAImpl()}
}