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
        maven {
            url = uri("https://zebratech.jfrog.io/artifactory/EMDK-Android/")
        }
    }
}
rootProject.name = "Mockk Jar Case"
include(":app")
 