package com.example.networklib.data.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities


class AndroidNetworkMonitor(private val context: Context):NetworkMonitor {
    override fun isConnected(): Boolean {
       val con = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
       val net = con.activeNetwork ?:return false
       val cab = con.getNetworkCapabilities(net) ?:return false
        return cab.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }
}