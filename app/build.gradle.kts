plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.zainco.jetpackcomposebasicscodelab"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.zainco.jetpackcomposebasicscodelab"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
        // fields/constants declared here will be used all over the application, but declared inside release/debug/inside the flavor will be used
        // inside its own build type/flavor only
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug/*build type*/ {
            // a config parameter could be compiled in the config
        }
    }
    /*
    as we know that jvm compiles java classes to bytecode, so if the jvm target is 1.8, the bytcode compiled will be found 1.8 and less not more
    for ex: lamda expression will be found within the bytecode because ot is presenting in java 8
    Note: jvm version choice should be compatible with the min sdk
     */
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

//dependencies existing in dependencyResolutionManagement existing in settings.gradle
dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.core:core-splashscreen:1.1.0-alpha02")
    //Compose Foundation
    implementation("androidx.compose.foundation:foundation:1.4.3")
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}

///////////////////////////////////////
// gradle tasks: displays a list of available tasks,
// project build files(build.gradle and settings.gradle) are scanned by gradle when I ran this command
// gradle build: task assembles and build the project
//needed example of failing apk generating iff the local.properties  doesn't contain the keystore
//throws GradleException if the keystore parameter is missing inside the local.properties
/**
 * // Add a custom task to check for the keystore file
 *         task checkKeystoreFile {
 *             doLast {
 *                 Properties properties = new Properties()
 *                 properties.load(project.rootProject.file('local.properties').newDataInputStream())
 *
 *                 if (properties['keystoreFile'] == null || !file(properties['keystoreFile']).exists()) {
 *                     throw new GradleException("Keystore file is missing or not specified in local.properties.")
 *                 }
 *             }
 *         }
 *
 *         // Hook the custom task to execute before the `assemble` task
 *         preBuild.dependsOn checkKeystoreFile
 */
apply {
    from("$rootDir/scripts/move-apk.gradle")
}