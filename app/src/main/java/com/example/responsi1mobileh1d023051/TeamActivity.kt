package com.example.responsi1mobileh1d023051

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.responsi1mobileh1d023051.databinding.ActivityTeamBinding
import com.example.responsi1mobileh1d023051.ui.PlayerAdapter
import com.example.responsi1mobileh1d023051.ui.PlayerDetailFragment
import com.example.responsi1mobileh1d023051.viewmodel.TeamViewModel

class TeamActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeamBinding
    private val viewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Setup RecyclerView
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        // Panggil data dari API
        viewModel.getTeamData()

        // Observe data dari ViewModel
        viewModel.teamData.observe(this) { team ->
            if (team != null && team.squad != null) {
                val adapter = PlayerAdapter(team.squad) { player ->
                    val dialog = PlayerDetailFragment.newInstance(player)
                    dialog.show(supportFragmentManager, "playerDetail")
                }
                binding.recyclerView.adapter = adapter
            } else {
                Toast.makeText(this, "No team data available", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
