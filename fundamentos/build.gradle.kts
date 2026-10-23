plugins {
    id("java")
    application
}

application {
    mainClass.set("br.com.dio.Main")
}

group = "br.dio.io"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:33.1.0-jre")
}