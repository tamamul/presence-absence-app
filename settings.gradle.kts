pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()

        // repo nexus custom
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

        // jitpack
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "Presence-Absence"
include(":app")
