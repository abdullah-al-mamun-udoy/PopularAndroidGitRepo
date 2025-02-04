plugins {
    with(libs.plugins) {
        id(ksp.get().pluginId)
        id(kotlin.kapt.get().pluginId)
        id(com.android.application.get().pluginId)
        id(org.jetbrains.kotlin.android.get().pluginId)
        id(kotlin.parcelize.get().pluginId)
        id(androidx.navigation.safeargs.get().pluginId)
        id(com.google.dagger.hilt.android.get().pluginId)
    }
}

android {
    namespace = "com.example.popularandroidgitrepo"
    compileSdk = libs.versions.compileSdkVersion.get().toInt()

    defaultConfig {
        applicationId = "com.example.popularandroidgitrepo"
        minSdk = libs.versions.minSdkVersion.get().toInt()
        targetSdk = libs.versions.targetSdkVersion.get().toInt()
        versionCode = libs.versions.appVersionCode.get().toInt()
        versionName = libs.versions.appVersionName.get()

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    implementation(project(":data"))
    with(libs) {
        // View
        implementation(splashscreen)
        implementation(material)
        implementation(constraint.layout)
        implementation(bundles.pager)
        implementation(datetime.picker)
        coreLibraryDesugaring(desugar)
        implementation(runtime.permission)
        implementation(number.picker)
        implementation(skydove.animation)
        implementation(system.ui.controller)

        // Kotlin
        implementation(core.ktx)
        implementation(kotlin.coroutines)

        // Hilt
        implementation(bundles.hilt)
        ksp(hilt.compiler)
        ksp(hilt.compiler.ksp)
        ksp(hilt.android.compiler)
        implementation ("androidx.paging:paging-compose:1.0.0-alpha13")

        // Jetpack
        implementation(platform(compose.bom))
        implementation(bundles.compose)
        implementation(bundles.lifecycle)
        implementation(work.manager.ktx)
        implementation(bundles.lifecycle)
        implementation(bundles.navigation)

        // Image
        implementation(bundles.coil)

        implementation(circleindicator)


        // Network
        implementation(gson)
    }
}