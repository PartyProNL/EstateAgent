pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "EstateAgent"

include(":app")
include(":domain")
include(":data-core")
include(":presentation")
include(":data-local")
include(":data-remote")
include(":test-utils")

include(":domain")
include(":data-core")
include(":presentation")
include(":data-remote")
include(":data-local")
