package android.maheryhaja.mg.sm2s

import android.Manifest
import android.maheryhaja.mg.sm2s.common.AppLanguage
import android.maheryhaja.mg.sm2s.service.ContactSA.ContactSA
import android.maheryhaja.mg.sm2s.service.SimpleTestSA
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel


class SplashActivity : LocalizedActivity("default_lang"), PermissionListener {

    val testSA: SimpleTestSA by inject()
    val contactSA: ContactSA by inject()

    //viewmodels
    val splashActivityVM: SplashActivityVM by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        TedPermission.with(this)
                .apply {
                    setPermissionListener(this@SplashActivity)
                    setDeniedMessage("Veuillez accepter pour pouvoir lire les messages")
                    setPermissions(
                            Manifest.permission.READ_SMS,
                            Manifest.permission.SEND_SMS,
                            Manifest.permission.RECEIVE_SMS,
                            Manifest.permission.READ_CONTACTS
                    )
                    check()
                }


        frechbtn.setOnClickListener { setAppLanguage(AppLanguage.FRENCH) }
        enbtn.setOnClickListener{ setAppLanguage(AppLanguage.ENGLISH)}





    }

    override fun onPermissionGranted() {
        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
        testSA.sayHello()

        contactSA
                .getContactFlowable()
                .subscribe{
                    it.forEach {
                        Log.d("test", "name ${it.displayedName}")
                    }
                }

    }

    override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
        Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show()

    }
}
