import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("multiplatform") version "1.7.20"
    id("org.jetbrains.compose") version "1.2.0"
}

group = "ru.chuikov"
version = "1.0-SNAPSHOT"

repositories {
    google()
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
}
dependencies{
    val DlVersion = "0.4.0"
    commonMainImplementation("org.jetbrains.kotlinx:kotlin-deeplearning-api:${DlVersion}")
    commonMainImplementation("org.jetbrains.kotlinx:kotlin-deeplearning-onnx:${DlVersion}")
    commonMainImplementation("org.jetbrains.kotlinx:kotlin-deeplearning-visualization:${DlVersion}")
//    val decomposeVersion = "1.0.0-alpha-07"
//    commonMainImplementation("com.arkivanov.decompose:decompose:${decomposeVersion}")
//    commonMainImplementation("com.arkivanov.decompose:extensions-compose-jetbrains:${decomposeVersion}")
    val odysseyVersion = "1.0.1"
    commonMainImplementation("io.github.alexgladkov:odyssey-core:${odysseyVersion}") // For core classes
    commonMainImplementation("io.github.alexgladkov:odyssey-compose:${odysseyVersion}") // For compose extensions
}


kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "11"
        }
        withJava()
    }
    sourceSets {
        val jvmMain by getting {
            dependencies {
                implementation(compose.desktop.currentOs)
            }
        }
        val jvmTest by getting
    }
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "CubeDLStudio"
            packageVersion = "1.0.0"
        }
    }
}
