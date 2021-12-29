package com.intretech.datastoretest.serializer

import androidx.datastore.core.CorruptionException
import androidx.datastore.core.Serializer
import com.google.protobuf.InvalidProtocolBufferException
import com.intretech.datastoretest.AnimalPreference
import java.io.InputStream
import java.io.OutputStream

/**
 * @PackageName:com.intretech.datastoretest.serializer
 * @DESC:  Animal序列化器
 * @author:  YQ16685 Chanrey Lee
 * @date 2021/12/28 - 19:39
 **/
object AnimalPreferencesSerializer : Serializer<AnimalPreference> {
    override val defaultValue: AnimalPreference = AnimalPreference.getDefaultInstance()

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun readFrom(input: InputStream): AnimalPreference {
        try {
            return AnimalPreference.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun writeTo(t: AnimalPreference, output: OutputStream) = t.writeTo(output)
}
