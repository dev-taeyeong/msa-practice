package org.example.banking.adapter.in.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.banking.application.port.in.RegisterBankAccountCommand;
import org.example.banking.application.port.in.RegisterBankAccountUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(RegisterBankAccountController.class)
class RegisterBankAccountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private RegisterBankAccountUseCase registerBankAccountUseCase;

    @Test
    void testRegisterBankAccount() throws Exception {
        RegisterBankAccountRequest request = new RegisterBankAccountRequest("1", "국민은행", "123124", true);
        RegisterBankAccountCommand command = new RegisterBankAccountCommand("1", "국민은행", "123124", true);
        given(registerBankAccountUseCase.registerMembership(command))
                .willReturn(null);
        mvc.perform(post("/banking/account/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsBytes(request)))
                .andExpect(status().isOk());
    }
}