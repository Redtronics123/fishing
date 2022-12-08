import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.20"
    application
    id("com.github.johnrengelman.shadow") version "7.1.2"
}

group = "de.redtronics"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.xerial:sqlite-jdbc:3.40.0.0")
    implementation("org.apache.poi:poi-ooxml:5.2.3")
    implementation("org.apache.logging.log4j:log4j-core:2.19.0")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "17"
}

application {
    mainClass.set("de.redtronics.MainKt")
}

tasks.withType<Jar> {
    manifest {
        attributes("Main-Class" to "de.redtronics.MainKt")
    }
}
