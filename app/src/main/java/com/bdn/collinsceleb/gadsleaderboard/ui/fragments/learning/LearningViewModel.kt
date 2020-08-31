package com.bdn.collinsceleb.gadsleaderboard.ui.fragments.learning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bdn.collinsceleb.gadsleaderboard.data.network.LeaderboardApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class LearningViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getLearningLeaderboard()
    }

    private fun getLearningLeaderboard() {
        coroutineScope.launch {
            val getLearningLearnersDeferred = LeaderboardApi.retroService.getLearningLeadersAsync()
            try {
                val learningLeadersResult = getLearningLearnersDeferred.await()
                _response.value = "Success: ${learningLeadersResult.size} Learning Leaders was retrieved"
            } catch (exception: Exception) {
                _response.value = "Failure: ${exception.message}"
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }
}