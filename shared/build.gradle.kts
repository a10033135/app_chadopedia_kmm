import org.jetbrains.kotlin.gradle.plugin.mpp.pm20.util.libsDirectory

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("org.jetbrains.compose")
    kotlin("plugin.serialization") version("1.9.21")
    id("com.squareup.sqldelight") version("1.5.5")
}

kotlin {
    androidTarget()

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val voyagerVersion = "1.0.0-rc10"
        val koinVersion = "3.5.2-RC1"
        val kamelVersion = "0.7.3"
        val ktorVersion = "2.3.4"
        val coroutineVersion = "1.7.3"
        val dataStoreVersion = "1.0.0"
        val sqlDelightVersion = "1.5.5"

        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.foundation)
                implementation(compose.material)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
                api("org.lighthousegames:logging:1.3.0")

                implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.1")

                // koin
                implementation("io.insert-koin:koin-core:$koinVersion")

                // Voyager
                implementation("cafe.adriel.voyager:voyager-navigator:$voyagerVersion")
                implementation("cafe.adriel.voyager:voyager-tab-navigator:$voyagerVersion")
                implementation("cafe.adriel.voyager:voyager-transitions:$voyagerVersion")

                // Kamel
                implementation("media.kamel:kamel-image:$kamelVersion")

                // Ktor
                implementation("io.ktor:ktor-client-core:$ktorVersion")

                // Coroutine
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")

                implementation("com.squareup.sqldelight:runtime:$sqlDelightVersion")
            }
        }
        val androidMain by getting {
            dependencies {
                api("androidx.activity:activity-compose:1.8.1")
                api("androidx.appcompat:appcompat:1.6.1")
                api("androidx.core:core-ktx:1.12.0")
                api("com.google.firebase:firebase-common-ktx:20.4.2")
                api("com.google.firebase:firebase-firestore:24.9.1")
                api("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")
                api("androidx.datastore:datastore-preferences:$dataStoreVersion")
                implementation("com.squareup.sqldelight:android-driver:$sqlDelightVersion")
                implementation("io.ktor:ktor-client-okhttp:$ktorVersion")
            }
        }
        val iosX64Main by getting
        val iosArm64Main by getting
        val iosSimulatorArm64Main by getting
        val iosMain by creating {
            dependsOn(commonMain)
            iosX64Main.dependsOn(this)
            iosArm64Main.dependsOn(this)
            iosSimulatorArm64Main.dependsOn(this)

            dependencies {
                implementation("com.squareup.sqldelight:native-driver:$sqlDelightVersion")
            }
        }
    }
}

android {
    compileSdk = (findProperty("android.compileSdk") as String).toInt()
    namespace = "com.myapplication.common"

    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    sourceSets["main"].res.srcDirs("src/androidMain/res")
    sourceSets["main"].resources.srcDirs("src/commonMain/resources")

    defaultConfig {
        minSdk = (findProperty("android.minSdk") as String).toInt()
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlin {
        jvmToolchain(17)
    }
}

sqldelight {
    database("AppDatabase") {
        packageName = "idv.tungfanhall.chadopedia.kmm.shared.cache"
    }
}