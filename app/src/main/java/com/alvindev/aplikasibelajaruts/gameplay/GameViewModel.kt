package com.alvindev.aplikasibelajaruts.gameplay

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alvindev.aplikasibelajaruts.network.Hasil
import com.alvindev.aplikasibelajaruts.network.KimiaApi
import kotlinx.coroutines.launch

enum class KimiaApiStatus { LOADING, ERROR, DONE }

/**
 * The [ViewModel] that is attached to the [GameFragment]
 */
class GameViewModel : ViewModel() {
    private val _status = MutableLiveData<KimiaApiStatus>()
    val status: LiveData<KimiaApiStatus> = _status

    // Internally, we use a MutableLiveData, because we will be updating the List of MarsPhoto
    // with new values
    private val _hasil = MutableLiveData<Hasil>()

    // The external LiveData interface to property is immutable, so this class can modify
    val hasil: LiveData<Hasil> = _hasil

    /**
     * Call getHasil() on init so we can display status immediately
     */
    init {
        getHasil()
    }

    fun retry() {
        getHasil()
    }

    /**
     * Get Hasil information from the Kimia API Retrofit service and updates the
     * [Hasil]
     */
    private fun getHasil() {
        // using coroutines that can't applied in java
        viewModelScope.launch {
            _status.value = KimiaApiStatus.LOADING
            try {
                val result = KimiaApi.retrofitService.getUnsur()
                _hasil.value = result.hasil!!
                _status.value = KimiaApiStatus.DONE
                Log.v("OverviewViewModel", "$result")
            } catch (e: Exception) {
                _hasil.value = Hasil()
                _status.value = KimiaApiStatus.ERROR
            }
        }
    }
}