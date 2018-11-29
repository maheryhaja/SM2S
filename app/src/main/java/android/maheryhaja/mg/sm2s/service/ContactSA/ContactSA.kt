package android.maheryhaja.mg.sm2s.service.ContactSA

import android.maheryhaja.mg.sm2s.Contact
import io.reactivex.Flowable

interface ContactSA {
    fun getContactFlowable(): Flowable<MutableList<Contact>>
}