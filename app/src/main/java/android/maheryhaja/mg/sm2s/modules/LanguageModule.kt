package android.maheryhaja.mg.sm2s.modules

import android.maheryhaja.mg.sm2s.LocalizedActivityVM
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val LanguageModule = module {
    viewModel<LocalizedActivityVM>()
}
