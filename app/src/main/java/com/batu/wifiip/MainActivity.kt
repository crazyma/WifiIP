package com.batu.wifiip

import android.content.Context
import android.net.wifi.WifiManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        test()
    }

    private fun test(){
        val wm = getSystemService(Context.WIFI_SERVICE) as WifiManager
        val ipAddressInt = wm.connectionInfo.ipAddress
        val ipAddress: String = java.lang.String.format(Locale.getDefault(), "%d.%d.%d.%d", ipAddressInt and 0xff, ipAddressInt shr 8 and 0xff, ipAddressInt shr 16 and 0xff, ipAddressInt shr 24 and 0xff)
        textView.text = ipAddress
    }
}
