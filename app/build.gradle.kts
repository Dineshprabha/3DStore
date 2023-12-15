plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
}

android {
    namespace = "com.dineshprabha.a3dstore"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.dineshprabha.a3dstore"
        minSdk = 26
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    buildFeatures {
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = listOf("-Xjvm-default=all")
    }

    kapt {
        generateStubs = true
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

//    implementation("com.google.dagger:hilt-android:2.49")
//    kapt("com.google.dagger:hilt-compiler:2.49")

//    //dagger2
//    api("com.google.dagger:dagger:2.49")
//    api("com.google.dagger:dagger-android:2.49")
//    api("com.google.dagger:dagger-android-support:2.49")

//    annotationProcessor("com.google.dagger:dagger-compiler:2.49")
//    kapt("com.google.dagger:dagger-compiler:2.49")
//
//    annotationProcessor("com.google.dagger:dagger-android-processor:2.49")
//    kapt("com.google.dagger:dagger-android-processor:2.49")

//    compileOnly("javax.annotation:jsr250-api:1.0")
//    implementation("javax.inject:javax.inject:1")

    implementation("com.google.dagger:dagger:2.49")
    kapt("com.google.dagger:dagger-compiler:2.49")

    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.1")
    kapt("org.jetbrains.kotlinx:kotlinx-metadata-jvm:0.8.0")

}

kapt {
    correctErrorTypes = true
}