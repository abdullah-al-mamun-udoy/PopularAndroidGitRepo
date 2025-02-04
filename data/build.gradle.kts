plugins {
    with(libs.plugins) {
        id(com.android.library.get().pluginId)
        id(org.jetbrains.kotlin.android.get().pluginId)
        id(kotlin.parcelize.get().pluginId)
        id(ksp.get().pluginId)
        id(kotlin.kapt.get().pluginId)
        id(com.google.dagger.hilt.android.get().pluginId)
    }
}

android {
    namespace = "com.example.data"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
dependencies {

    with(libs) {
        implementation(core.ktx)
        implementation(activity)
        implementation(material)
        testImplementation(junit.core)
        androidTestImplementation(junit)
        androidTestImplementation(espresso.core)

        // Hilt
        implementation(bundles.hilt)
        ksp(hilt.compiler)
        ksp(hilt.compiler.ksp)
        ksp(hilt.android.compiler)

        // Room
        ksp(room.kapt)
        implementation(paging)
        implementation(bundles.room)

        // Network
        implementation(bundles.retrofit)
    }
}