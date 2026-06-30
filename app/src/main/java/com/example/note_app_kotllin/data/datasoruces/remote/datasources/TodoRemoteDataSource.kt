package com.example.note_app_kotllin.data.datasoruces.remote.datasources

import com.example.Todo_app_kotllin.data.datasoruces.remote.services.TodoApiService
import javax.inject.Inject

class TodoRemoteDataSource @Inject constructor(
    private val todoApiService: TodoApiService
){

}