package com.v2ray.f.ui

import android.content.Context
import android.os.Build
import android.view.MenuItem
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.v2ray.f.util.MyContextWrapper
import com.v2ray.f.util.Utils

abstract class BaseActivity : AppCompatActivity() {
    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun attachBaseContext(newBase: Context?) {
        val context = newBase?.let {
            MyContextWrapper.wrap(newBase,  Utils.getLocale(newBase))
        }
        super.attachBaseContext(context)
    }
}
