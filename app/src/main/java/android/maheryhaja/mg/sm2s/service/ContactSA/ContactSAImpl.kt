package android.maheryhaja.mg.sm2s.service.ContactSA

import android.maheryhaja.mg.sm2s.Contact
import android.net.Uri
import android.provider.ContactsContract
import com.pushtorefresh.storio3.contentresolver.StorIOContentResolver
import com.pushtorefresh.storio3.contentresolver.queries.Query
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject


class ContactSAImpl : KoinComponent, ContactSA {

    val storIOContentResolver: StorIOContentResolver by inject()

    override fun getContactFlowable(): Flowable<MutableList<Contact>> =
            storIOContentResolver
                    .get()
                    .listOfObjects(Contact::class.java)
                    .withQuery(
                            Query.builder()
                                    .uri(ContactsContract.CommonDataKinds.Phone.CONTENT_URI).build()
                    )
                    .prepare()
                    .asRxFlowable(BackpressureStrategy.LATEST)
                    .observeOn(AndroidSchedulers.mainThread())

}