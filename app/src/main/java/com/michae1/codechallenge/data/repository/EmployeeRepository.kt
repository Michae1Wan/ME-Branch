package com.michae1.codechallenge.data.repository

import com.michae1.codechallenge.network.ApiService
import javax.inject.Inject


/**
 *
 * Created by Michae1 (michae1wan@live.com) on 7/23/2020.
 */
class EmployeeRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getEmployees() = apiService.getEmployees()
}