plugins {
    kotlin("multiplatform")
    id("com.android.application")
    id("org.jetbrains.compose")
    id("com.google.gms.google-services") // This line to add the google-services
}

kotlin {
    androidTarget()
    sourceSets {
        val androidMain by getting {
            dependencies {
                implementation(project(":shared"))
                implementation(platform("com.google.firebase:firebase-bom:32.6.0")) // This line to add the firebase bom
                implementation("com.google.firebase:firebase-common-ktx:20.4.2")
                implementation("com.google.firebase:firebase-firestore:24.9.1")

                val koinAndroidVersion = "3.5.2-RC1"
                implementation("io.insert-koin:koin-android-compat:$koinAndroidVersion")
                implementation("io.insert-koin:koin-androidx-workmanager:$koinAndroidVersion")
                implementation("io.insert-koin:koin-androidx-navigation:$koinAndroidVersion")
                implementation("io.insert-koin:koin-android:$koinAndroidVersion")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")

    defaultConfig {
        applicationId = "idv.tungfanhall.android_chadopedia_app"
        minSdk = (findProperty("android.minSdk") as String).toInt()
        targetSdk = (findProperty("android.targetSdk") as String).toInt()
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}
