
plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.bassem.base"
    compileSdk = libs.versions.compileSdk.get().toInt()
    kotlinOptions {
        jvmTarget = "21"
    }
    kotlin {
        jvmToolchain(21)
    }
    defaultConfig{
        minSdk = libs.versions.minSdk.get().toInt()
    }
    tasks.withType<Test> {
        useJUnitPlatform()
        jvmArgs("-XX:+EnableDynamicAgentLoading")
    }

    testOptions {
        unitTests.isReturnDefaultValues = true
    }
}

dependencies {
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    testImplementation(libs.junit.jupiter.params)
    testImplementation(libs.mockk)
}