package android.maheryhaja.mg.sm2s.service.MessageSA

import android.maheryhaja.mg.sm2s.data.MessageDto
import io.reactivex.Flowable
import io.reactivex.internal.operators.flowable.FlowableAll

interface MessageSA {
    fun getMessageFlowable(): Flowable<MutableList<MessageDto>>
}