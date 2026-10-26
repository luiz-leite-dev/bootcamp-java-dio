plugins {
    id("java")
    application
}

application {
    mainClass.set("br.com.dio.Main")
}

group = "br.com.dio"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":annotation"))
    compileOnly(project(":annotation"))
    implementation(project(":processor"))
    annotationProcessor(project(":processor"))
}

sourceSets {
    main {
        java {
            srcDir(layout.buildDirectory.dir("generated/sources/annotationProcessor/java/main"))
        }
    }
}