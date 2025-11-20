import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    id("java-library")
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

java {
    sourceCompatibility = JavaVersion.toVersion(libs.versions.jvm.get().toInt())
    targetCompatibility = JavaVersion.toVersion(libs.versions.jvm.get().toInt())
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(libs.versions.jvm.get().toInt()))
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.fromTarget(libs.versions.jvm.get()))
    }
}

dependencies {

    // Modules
    implementation(project(":domain"))

    // Generic
    implementation(libs.bundles.kotlin.library)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.bundles.koin.core)
    ksp(libs.koin.ksp)
}
