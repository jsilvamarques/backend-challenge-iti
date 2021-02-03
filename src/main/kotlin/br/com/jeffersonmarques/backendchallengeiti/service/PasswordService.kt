package br.com.jeffersonmarques.backendchallengeiti.service

interface PasswordService {
    fun passwordValidation(password: String): Boolean
}