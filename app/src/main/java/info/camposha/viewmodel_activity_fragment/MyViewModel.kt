package info.camposha.viewmodel_activity_fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private var stringMutableLiveData: MutableLiveData<String>? = null
    fun init() {
        stringMutableLiveData = MutableLiveData()
    }

    fun sendData(msg: String) {
        stringMutableLiveData!!.value = msg
    }

    val message: LiveData<String>?
        get() = stringMutableLiveData
}