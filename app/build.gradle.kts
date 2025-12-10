plugins {
    id("com.android.application")
    // Kotlin plugin đã loại bỏ
}

android {
    buildFeatures {
        viewBinding = true
        dataBinding = true
    }
    namespace = "com.example.myspendyapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myspendyapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    // Room cho Java
    implementation("androidx.room:room-runtime:2.5.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")

    // ViewModel & LiveData cho Java
    implementation("androidx.lifecycle:lifecycle-viewmodel:2.6.1")
    implementation("androidx.lifecycle:lifecycle-livedata:2.6.1")

    // Navigation (phiên bản cho Java)
    implementation("androidx.navigation:navigation-fragment:2.5.3")
    implementation("androidx.navigation:navigation-ui:2.5.3")
    implementation("com.google.android.material:material:1.9.0")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:1.8.10"))
}
