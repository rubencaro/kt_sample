import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    kotlin("jvm") version "1.3.10"
    application
}

repositories {
    jcenter()
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))

    testCompile("org.junit.jupiter:junit-jupiter-api:5.3.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.2")
}

application {
    mainClassName = "kt_sample.AppKt"
}

tasks.withType<Test> {
    dependsOn("cleanTest") // force test execution
	useJUnitPlatform()
	testLogging {
		events("passed", "skipped", "failed")
        showStandardStreams = true
        showStackTraces = true
        exceptionFormat = TestExceptionFormat.FULL
	}
    // addTestListener(object : TestListener {
    //     override fun beforeSuite(suite: TestDescriptor) {}
    //     override fun beforeTest(testDescriptor: TestDescriptor) {}
    //     override fun afterTest(testDescriptor: TestDescriptor, result: TestResult) {}
    //     override fun afterSuite(suite: TestDescriptor, result: TestResult) {
    //         if (suite.getParent() == null) {
    //             println("\nTest summary: ${result.testCount} tests, " +
    //                     "${result.successfulTestCount} succeeded, " +
    //                     "${result.failedTestCount} failed, " +
    //                     "${result.skippedTestCount} skipped")
    //         }
    //     }
    // })
}