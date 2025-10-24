package com.example.responsi1mobileh1d023051.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.responsi1mobileh1d023051.R
import com.example.responsi1mobileh1d023051.model.Player

class PlayerAdapter(
    private val players: List<Player>,
    private val onClick: (Player) -> Unit
) : RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    inner class PlayerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvPlayerName)
        val nationality: TextView = itemView.findViewById(R.id.tvNationality)
        val cardView: CardView = itemView.findViewById(R.id.cardPlayer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.name.text = player.name
        holder.nationality.text = player.nationality

        val position = player.position?.lowercase() ?: ""
        val colorRes = when {
            // Goalkeeper
            position.contains("goalkeeper") -> android.graphics.Color.YELLOW

            // Defender
            position.contains("defence") ||
                    position.contains("back") -> android.graphics.Color.BLUE

            // Midfielder
            position.contains("midfield") -> android.graphics.Color.GREEN

            // Forward / Winger / Offence
            position.contains("forward") ||
                    position.contains("winger") ||
                    position.contains("offence") -> android.graphics.Color.RED

            // Default (kalau posisi tidak dikenal)
            else -> android.graphics.Color.LTGRAY
        }

        holder.cardView.setCardBackgroundColor(colorRes)

        holder.itemView.setOnClickListener { onClick(player) }
    }

    override fun getItemCount(): Int = players.size
}
