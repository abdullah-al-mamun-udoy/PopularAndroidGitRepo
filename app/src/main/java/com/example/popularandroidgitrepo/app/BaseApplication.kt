package com.example.popularandroidgitrepo.app

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication : Application(), ImageLoaderFactory {

    //This is the entry point of the app
     override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .build()
    }
}