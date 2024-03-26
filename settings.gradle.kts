pluginManagement {
    repositories {
        google()
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

rootProject.name = "LogRegApp"
include(":app")
include(":feature:notes")
include(":feature:event")
include(":feature:search")
include(":feature:create_new")
include(":domain")
include(":data")
