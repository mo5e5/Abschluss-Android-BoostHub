package com.example.boosthub.data.datamodel


data class Chat(
    val userList: List<String> = emptyList(),
    val group: Boolean = false,
    val eventId: String? = null,
)