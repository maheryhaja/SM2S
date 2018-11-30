package android.maheryhaja.mg.sm2s.service.MessageSA

import android.maheryhaja.mg.sm2s.data.MessageDto
import android.provider.ContactsContract
import com.pushtorefresh.storio3.contentresolver.StorIOContentResolver
import com.pushtorefresh.storio3.contentresolver.queries.Query
import io.reactivex.BackpressureStrategy
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.internal.operators.flowable.FlowableAll
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class MessageSAImpl : MessageSA, KoinComponent {

    val storIOContentResolver: StorIOContentResolver by inject()

    override fun getMessageFlowable(): Flowable<MutableList<MessageDto>> {
        val uri = "content://sms/"
        return storIOContentResolver
                .get()
                .listOfObjects(MessageDto::class.java)
                .withQuery(
                        Query.builder()
                                .uri(uri).build()
                )
                .prepare()
                .asRxFlowable(BackpressureStrategy.LATEST)
                .observeOn(AndroidSchedulers.mainThread())


    }
}