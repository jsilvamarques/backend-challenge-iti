package br.com.jeffersonmarques.backendchallengeiti.service

import br.com.jeffersonmarques.backendchallengeiti.error.exception.PasswordValidationException
import br.com.jeffersonmarques.backendchallengeiti.service.impl.PasswordServiceImpl
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PasswordServiceTest {

    @InjectMocks
    private lateinit var passwordService: PasswordServiceImpl

    @Test
    fun `validatePassword` (){
        val password = "AbTp9!fok"
        val status = passwordService.passwordValidation(password)

        assertEquals(status, true)
    }

    @Test
    fun `password validation with at least one digit` (){
        val password = "AbTpl!fok"

        val exception = assertThrows(PasswordValidationException::class.java) {
            passwordService.passwordValidation(password)
        }

        val expectedError = "ERROR-01"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `password validation with at least one lowercase letter` (){
        val password = "ABTPL!9FOK"

        val exception = assertThrows(PasswordValidationException::class.java) {
            passwordService.passwordValidation(password)
        }

        val expectedError = "ERROR-02"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `password validation with at least one uppercase letter` (){
        val password = "abtpl!9fok"

        val exception = assertThrows(PasswordValidationException::class.java) {
            passwordService.passwordValidation(password)
        }

        val expectedError = "ERROR-03"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `password validation with at least one special character` (){
        val password = "AbTp9jfok"

        val exception = assertThrows(PasswordValidationException::class.java) {
            passwordService.passwordValidation(password)
        }

        val expectedError = "ERROR-04"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `password validation with space` (){
        val password = "AbTp9!f ok"

        val exception = assertThrows(PasswordValidationException::class.java) {
            passwordService.passwordValidation(password)
        }

        val expectedError = "ERROR-05"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `password validation with less than 9 characters` (){
        val password = "AbTp9!f"

        val exception = assertThrows(PasswordValidationException::class.java) {
            passwordService.passwordValidation(password)
        }

        val expectedError = "ERROR-06"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }

    @Test
    fun `password validation check repeat chars` (){
        val password = "AbTp9!foo"

        val exception = assertThrows(PasswordValidationException::class.java) {
            passwordService.passwordValidation(password)
        }

        val expectedError = "ERROR-07"
        val actualError = exception.errorCode

        assertTrue(actualError.contains(expectedError));
    }
}