package com.v2ray.f.dto

import android.graphics.drawable.Drawable

data class AppInfo(val appName: String,
                   val packageName: String,
                   val appIcon: Drawable,
                   val isSystemApp: Boolean,
                   var isSelected: Int)