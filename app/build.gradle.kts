plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.mibolsillooficial"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.mibolsillooficial"
        minSdk = 27
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    // Core + lifecycle + activity-compose (ya los tienes por libs)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)

    // Compose BOM
    implementation(platform(libs.androidx.compose.bom))

    // UI Compose (sin versión explícita porque la pone el BOM)
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")

    // Material 3
    implementation("androidx.compose.material3:material3")

    // Íconos de Material (¡aquí está Icons!)
    implementation("androidx.compose.material:material-icons-extended")

    // Herramientas de preview / tests
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation(libs.androidx.ui.test.manifest)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    // (Opcional) Si NO usas XML, puedes quitar ConstraintLayout/RecyclerView/Kotlin stdlib:
    // implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    // implementation("androidx.recyclerview:recyclerview:1.2.1")
    // implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.21")
}

