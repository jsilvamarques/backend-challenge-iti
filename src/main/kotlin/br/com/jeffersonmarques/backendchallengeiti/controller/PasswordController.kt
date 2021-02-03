package br.com.jeffersonmarques.backendchallengeiti.controller

import br.com.jeffersonmarques.backendchallengeiti.dto.PasswordDto
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody


@ApiOperation(value = "password validation", notes = "Api responsible for validating if the password is correct")
@ApiResponses(value = [
        ApiResponse(code = 200, message = "password successfully validated"),
        ApiResponse(code = 400, message = "error when validating the password check the error and try again")
    ])
interface PasswordController {
    fun passwordValidation(@RequestBody passwordDto: PasswordDto) : ResponseEntity<Boolean>
}