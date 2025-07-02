# MLKit QR Code Scanner for Jetpack Compose

[![JitPack](https://jitpack.io/v/htandiono/mlkit-qr-code-scanner.svg)](https://jitpack.io/#htandiono/mlkit-qr-code-scanner)
![API](https://img.shields.io/badge/API-24%2B-brightgreen.svg?style=flat)

A lightweight and easy-to-use Jetpack Compose library for scanning QR codes using Google's ML Kit. This library provides a simple, full-screen Composable that handles the camera setup and returns the scanned result.

## Features

-   🔎 A simple, drop-in Composable for QR code scanning.
-   🚀 Built on top of Google's ML Kit for fast and reliable scanning.
-   ✅ Handles camera lifecycle and permission checks internally.
-   🎨 Clean API using simple callbacks for success and dismissal.
-   Built entirely in Kotlin and Jetpack Compose.

---
## Installation

### Step 1: Add JitPack repository

Add the JitPack repository to your project's root `settings.gradle.kts` file.

```kotlin
// settings.gradle.kts
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven { url = uri("[https://jitpack.io](https://jitpack.io)") }
    }
}
```
### Step 2: Add the dependency
Add the dependency to your module's build.gradle.kts file. Remember to replace v1.0.0 with the latest release tag if needed.

```kotlin
// app/build.gradle.kts
dependencies {
    implementation("com.github.htandiono:mlkit-qr-code-scanner:v1.0.0")
}
```

## Permissions
This library requires the Camera permission. While the component can ask for permission at runtime, you must declare the permission in your app's AndroidManifest.xml file.

```XML 
<uses-permission android:name="android.permission.CAMERA" />
<uses-feature android:name="android.hardware.camera.any" />
```

## Usage
The library provides one main Composable, QrScanner, which is best used inside a full-screen Dialog.

Here is a complete example of how to implement it:

``` Kotlin
import androidx.compose.runtime.*
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import io.github.htandiono.qrscanner.QrScanner

@Composable
fun YourScreen() {
    var showScanner by remember { mutableStateOf(false) }
    var scannedResult by remember { mutableStateOf<String?>(null) }

    // Button to launch the scanner
    Button(onClick = { showScanner = true }) {
        Text("Scan QR Code")
    }

    // Display the result once available
    scannedResult?.let {
        Text("Scanned Result: $it")
    }

    // This will show the camera scanner when `showScanner` is true
    if (showScanner) {
        Dialog(
            onDismissRequest = { showScanner = false },
            properties = DialogProperties(usePlatformDefaultWidth = false) // For full-screen display
        ) {
            QrScanner(
                onQrCodeScanned = { result ->
                    scannedResult = result
                    showScanner = false // Close the dialog on success
                },
                onDismiss = {
                    showScanner = false // Close the dialog if the user cancels
                }
            )
        }
    }
}
```

## License
This project is licensed under the GNU GPLv3 License. See the LICENSE file for the full license text.
