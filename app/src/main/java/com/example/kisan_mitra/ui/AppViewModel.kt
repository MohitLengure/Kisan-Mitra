package com.example.kisan_mitra.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kisan_mitra.Repo.UserRepo
import com.example.kisan_mitra.State
import com.example.kisan_mitra.data.response.Signup
import com.example.kisan_mitra.data.response.loginresponse
import com.google.firebase.database.core.Repo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class AppViewModel @Inject constructor(
    private val repo: UserRepo
) : ViewModel() {
    private val _singUpUserState = MutableStateFlow(SignUpUserState())
    val singUpUserState = _singUpUserState.asStateFlow()

    fun signUpUser(
        name: String,
        password: String,
        email: String,
        phone_number: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.SignUpUser(
                name = name,
                password = password,
                email = email,
                phone_number = phone_number
            )
                .collect {
                    when (it) {
                        is State.Loading -> {
                            _singUpUserState.value = SignUpUserState(Loading = true)
                        }

                        is State.Success -> {
                            _singUpUserState.value =
                                SignUpUserState(Data = it.data, Loading = false)

                        }

                        is State.Error -> {
                            _singUpUserState.value =
                                SignUpUserState(Error = it.message, Loading = false)
                        }
                    }
                }
        }
    }


    private val _signInUserState = MutableStateFlow(LoginUserState())
    val signInUserState = _signInUserState.asStateFlow()

    fun LoginUser(
        email: String,
        password: String
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.login(
                email, password
            ).collect { state ->
                when (state) {
                    is State.Loading -> {
                        _signInUserState.value = LoginUserState(Loading = true)
                    }

                    is State.Success -> {
                        _signInUserState.value = LoginUserState(Data = state.data, Loading = false)
                    }

                    is State.Error -> {
                        _signInUserState.value =
                            LoginUserState(Error = state.message, Loading = false)
                    }
                }
            }
        }
    }

}

    data class SignUpUserState(
        val Loading: Boolean = false,
        val Error: String? = null,
        val Data: Response<Signup>? = null
    )
data class LoginUserState(
    val Loading: Boolean = false,
    val Error: String? = null,
    val Data: Response<loginresponse>? = null
)