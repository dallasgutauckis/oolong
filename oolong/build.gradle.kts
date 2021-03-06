import org.jetbrains.kotlin.gradle.plugin.mpp.AbstractKotlinNativeTargetPreset

val GROUP: String by project
val VERSION_NAME: String by project

group = GROUP
version = VERSION_NAME

plugins {
    kotlin("multiplatform")
}

repositories {
    jcenter()
}

kotlin {
    jvm()

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(deps.kotlin.coroutines.core)
            }
        }

        val jvmTest by getting {
            dependencies {
                implementation(deps.kotlin.coroutines.test)
                implementation(deps.kotlin.test.jvm)
                implementation(deps.kotlin.test.junit5)
            }
        }

        val nativeMain by creating
    }

    targets {
        // Print supported targets with:
        // scripts/fetch_native_targets org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.9
        val supportedTargets = setOf(
            "ios_arm32",
            "ios_arm64",
            "ios_x64",
            "linux_x64",
            "macos_x64",
            "mingw_x64",
            "tvos_arm64",
            "tvos_x64",
            "watchos_arm32",
            "watchos_arm64",
            "watchos_x86"
        )

        presets
            .filterIsInstance<AbstractKotlinNativeTargetPreset<*>>()
            .filter { it.konanTarget.name in supportedTargets }
            .forEach { preset ->
                try {
                    targetFromPreset(preset, preset.name) {
                        compilations["main"].source(sourceSets["nativeMain"])
                    }
                } catch (e: Exception) {
                    println("Unsupported target: ${preset.name}")
                }
            }
    }
}

apply("$rootDir/gradle/gradle-mvn-mpp-push.gradle")
