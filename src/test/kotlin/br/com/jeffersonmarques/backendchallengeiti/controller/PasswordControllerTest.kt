package br.com.jeffersonmarques.backendchallengeiti.controller

import br.com.jeffersonmarques.backendchallengeiti.dto.PasswordDto
import br.com.jeffersonmarques.backendchallengeiti.service.PasswordService
import br.com.jeffersonmarques.backendchallengeiti.service.impl.PasswordServiceImpl
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class PasswordControllerTest() {

    @Autowired
    private lateinit var passwordService: PasswordServiceImpl

    @Autowired
    private lateinit var mockMvc: MockMvc


    @Test
    fun passwordValidation(){
        val password = "AbTp9!fok"
        val passwordDto = PasswordDto(password)

        val body = jacksonObjectMapper().writeValueAsString(passwordDto)

        this.mockMvc.perform(post("/v1/password")
            .contentType(MediaType.APPLICATION_JSON)
            .content(body))
            .andExpect(status().isOk)
    }
}