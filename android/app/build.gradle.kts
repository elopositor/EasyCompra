plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.plugin.serialization")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.easycompra"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.easycompra"
        minSdk = 26
        targetSdk = 34
        versionCode = 10
        versionName = "v10"
    }

    // Firma propia y estable. Sin ella, cada maquina firma con su certificado
    // de depuracion y Android obliga a desinstalar la app para actualizarla.
    // En local no hace falta: si no hay keystore, se usa la firma de siempre.
    val ficheroKeystore = rootProject.file("easycompra.jks")
    val clave = System.getenv("ANDROID_KEYSTORE_PASSWORD")

    signingConfigs {
        if (ficheroKeystore.exists() && !clave.isNullOrBlank()) {
            create("propia") {
                storeFile = ficheroKeystore
                storePassword = clave
                keyAlias = "easycompra"
                keyPassword = clave
            }
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            signingConfigs.findByName("propia")?.let { signingConfig = it }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation("androidx.core:core-ktx:1.13.1")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.3")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.3")
    implementation("androidx.activity:activity-compose:1.9.0")

    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.jakewharton.retrofit:retrofit2-kotlinx-serialization-converter:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.6.3")

    implementation("io.coil-kt:coil-compose:2.6.0")

    // Despensa, recetario y planificador: datos guardados en el movil.
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")

    implementation("androidx.compose.material:material-icons-extended")
}
