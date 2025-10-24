package com.example.responsi1mobileh1d023051.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.responsi1mobileh1d023051.R
import com.example.responsi1mobileh1d023051.model.Player
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PlayerDetailFragment : BottomSheetDialogFragment() {

    companion object {
        private const val ARG_PLAYER = "player"

        fun newInstance(player: Player): PlayerDetailFragment {
            val fragment = PlayerDetailFragment()
            val bundle = Bundle().apply {
                putSerializable(ARG_PLAYER, player)
            }
            fragment.arguments = bundle
            return fragment
        }
    }

    private var player: Player? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        player = arguments?.getSerializable(ARG_PLAYER) as? Player
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_player_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvName = view.findViewById<TextView>(R.id.tvName)
        val tvBirth = view.findViewById<TextView>(R.id.tvBirth)
        val tvNationality = view.findViewById<TextView>(R.id.tvNationality)
        val tvPosition = view.findViewById<TextView>(R.id.tvPosition)

        player?.let {
            tvName.text = it.name ?: "-"
            tvBirth.text = it.dateOfBirth ?: "-"
            tvNationality.text = it.nationality ?: "-"
            tvPosition.text = it.position ?: "-"

        }
    }
}
