package com.oguzhandongul.countriesapp.core.utils.extensions

import java.io.InputStream

fun InputStream.bufferToJson(): String = bufferedReader().use { it.readText() }