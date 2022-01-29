package com.etoolkit.clean.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.etoolkit.data.repository.UserRepositoryImpl
import com.etoolkit.data.repository.storage.SharedPrefUserStorage
import com.etoolkit.domain.domain.models.SaveUserName
import com.etoolkit.domain.domain.models.UserName
import com.etoolkit.domain.domain.usecase.GetNameUseCase
import com.etoolkit.domain.domain.usecase.SaveNameUseCase

class MainViewModel(private val getNameUseCase : GetNameUseCase,
                    private val saveNameUseCase : SaveNameUseCase) : ViewModel(){

    private var liveData = MutableLiveData<String>()
    val resultLiveData : LiveData<String> = liveData

    init {
        Log.e("My","View Model created")
    }

    override fun onCleared() {
        super.onCleared()
        Log.e("My","View Model cleared")
    }

    fun save(text : String){
        val textName  = SaveUserName(name = text)
        val resultData: Boolean = saveNameUseCase.execute(textName)
        liveData.value = "Save result = $resultData"
    }

    fun load(){
        val userName: UserName = getNameUseCase.execute()
        liveData.value = "${userName.firstName} ${userName.lastName}"
    }
}