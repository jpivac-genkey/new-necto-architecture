package com.genkey.common.modules.basic

interface ImageBytesHolder
{
    val imageBytes: ByteArray
}

/**
 * Used for just image bytes without any image metadata
 */
class RawImageBytes(override val imageBytes: ByteArray):ImageBytesHolder
