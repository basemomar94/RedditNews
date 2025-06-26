plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.bassem.domain"
    compileSdk = libs.versions.compileSdk.get().toInt()
    kotlin {
        jvmToolchain(21)
    }
    tasks.withType<Test> {
        useJUnitPlatform()
        jvmArgs("-XX:+EnableDynamicAgentLoading")
    }

}

dependencies {
    implementation(project(":core:base"))
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.hilt.android)

   testImplementation(libs.bundles.unitTest)

}