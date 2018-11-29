package android.maheryhaja.mg.sm2s.modules

import android.content.ContentResolver
import android.content.Context
import android.maheryhaja.mg.sm2s.Contact
import android.maheryhaja.mg.sm2s.ContactStorIOContentResolverDeleteResolver
import android.maheryhaja.mg.sm2s.ContactStorIOContentResolverGetResolver
import android.maheryhaja.mg.sm2s.ContactStorIOContentResolverPutResolver
import com.pushtorefresh.storio3.contentresolver.ContentResolverTypeMapping
import com.pushtorefresh.storio3.contentresolver.StorIOContentResolver
import com.pushtorefresh.storio3.contentresolver.impl.DefaultStorIOContentResolver
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

val StoreIOModule = module {
        single<StorIOContentResolver>{
            DefaultStorIOContentResolver.builder()
                    .contentResolver(androidContext().contentResolver)
                    .addTypeMapping(Contact::class.java, ContentResolverTypeMapping.builder<Contact>()
                            .putResolver(ContactStorIOContentResolverPutResolver())
                            .getResolver(ContactStorIOContentResolverGetResolver())
                            .deleteResolver(ContactStorIOContentResolverDeleteResolver())
                            .build()
                    )
                    .build()

        }
}