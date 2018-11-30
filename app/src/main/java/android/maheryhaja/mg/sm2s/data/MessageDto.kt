package android.maheryhaja.mg.sm2s.data

import android.provider.ContactsContract
import com.pushtorefresh.storio3.contentresolver.annotations.StorIOContentResolverColumn
import com.pushtorefresh.storio3.contentresolver.annotations.StorIOContentResolverCreator
import com.pushtorefresh.storio3.contentresolver.annotations.StorIOContentResolverType
import java.util.*

@StorIOContentResolverType(uri = "content://sms/")
data class MessageDto @StorIOContentResolverCreator constructor(
        @StorIOContentResolverColumn(name = "_id", key = true) val key: String,
        @StorIOContentResolverColumn(name = "address") val phoneNumber: String,
        @StorIOContentResolverColumn(name = "body") val body: String,
        @StorIOContentResolverColumn(name = "date") val date: String,
        @StorIOContentResolverColumn(name = "status") val status: String,
        @StorIOContentResolverColumn(name = "person") val contactId: String?,
        @StorIOContentResolverColumn(name = "type") val type: Int


)