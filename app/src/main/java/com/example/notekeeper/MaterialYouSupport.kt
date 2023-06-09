package com.example.notekeeper

import android.app.Application
import com.google.android.material.color.DynamicColors

class MaterialYouSupport : Application() {
    override fun onCreate() {
        super.onCreate()
        DynamicColors.applyToActivitiesIfAvailable(this)
    }
}