package android.maheryhaja.mg.sm2s.modules

import android.maheryhaja.mg.sm2s.service.SimpleTestSA
import android.maheryhaja.mg.sm2s.service.SimpleTestSAImpl
import android.maheryhaja.mg.sm2s.service.SimpleTestSAProdImpl
import org.koin.dsl.module.module

val TestModule = module {
    single<SimpleTestSA> { SimpleTestSAImpl() }
}

val ProductionModule = module {
    single<SimpleTestSA> { SimpleTestSAProdImpl() }
}
