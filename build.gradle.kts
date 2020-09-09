import kr.entree.spigradle.kotlin.spigot

plugins {
    kotlin("jvm") version "1.4.0"
    id("kr.entree.spigradle") version "2.2.3"
}

group = "io.heartpattern"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://maven.heartpattern.io/repository/maven-public/")
}

dependencies {
    implementation(kotlin("stdlib"))

    compileOnly(spigot("1.16.2"))
}

val shade = configurations.create("shade")
shade.extendsFrom(configurations.implementation.get())

tasks.jar {
    from(
        shade.map {
            if (it.isDirectory)
                it
            else
                zipTree(it)
        }
    )
}

spigot {
    apiVersion = "1.15"
    commands {
        create("test1")
        create("test2")
    }
}