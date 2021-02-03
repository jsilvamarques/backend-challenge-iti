package br.com.jeffersonmarques.backendchallengeiti.error.exception

import java.io.Serializable

sealed class PasswordValidationException(
        val errorCode: String = "ERROR-08"
): RuntimeException(), Serializable {
        object RequiresAtLeastOneDigit : PasswordValidationException("ERROR-01")
        object RequiresAtLeastOneLowercaseLetter : PasswordValidationException("ERROR-02")
        object RequiresAtLeastOneUppercaseLetter : PasswordValidationException("ERROR-03")
        object RequiresAtLeastOneSpecialCharacter : PasswordValidationException("ERROR-04")
        object ChecksBlanksSpaces : PasswordValidationException("ERROR-05")
        object CheckSizePassword : PasswordValidationException("ERROR-06")
        object CheckRepeatChars : PasswordValidationException("ERROR-07")
}



