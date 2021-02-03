package br.com.jeffersonmarques.backendchallengeiti.util

import br.com.jeffersonmarques.backendchallengeiti.error.exception.PasswordValidationException

    fun <T : CharSequence> T.requiresAtLeastOneDigit(): Boolean {
        return (ONE_DIGIT_REGEX.containsMatchIn(this))
            .orThrows { throw PasswordValidationException.RequiresAtLeastOneDigit }
    }

    fun <T : CharSequence> T.requiresAtLeastOneLowercaseLetter(): Boolean {
        return AT_LEAST_ONE_LOWERCASE_LETTER.containsMatchIn(this)
            .orThrows { throw PasswordValidationException.RequiresAtLeastOneLowercaseLetter }
    }

    fun <T : CharSequence> T.requiresAtLeastOneUppercaseLetter(): Boolean {
        return AT_LEAST_ONE_UPPERCASE_LETTER.containsMatchIn(this)
            .orThrows { throw PasswordValidationException.RequiresAtLeastOneUppercaseLetter }
    }

    fun <T : CharSequence> T.requiresAtLeastOneSpecialCharacter(): Boolean {
         return AT_LEAST_ONE_SPECIAL_CHARACTER.containsMatchIn(this)
             .orThrows { throw PasswordValidationException.RequiresAtLeastOneSpecialCharacter }
    }

    fun <T : CharSequence> T.checksBlanksSpaces(): Boolean {
        return this.none(Char::isWhitespace)
            .orThrows { throw PasswordValidationException.ChecksBlanksSpaces }
    }

    fun <T : CharSequence> T.checkSizePassword(): Boolean {
        return (this.length >= CONFIG_SIZE_PASSWORD)
            .orThrows { throw PasswordValidationException.CheckSizePassword }
    }

    fun <T: CharSequence> T.checkRepeatChars(): Boolean {
        return (this.chars().distinct().count().toInt() == this.length)
            .orThrows { throw PasswordValidationException.CheckRepeatChars }
    }

    private fun Boolean.orThrows(block: () -> Exception ) = if (this) this else throw block()

    private fun CharSequence.notContains(other: CharSequence) = !this.contains(other)



private val ONE_DIGIT_REGEX = """(?=.*?[0-9])""".toRegex()
private val AT_LEAST_ONE_LOWERCASE_LETTER = """(?=.*?[a-z])""".toRegex()
private val AT_LEAST_ONE_UPPERCASE_LETTER = """(?=.*?[A-Z])""".toRegex()
private val AT_LEAST_ONE_SPECIAL_CHARACTER = """(?=.*?[#?!@${'$'}%^&*-])""".toRegex()
private const val CONFIG_SIZE_PASSWORD = 9