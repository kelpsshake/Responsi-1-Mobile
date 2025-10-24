package com.example.responsi1mobileh1d023051.model

import java.io.Serializable

data class TeamResponse(
    val id: Int,
    val name: String,
    val tla: String?,
    val area: Area?,
    val coach: Coach?,
    val squad: List<Player>?
)

data class Area(
    val name: String?
)

data class Coach(
    val id: Int?,
    val firstName: String?,
    val lastName: String?,
    val name: String?,
    val dateOfBirth: String?,
    val nationality: String?,
    val contract: Contract?
)

data class Contract(
    val start: String?,
    val until: String?
)

data class Player(
    val id: Int?,
    val name: String?,
    val position: String?,
    val dateOfBirth: String?,
    val nationality: String?
): Serializable
