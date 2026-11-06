import org.asciidoctor.gradle.jvm.AsciidoctorTask

plugins {
    java
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
    id("io.freefair.lombok") version "9.8.2"
    id("org.asciidoctor.jvm.convert") version "4.0.5"
}

repositories {
    mavenCentral()
}

val snippetsDir = file("build/generated-snippets")

configurations {
    create("asciidoctorExtensions")
}

asciidoctorj {
    setVersion("3.0.0")
}

dependencies {
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation(libs.guava)

    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    add(
        "asciidoctorExtensions",
        "org.springframework.restdocs:restdocs-asciidoctor"
    )

    testImplementation("org.springframework.restdocs:spring-restdocs-mockmvc")
}

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

tasks.named<Test>("test") {
    useJUnitPlatform()
    outputs.dir(snippetsDir)
}

tasks.named<AsciidoctorTask>("asciidoctor") {
    configurations("asciidoctorExtensions")
    inputs.dir(snippetsDir)
    dependsOn(tasks.test)
}
