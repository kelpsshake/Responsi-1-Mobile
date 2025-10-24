package com.example.responsi1mobileh1d023051

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.responsi1mobileh1d023051.databinding.ActivityHeadCoachBinding
import com.example.responsi1mobileh1d023051.viewmodel.CoachViewModel

class HeadCoachActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHeadCoachBinding
    private val viewModel: CoachViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeadCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getTeam(112)

        viewModel.teamData.observe(this) { team ->
            if (team != null) {
                val coach = team.coach
                binding.tvCoachName.text = coach?.name ?: "-"
                binding.tvNationality.text = "Nationality: ${coach?.nationality ?: "-"}"
                binding.tvDob.text = "Date of Birth: ${coach?.dateOfBirth ?: "-"}"
                binding.tvContract.text = "Contract: ${coach?.contract?.start ?: "-"} to ${coach?.contract?.until ?: "-"}"
            } else {
                binding.tvCoachName.text = "Data not found"
            }
        }
    }
}
