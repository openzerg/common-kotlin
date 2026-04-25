plugins {
    kotlin("jvm") version "2.1.21"
    `java-library`
}

group = "com.github.openzerg"
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

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
