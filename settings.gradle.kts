pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        // Nexus private (pakai auth kalau ada local.properties)
        val localProperties = java.util.Properties()
        val localFile = file("local.properties")
        if (localFile.exists()) {
            localProperties.load(java.io.FileInputStream(localFile))

            maven {
                url = uri("https://inexus.samentic.com/repository/samentic-android/")
                credentials {
                    username = localProperties["nexus.username"] as? String
                    password = localProperties["nexus.password"] as? String
                }
            }
        }

        maven("https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()

        // Nexus private
        val localProperties = java.util.Properties()
        val localFile = file("local.properties")
        if (localFile.exists()) {
            localProperties.load(java.io.FileInputStream(localFile))

            maven {
                url = uri("https://inexus.samentic.com/repository/samentic-android/")
                credentials {
                    username = localProperties["nexus.username"] as? String
                    password = localProperties["nexus.password"] as? String
                }
            }
        }

        maven("https://jitpack.io")
    }
}

rootProject.name = "Presence-Absence"
include(":app")
