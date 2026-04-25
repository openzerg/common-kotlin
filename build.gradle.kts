plugins {
    kotlin("jvm") version "2.3.21"
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
    api("com.google.protobuf:protobuf-java:4.34.0")
}

sourceSets {
    main {
        java.srcDirs("gen")
    }
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_17
        languageVersion = org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_3
        apiVersion = org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_3
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
            version = "0.0.8"
            from(components["java"])
        }
    }
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/openzerg/common-kotlin")
            credentials {
                username = System.getenv("GITHUB_ACTOR") ?: "SilverMelon233"
                password = System.getenv("GITHUB_TOKEN") ?: ""
            }
        }
    }
}
