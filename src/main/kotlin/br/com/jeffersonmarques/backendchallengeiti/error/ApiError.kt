package br.com.jeffersonmarques.backendchallengeiti.error

import com.fasterxml.jackson.annotation.JsonProperty

data class ApiError(
    @JsonProperty("error_code")
    val errorCode: String,
    @JsonProperty("error_message")
    val errorMessage: String
)