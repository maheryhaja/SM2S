package android.maheryhaja.mg.sm2s.modules

import android.maheryhaja.mg.sm2s.data.*
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
                    .addTypeMapping(MessageDto::class.java, ContentResolverTypeMapping.builder<MessageDto>()
                            .putResolver(MessageDtoStorIOContentResolverPutResolver())
                            .getResolver(MessageDtoStorIOContentResolverGetResolver())
                            .deleteResolver(MessageDtoStorIOContentResolverDeleteResolver())
                            .build()
                    )
                    .build()

        }
}