package com.michae1.codechallenge.network

import com.michae1.codechallenge.data.model.EmployeeModel
import retrofit2.Response
import retrofit2.http.GET


/**
 *
 * Created by Michae1 (michae1wan@live.com) on 7/23/2020.
 */
interface ApiService {

    @GET("employees")
    suspend fun getEmployees() : Response<List<EmployeeModel>>
}