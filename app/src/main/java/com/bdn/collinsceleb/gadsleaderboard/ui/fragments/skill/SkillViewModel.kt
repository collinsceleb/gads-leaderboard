package com.bdn.collinsceleb.gadsleaderboard.ui.fragments.skill

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bdn.collinsceleb.gadsleaderboard.data.network.LeaderboardApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class SkillViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()
    val response: LiveData<String>
        get() = _response

    private var viewModelJob = Job()

    private val coroutineScope = CoroutineScope(viewModelJob + Dispatchers.Main)

    init {
        getSkillLeaderboard()
    }

    private fun getSkillLeaderboard() {
        coroutineScope.launch {
            val getSkillLearnersDeferred = LeaderboardApi.retroService.getSkillLeadersAsync()
            try {
                val skillLeadersResult = getSkillLearnersDeferred.await()
                _response.value = "Success: ${skillLeadersResult.size} Skill IQ Leaders was retrieved"
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