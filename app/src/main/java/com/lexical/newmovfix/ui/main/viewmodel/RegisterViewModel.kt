package com.lexical.newmovfix.ui.main.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lexical.newmovfix.data.api.RetrofitInstance
import com.lexical.newmovfix.data.model.LoginUserResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers

class RegisterViewModel(): ViewModel() {

    private val loginUserResponse = MutableLiveData<LoginUserResponse>()
    private val errorListener = MutableLiveData<Boolean>()
    private val compositeDisposable = CompositeDisposable()

    fun register(email: String, userName: String, address: String, dob: String, password: String) {
        compositeDisposable.add(RetrofitInstance.API_SERVICE.register(email, userName, address, dob, password)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableSingleObserver<LoginUserResponse>() {
                override fun onSuccess(t: LoginUserResponse) {
                    if("success" == t.status) {
                        loginUserResponse.value = t
                    } else {
                        errorListener.value = true
                    }
                }

                override fun onError(e: Throwable) {
                    errorListener.value = true
                }
            })
        )
    }

    fun getRegisterUserResponse(): MutableLiveData<LoginUserResponse> {
        return loginUserResponse
    }

    fun getErrorListener(): MutableLiveData<Boolean> {
        return errorListener
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}