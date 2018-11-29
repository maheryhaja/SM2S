package android.maheryhaja.mg.sm2s.modules

import android.maheryhaja.mg.sm2s.SplashActivityVM
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module

val ViewModelModule = module {
    viewModel<SplashActivityVM>()
}