plugins {
    id("com.android.application")
}

android {
    namespace = "com.example.music"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.music"
        minSdk = 26
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation ("io.github.cymchad:BaseRecyclerViewAdapterHelper:3.0.14")
    implementation ("com.github.bumptech.glide:glide:4.11.0")
    implementation ("io.github.youth5201314:banner:2.2.3")
    implementation ("jp.wasabeef:glide-transformations:4.3.0")
    implementation ("jp.co.cyberagent.android:gpuimage:2.1.0")

    implementation("com.squareup.okhttp3:okhttp:4.9.1")
    implementation ("com.google.code.gson:gson:2.8.5")
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")
    implementation  ("io.github.scwang90:refresh-layout-kernel:2.0.6")     //核心必须依赖
    implementation  ("io.github.scwang90:refresh-header-classics:2.0.6")    //经典刷新头
    implementation  ("io.github.scwang90:refresh-header-radar:2.0.6")       //雷达刷新头
    implementation  ("io.github.scwang90:refresh-header-falsify:2.0.6")     //虚拟刷新头
    implementation  ("io.github.scwang90:refresh-header-material:2.0.6")    //谷歌刷新头
    implementation  ("io.github.scwang90:refresh-header-two-level:2.0.6")   //二级刷新头
    implementation  ("io.github.scwang90:refresh-footer-ball:2.0.6")        //球脉冲加载
    implementation  ("io.github.scwang90:refresh-footer-classics:2.0.6")    //经典加载

    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}