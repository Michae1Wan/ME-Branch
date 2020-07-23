package com.michae1.codechallenge.data.datasource

import com.michae1.codechallenge.utils.Resource
import retrofit2.Response


/**
 *
 * Created by Michae1 (michae1wan@live.com) on 7/23/2020.
 */
abstract class BaseDataSource {

    protected suspend fun <T> getResult(call: suspend () -> Response<T>): Resource<T> {
        try {
            val response = call()
            if (response.isSuccessful) {
                val body = response.body()
                if (body != null) return Resource.success(body)
            }
            return error(" ${response.code()} ${response.message()}")
        } catch (e: Exception) {
            return error(e.message ?: e.toString())
        }
    }

    private fun <T> error(message: String): Resource<T> {
        return Resource.error("Api call failed: $message")

    }
}