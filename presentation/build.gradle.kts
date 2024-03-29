import org.jetbrains.kotlin.cli.common.arguments.DefaultValues.ApiVersions.defaultValue
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("dagger.hilt.android.plugin")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    namespace = "com.team_ia.idea_archive_android"
    compileSdk = Versions.COMPILE_SDK_VERSION

    defaultConfig {
        applicationId = "com.team_ia.idea_archive_android"
        minSdk = Versions.MIN_SDK_VERSION
        targetSdk = Versions.TARGET_SDK_VERSION
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        buildConfigField("String", "GOOGLE_CLIENT_ID", getApiKey("GOOGLE_CLIENT_ID", ""))
        buildConfigField("String","GITHUB_CLIENT_ID", getApiKey("GITHUB_CLIENT_ID", ""))
        buildConfigField("String", "KAKAO_NATIVE_APP_KEY", getApiKey("KAKAO_NATIVE_APP_KEY", ""))
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = Versions.JAVA_VERSION
        targetCompatibility = Versions.JAVA_VERSION
    }
    kotlinOptions {
        jvmTarget = Versions.JAVA_VERSION.toString()
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
}
dependencies {
    implementation(project(":domain"))
    implementation(project(":di"))

    implementation(Dependency.AndroidX.APP_COMPAT)
    implementation(Dependency.AndroidX.CORE_KTX)
    implementation(Dependency.AndroidX.FRAGMENT_KTX)
    implementation(Dependency.AndroidX.CONSTRAINT_LAYOUT)
    implementation(Dependency.AndroidX.LIFECYCLE_VIEWMODEL_KTX)
    implementation(Dependency.AndroidX.LIFECYCLE_RUNTIME)
    implementation(Dependency.AndroidX.RECYCLER_VIEW)
    implementation(Dependency.AndroidX.VIEWPAGER_2)

    implementation(Dependency.Google.GMS_PLAY_SERVICE_AUTH)

    implementation(Dependency.Kakao.KAKAO_SDK)

    implementation(Dependency.AndroidX.ROOM_KTX)
    kapt(Dependency.AndroidX.ROOM_COMPILER)

    implementation(Dependency.Kotlin.COROUTINES_CORE)
    implementation(Dependency.Kotlin.COROUTINES_ANDROID)

    implementation(Dependency.Google.MATERIAL)
    implementation(Dependency.Google.HILT_ANDROID)
    kapt(Dependency.Google.HILT_ANDROID_COMPILER)

    implementation(Dependency.Libraries.RETROFIT)
    implementation(Dependency.Libraries.RETROFIT_CONVERTER_GSON)
    implementation(Dependency.Libraries.OKHTTP)
    implementation(Dependency.Libraries.OKHTTP_LOGGING_INTERCEPTOR)
    implementation(Dependency.Libraries.MOSHI)
    kapt(Dependency.Libraries.MOSHI_COMPILER)

    testImplementation(Dependency.UnitTest.JUNIT)
    testImplementation(Dependency.UnitTest.MOCKITO)

    androidTestImplementation(Dependency.AndroidTest.ANDROID_JUNIT)
    androidTestImplementation(Dependency.AndroidTest.ESPRESSO_CORE)

    implementation(Dependency.BottomNav.NAV_FRAGMENT)
    implementation(Dependency.BottomNav.NAV_UI)

    implementation(Dependency.Rx.RX_BINDING)
    implementation(Dependency.Rx.RX_JAVA)
    implementation(Dependency.Rx.RX_ANDROID)

    implementation(Dependency.ImageLoad.GLIDE)
    implementation(Dependency.ImageLoad.COIL)

    implementation(Dependency.Libraries.SHIMMER)

    implementation(Dependency.Lottie.LOTTIE)
}

fun getApiKey(propertyKey: String, defalutValue: String): String {
    val propFile = rootProject.file("./local.properties")
    val properties = Properties()
    properties.load(FileInputStream(propFile))
    return properties.getProperty(propertyKey, defaultValue)
}