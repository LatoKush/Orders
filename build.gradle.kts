plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation("com.fasterxml.jackson.core:jackson-databind:2.13.1")
    implementation(project(mapOf("path" to ":model")))
    implementation(project(mapOf("path" to ":generator")))
    implementation(project(mapOf("path" to ":database")))
    implementation("javax.servlet:javax.servlet-api:4.0.1")
    implementation("org.postgresql:postgresql:42.5.2")
    implementation("org.flywaydb:flyway-core:8.5.0")
    implementation(project(mapOf("path" to ":database")))
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}