import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform") version "1.5.0"
}

group = "com.yt8492"
version = "1.0.0"

repositories {
    mavenCentral()
}

kotlin {
    macosX64()
    linuxX64()
    mingwX64()
    targets.filterIsInstance<KotlinNativeTarget>().forEach {
        with(it) {
            compilations["main"].enableEndorsedLibs = true
            binaries {
                executable {
                    entryPoint = "com.yt8492.example.main"
                }
            }
        }
    }

    sourceSets {
        val desktopMain by creating {
            dependencies {
                implementation(kotlin("stdlib-common"))
            }
        }
        val macosX64Main by getting {
            dependsOn(desktopMain)
        }
        val linuxX64Main by getting {
            dependsOn(desktopMain)
        }
        val mingwX64Main by getting {
            dependsOn(desktopMain)
        }
    }
}
