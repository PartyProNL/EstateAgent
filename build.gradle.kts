import org.jetbrains.kotlin.gradle.plugin.LanguageSettingsBuilder

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.android.library) apply false
}

subprojects {
    afterEvaluate {
        plugins.withId("com.android.library") {
            extensions.findByType<org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension>()
                ?.sourceSets
                ?.all { languageSettings.optInExperimentalTime() }
        }

        plugins.withId("com.android.application") {
            extensions.findByType<org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension>()
                ?.sourceSets
                ?.all { languageSettings.optInExperimentalTime() }
        }

        plugins.withId("org.jetbrains.kotlin.jvm") {
            extensions.findByType<org.jetbrains.kotlin.gradle.dsl.KotlinJvmProjectExtension>()
                ?.sourceSets
                ?.all { languageSettings.optInExperimentalTime() }
        }
    }
}

private fun LanguageSettingsBuilder.optInExperimentalTime() {
    optIn("kotlin.time.ExperimentalTime")
}
