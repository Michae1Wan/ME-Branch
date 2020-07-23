package com.michae1.codechallenge.data.datasource

import com.michae1.codechallenge.network.ApiService
import javax.inject.Inject


/**
 *
 * Created by Michae1 (michae1wan@live.com) on 7/23/2020.
 */
class RemoteDataSource @Inject constructor(
    private val apiService: ApiService
) : BaseDataSource() {
    suspend fun getEmployees() = getResult { apiService.getEmployees() }
}