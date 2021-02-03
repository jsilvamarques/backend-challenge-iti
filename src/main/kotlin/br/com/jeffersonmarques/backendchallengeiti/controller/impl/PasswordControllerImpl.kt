package br.com.jeffersonmarques.backendchallengeiti.controller.impl

import br.com.jeffersonmarques.backendchallengeiti.controller.PasswordController
import br.com.jeffersonmarques.backendchallengeiti.dto.PasswordDto
import br.com.jeffersonmarques.backendchallengeiti.service.impl.PasswordServiceImpl
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/password")
class PasswordControllerImpl(val passwordService: PasswordServiceImpl): PasswordController {

    @PostMapping()
    override fun passwordValidation(
        @RequestBody passwordDto: PasswordDto
    ) : ResponseEntity<Boolean>
        = ResponseEntity(passwordService.passwordValidation(passwordDto.password), HttpStatus.OK)

}