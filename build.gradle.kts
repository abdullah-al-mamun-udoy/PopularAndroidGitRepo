// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    with(libs.plugins) {
        alias(ksp) apply false
        alias(kotlin.gradle) apply false
        alias(com.android.library) apply false
        alias(com.android.application) apply false
        alias(org.jetbrains.kotlin.android) apply false
        alias(androidx.navigation.safeargs) apply false
        alias(com.google.dagger.hilt.android) apply false
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}