package com.example.boosthub.testing

import com.example.boosthub.data.datamodel.Chat
import com.example.boosthub.data.datamodel.Event
import com.example.boosthub.data.datamodel.Message
import com.google.firebase.Timestamp


val listOfEvent = listOf<Event>(
    Event(
        "", "Test treffen", "hamburg", "02.02.24", "alle",
        "nichts", "keine"
    )
)

// Erstellen eines aktuellen Zeitstempels
val now = Timestamp.now()

// Konvertieren eines Timestamps in ein Date-Objekt
val date = now.toDate()

// Konvertieren eines Date-Objekts in einen Timestamp
val timestamp = Timestamp(date)

val listOfChat = listOf<Chat>(
    Chat("yG3wvqTBWKcCel9qOCcnZ0LojZf1", "llnD950v11Sc2wIDLFpJXyob5kQ2")
)

val listOfMessage = Message("EyBtoNLbcXUQ9PtxTtg8", Timestamp.now(),"hey how are you?")