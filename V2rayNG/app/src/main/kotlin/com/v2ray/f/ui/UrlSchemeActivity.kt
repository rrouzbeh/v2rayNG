package com.v2ray.f.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.v2ray.f.R
import com.v2ray.f.databinding.ActivityLogcatBinding
import com.v2ray.f.extension.toast
import com.v2ray.f.util.AngConfigManager

class UrlSchemeActivity : BaseActivity() {
    private lateinit var binding: ActivityLogcatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogcatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var shareUrl: String = ""
        try {
            intent?.apply {
                when (action) {
                    Intent.ACTION_SEND -> {
                        if ("text/plain" == type) {
                            intent.getStringExtra(Intent.EXTRA_TEXT)?.let {
                                shareUrl = it
                            }
                        }
                    }
                    Intent.ACTION_VIEW -> {
                        val uri: Uri? = intent.data
                        shareUrl = uri?.getQueryParameter("url")!!
                    }
                }
            }
            toast(shareUrl)
            val count = AngConfigManager.importBatchConfig(shareUrl, "", false)
            if (count > 0) {
                toast(R.string.toast_success)
            } else {
                toast(R.string.toast_failure)
            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}