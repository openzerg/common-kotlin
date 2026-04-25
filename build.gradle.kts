plugins {
    kotlin("jvm") version "2.1.21"
    `java-library`
    `maven-publish`
}

group = "io.openzerg"
version = "0.0.1"

repositories {
    mavenCentral()
}

dependencies {
    api("com.connectrpc:connect-kotlin:0.8.0")
    api("com.connectrpc:connect-kotlin-google-java-ext:0.8.0")
    api("com.google.protobuf:protobuf-java:4.29.5")
}

sourceSets {
    main {
        java.srcDirs("gen")
    }
}

kotlin {
    jvmToolchain(17)
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
        freeCompilerArgs.add("-Xskip-metadata-version-check")
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "io.openzerg"
            artifactId = "common-kotlin"
            version = "0.0.1"
            from(components["java"])
        }
    }
}
