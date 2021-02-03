package br.com.jeffersonmarques.backendchallengeiti.util

import br.com.jeffersonmarques.backendchallengeiti.error.exception.PasswordValidationException
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class ValidationTest {

    @Test
    fun `password validation with at least one digit` (){
        val password = "AbTp9!fok"
        val status = password.requiresAtLeastOneDigit()
        assertEquals(true, status)
    }

    @Test
    fun `exception test for not containing a digit given the set` (){
        val password = "AbTpj!fok"

        val exception = assertThrows(PasswordValidationException::class.java) {
            val status = password.requiresAtLeastOneDigit()
        }

        val expectedError = "ERROR-01"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `at least one lowercase letter` (){
        val password = "AbTp9!fok"
        val status = password.requiresAtLeastOneLowercaseLetter()
        assertEquals(true, status)
    }

    @Test
    fun `test for exception because it does not contain a small character given the set` (){
        val password = "ABTP9!FOK"

        val exception = assertThrows(PasswordValidationException::class.java) {
            password.requiresAtLeastOneLowercaseLetter()
        }

        val expectedError = "ERROR-02"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `at least one uppercase letter` (){
        val password = "AbTp9!fok"
        val status = password.requiresAtLeastOneUppercaseLetter()
        assertEquals(true, status)    }

    @Test
    fun `test for exception because it does not contain a uppercase given the set` (){
        val password = "abtp9!fok"

        val exception = assertThrows(PasswordValidationException::class.java) {
            password.requiresAtLeastOneUppercaseLetter()
        }

        val expectedError = "ERROR-03"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `at least one special character` (){
        val password = "AbTp9!fok"
        val status = password.requiresAtLeastOneSpecialCharacter()
        assertEquals(true, status)    }

    @Test
    fun `test for exception because it does not contain a special character given the set` (){
        val password = "abtp9dfok"

        val exception = assertThrows(PasswordValidationException::class.java) {
            password.requiresAtLeastOneSpecialCharacter()
        }

        val expectedError = "ERROR-04"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `checks blanks spaces` (){
        val password = "AbTp9!fok"
        val status = password.checksBlanksSpaces()
        assertEquals(status, true)
    }

    @Test
    fun `test for exception checks blanks spaces` (){
        val password = "abtp9 dfok"

        val exception = assertThrows(PasswordValidationException::class.java) {
            password.checksBlanksSpaces()
        }

        val expectedError = "ERROR-05"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `check size password` (){
        val password = "AbTp9!fok"
        val status = password.checkSizePassword()
        assertEquals(true, status)    }

    @Test
    fun `test for exception check size password` (){
        val password = "abtp9"

        val exception = assertThrows(PasswordValidationException::class.java) {
            password.checkSizePassword()
        }

        val expectedError = "ERROR-06"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `check repeat chars` (){
        val password = "AbTp9!fok"
        val status = password.checkRepeatChars()
        assertEquals(true, status)
    }

    @Test
    fun `test for exception check repeat chars` (){
        val password = "AbTp9!fokA"

        val exception = assertThrows(PasswordValidationException::class.java) {
            password.checkRepeatChars()
        }

        val expectedError = "ERROR-07"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }
}