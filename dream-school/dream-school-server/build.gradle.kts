import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.1.0"
    id("io.spring.dependency-management") version "1.1.0"
    kotlin("jvm") version "1.8.21"
    kotlin("plugin.spring") version "1.8.21"
    // sqlex 插件
    id("me.danwi.sqlex") version "0.14.2"
}

group = "com.dream"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(project(":dream-school:dream-school-api"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    api(platform("org.springframework.boot:spring-boot-dependencies:${property("springBootVer")}"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}"))
    api(platform("com.alibaba.cloud:spring-cloud-alibaba-dependencies:${property("springCloudAlibabaVersion")}"))

    // JDBC
    runtimeOnly("mysql:mysql-connector-java")
    implementation("org.springframework.boot:spring-boot-starter-jdbc")
    // sqlex
    implementation("me.danwi.sqlex:core:0.14.2")
    implementation("me.danwi.sqlex:core-kotlin:0.14.2")

    // 导出
    implementation("org.apache.poi:poi:5.1.0")
    implementation("org.apache.poi:poi-ooxml:5.1.0")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
