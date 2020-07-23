package com.michae1.codechallenge.fragment.listfragment

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.michae1.codechallenge.data.repository.EmployeeRepository
import kotlinx.coroutines.Dispatchers

class ListViewModel @ViewModelInject constructor(
    private val repository: EmployeeRepository

): ViewModel() {
    val employees = liveData(Dispatchers.IO) {
        val list = repository.getEmployees()

        emit(list)
    }
}