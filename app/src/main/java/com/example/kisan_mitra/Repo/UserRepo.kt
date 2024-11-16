package com.example.kisan_mitra.Repo

import com.example.kisan_mitra.State
import com.example.kisan_mitra.data.apiProvider
import com.example.kisan_mitra.data.apiService
import com.example.kisan_mitra.data.response.Signup
import com.example.kisan_mitra.data.response.loginresponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class UserRepo @Inject constructor(
    private val apiService: apiService
){
    suspend fun SignUpUser(
        name: String,
        password: String,
        email: String,
        phone_number: String
    ): Flow<State<Response<Signup>>> = flow {
        emit(State.Loading)
        try {
            val response = apiProvider.provideApi().SignUpUser(
                name = name,
                password = password,
                email = email,
                phone_number = phone_number,
            )
            emit(State.Success(response))
        } catch (e: Exception) {
            emit(State.Error(e.message.toString()))
        }
    }

    suspend fun login(
        email: String,
        password: String
    ): Flow<State<Response<loginresponse>>> = flow {
        emit(State.Loading)
        try {
            val response = apiProvider.provideApi().login(
                email = email,
                password = password,
            )
            emit(State.Success(response))
        } catch (e: Exception) {
            emit(State.Error(e.message.toString()))

        }
    }



}