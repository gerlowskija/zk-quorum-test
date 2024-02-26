plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.zookeeper:zookeeper:3.9.1")

    // ZooKeeper has a number of "provided" deps that we're just pulling in here.
    implementation("io.dropwizard.metrics:metrics-core:4.1.12.1")
    implementation("org.eclipse.jetty:jetty-server:9.4.51.v20230217")
    implementation("org.eclipse.jetty:jetty-servlet:9.4.51.v20230217")
    implementation("org.eclipse.jetty:jetty-client:9.4.51.v20230217")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("org.xerial.snappy:snappy-java:1.1.10.1")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}