plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)
    id ("kotlin-kapt")
    //id ("dagger.hilt.android.plugin")
    id ("kotlin-parcelize")
}

android {
    namespace = "com.kama.kama"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kama.kama"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    signingConfigs {
        create("release") {
            storeFile = file("$projectDir/keystores/kama.jks")
            storePassword = "123456"
            keyAlias = "kama"
            keyPassword = "123456"
            enableV1Signing = true
            enableV2Signing = true
            enableV3Signing = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            signingConfig = signingConfigs.findByName("release")
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.paging.common.android)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    //hilt(依赖注解)
    //implementation(libs.androidx.hilt.work)
    //kapt(libs.androidx.hilt.compiler)

    //navigation (导航)
    implementation ("androidx.navigation:navigation-compose:2.7.7")
    //implementation ("com.google.accompanist:accompanist-navigation-animation:0.24.7-alpha")
    //implementation ("androidx.hilt:hilt-navigation-compose:$1.1.0-alpha01")

    //coil (可以加载webp),mipmap文件下 不能加载webp,但是drawable 可以
    implementation("io.coil-kt:coil-compose:2.6.0")

    //viewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.1")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.7")

    //mmkv
    implementation("com.tencent:mmkv:1.2.13")

    //Accompanist
    implementation ("com.google.accompanist:accompanist-pager:0.23.1")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.23.1")
    //implementation "com.google.accompanist:accompanist-drawablepainter:0.23.1"

    //paging
    implementation("androidx.paging:paging-compose:3.3.0")
        //implementation("androidx.paging:paging-common:3.1.1")

    //gson
    //implementation("com.google.code.gson:gson:2.10")
}