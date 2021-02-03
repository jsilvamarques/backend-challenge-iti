package br.com.jeffersonmarques.backendchallengeiti.service.impl

import br.com.jeffersonmarques.backendchallengeiti.service.PasswordService
import br.com.jeffersonmarques.backendchallengeiti.util.*
import org.springframework.stereotype.Service

@Service
class PasswordServiceImpl: PasswordService {
    override fun passwordValidation(password: String): Boolean {
        return password.checkSizePassword() &&
                password.checkRepeatChars() &&
                password.requiresAtLeastOneDigit() &&
                password.requiresAtLeastOneLowercaseLetter() &&
                password.requiresAtLeastOneUppercaseLetter() &&
                password.requiresAtLeastOneSpecialCharacter() &&
                password.checksBlanksSpaces()
    }
}