package android.maheryhaja.mg.sm2s.data

import android.provider.ContactsContract
import com.pushtorefresh.storio3.contentresolver.annotations.StorIOContentResolverColumn
import com.pushtorefresh.storio3.contentresolver.annotations.StorIOContentResolverCreator
import com.pushtorefresh.storio3.contentresolver.annotations.StorIOContentResolverType

@StorIOContentResolverType(uri = ContactsContract.Contacts.Entity.CONTENT_DIRECTORY)
data class Contact @StorIOContentResolverCreator constructor(
        @StorIOContentResolverColumn(name = "_id", key = true) val key: String,
        @StorIOContentResolverColumn(name = ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME) val displayedName: String
)