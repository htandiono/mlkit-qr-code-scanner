// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Daftarkan plugin untuk modul pustaka Android (digunakan oleh :qrscanner)
    id("com.android.library") version "8.4.2" apply false

    // Daftarkan plugin untuk Kotlin di Android (digunakan oleh :qrscanner)
    id("org.jetbrains.kotlin.android") version "2.0.0" apply false

    // Daftarkan plugin untuk Jetpack Compose (digunakan oleh :qrscanner)
    id("org.jetbrains.kotlin.plugin.compose") version "2.0.0" apply false
}