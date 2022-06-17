package com.mangofactory.kmmsimpleapp

import io.ktor.client.*
import io.ktor.client.engine.darwin.*
import platform.UIKit.UIDevice

actual class Platform actual constructor() {

    actual fun httpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Darwin) {
        config(this)
        engine {
            configureRequest {
                setAllowsCellularAccess(true)
            }
        }
    }

    actual val platform: String =
        UIDevice.currentDevice.systemName() + " world " + UIDevice.currentDevice.systemVersion
}