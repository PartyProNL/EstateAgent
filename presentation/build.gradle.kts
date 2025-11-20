import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.gradle.api.artifacts.VersionCatalogsExtension
val libsCatalog = extensions.getByType<VersionCatalogsExtension>().named("libs")
val buildTools = libsCatalog.findVersion("android-buildTools").get().requiredVersion

plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "me.partypronl.estateagent.presentation"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    buildToolsVersion = buildTools

    defaultConfig { minSdk = libs.versions.android.minSdk.get().toInt() }

    buildFeatures {
        compose = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.toVersion(libs.versions.jvm.get().toInt())
        targetCompatibility = JavaVersion.toVersion(libs.versions.jvm.get().toInt())
        isCoreLibraryDesugaringEnabled = true
    }

    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(libs.versions.jvm.get().toInt()))
        }
    }

    kotlin {
        compilerOptions {
            jvmTarget.set(JvmTarget.fromTarget(libs.versions.jvm.get()))
        }
    }

    libraryVariants.configureEach { addJavaSourceFoldersToModel(file("build/generated/ksp/$name/kotlin")) }
}

dependencies {

    // Modules
    implementation(project(":domain"))

    // Generic
    implementation(libs.bundles.kotlin.library)

    // Koin
    implementation(platform(libs.koin.bom))
    implementation(libs.bundles.koin.core)
    implementation(libs.bundles.koin.android)
    ksp(libs.koin.ksp)

    // Presentation
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.bundles.presentation)

    // Desugaring
    coreLibraryDesugaring(libs.desugar)
}
