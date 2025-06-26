plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.hilt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.bassem.data"
    compileSdk = libs.versions.compileSdk.get().toInt()
    kotlin {
        jvmToolchain(21)
    }
    tasks.withType<Test> {
        useJUnitPlatform()
        jvmArgs("-XX:+EnableDynamicAgentLoading")
    }

    testOptions {
        packaging {
            resources.excludes.add("META-INF/*")
        }
        unitTests.isReturnDefaultValues = true

    }
}

dependencies {
    implementation(project(":core:base"))
    implementation(project(":core:utils"))
    implementation(project(":domain"))
    implementation(libs.retrofit2)
    implementation(libs.hilt.android)
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.okhttp3.logging.interceptor)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)
    ksp(libs.hilt.android.compiler)

    testImplementation(libs.bundles.unitTest)
    testImplementation(kotlin("test"))
}