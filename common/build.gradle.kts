import dependencies.*
plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("maven-publish")
}

// Library Configuration
 val pomVersion = "0.0.1-SNAPSHOT"
 val groupID = "com.raghav.common"
 val artifactID = "common-utils"
 val releaseArtifact="release"

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 21
        targetSdk = 32
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    viewBinding{
        isEnabled = true
    }
    packagingOptions {
        resources.excludes -= "/META-INF/*.kotlin_module"
    }
}

afterEvaluate {
    publishing {
        publications {
            // Creates a Maven publication called "release".
            create<MavenPublication>(releaseArtifact)
            {
                groupId = groupID
                artifactId = artifactID
                version = pomVersion
                from(components.getByName(releaseArtifact))
            }
        }
    }
}

dependencies {
    api(Dependencies.koinCore)
    api(Dependencies.kotlin_coroutines)
    implementation(Dependencies.appcompat)
    testImplementation(TestDependencies.junit)
}