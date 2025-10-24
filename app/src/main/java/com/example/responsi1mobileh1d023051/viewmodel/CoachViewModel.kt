package com.example.responsi1mobileh1d023051.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.responsi1mobileh1d023051.model.TeamResponse
import com.example.responsi1mobileh1d023051.network.RetrofitInstance
import kotlinx.coroutines.launch

class CoachViewModel : ViewModel() {
    val teamData = MutableLiveData<TeamResponse?>()

    fun getTeam(id: Int) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getTeamDetail(id)
                if (response.isSuccessful) {
                    teamData.postValue(response.body())
                } else {
                    teamData.postValue(null)
                }
            } catch (e: Exception) {
                teamData.postValue(null)
            }
        }
    }
}
