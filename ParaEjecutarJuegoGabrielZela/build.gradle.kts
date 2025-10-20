/*
Autor: Gabriel Frank Krisna Zela Flores
Descripcion: Archivo Gradle del módulo 'app'. Contiene la configuración del proyecto Android,
así como todas las dependencias necesarias (Material Design, Navigation, RecyclerView, etc.).
Fecha creación: 16/10/2025
Última modificación: 17/10/2025
*/

plugins {
    // Plugins del módulo app
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)

    // ✅ Safe Args: permite pasar datos de un fragment a otro de forma segura
    id("androidx.navigation.safeargs.kotlin")
}

android {
    namespace = "com.gabrielfrankkrisnazelaflores.juegodecolores"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.gabrielfrankkrisnazelaflores.juegodecolores"
        minSdk = 24
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

    // ✅ Activamos ViewBinding para evitar findViewById y simplificar el acceso a vistas
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    // --- Dependencias base ---
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // --- Navegación entre fragments (Navigation Component) ---
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.7")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.7")

    // --- RecyclerView (para mostrar historial o récords más adelante) ---
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // --- Librerías de pruebas ---
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

/*
💡 Notas del desarrollador:
- Este archivo configura el módulo principal de la app.
- Las versiones de los plugins (Android, Kotlin y Safe Args) están definidas en el build.gradle.kts de nivel proyecto.
- Safe Args generará automáticamente las clases GameFragmentDirections y ResultFragmentArgs para la navegación segura.
- ViewBinding permite escribir código más limpio y seguro.
*/
