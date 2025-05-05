package com.pro2on.demorust

object RustBridge {
    init {
        System.loadLibrary("string_reverser")
    }

    @Suppress("MissingNativeMethod")
    external fun reverseString(input: String): String
}
