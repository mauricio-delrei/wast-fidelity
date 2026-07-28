package com.wasp.fidelity.church_secretaria_service.presentation.controller;

import com.wasp.fidelity.church_secretaria_service.application.command.RegisterBaptizedMemberCommand;
import com.wasp.fidelity.church_secretaria_service.application.port.in.RegisterBaptizedMemberUseCase;
import com.wasp.fidelity.church_secretaria_service.domain.enums.MemberStatus;
import com.wasp.fidelity.church_secretaria_service.domain.model.Address;
import com.wasp.fidelity.church_secretaria_service.domain.model.Member;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.AddressResponse;
import com.wasp.fidelity.church_secretaria_service.presentation.dto.response.MemberResponse;
import com.wasp.fidelity.church_secretaria_service.presentation.mapper.AddressDtoMapper;
import com.wasp.fidelity.church_secretaria_service.presentation.mapper.MemberDtoMapper;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDate;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;



@WebMvcTest(BaptismController.class)
@AutoConfigureMockMvc(addFilters = false)
public class BaptismControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private RegisterBaptizedMemberUseCase  registerBaptizedMemberUseCase;

    @MockBean
    private MemberDtoMapper  memberDtoMapper;

    @MockBean
    private AddressDtoMapper addressDtoMapper;

    @Test
    public void should_register_baptized_member() throws Exception {

        UUID memberId = UUID.randomUUID();

        Member member = Member.builder()
                .id(memberId)
                .fullName("João da Silva")
                .email("joao@email.com")
                .mobilePhone("+447700000000")
                .dateOfBirth(LocalDate.of(1990,5,10))
                .baptismDate(LocalDate.of(2026,7,14))
                .status(MemberStatus.ACTIVE)
                .build();

        MemberResponse response =
                new MemberResponse(
                        memberId,
                        "João da Silva",
                        "joao@email.com",
                        LocalDate.of(1990,5,10),
                        "+447700000000",
                        LocalDate.of(2026,7,14),
                        MemberStatus.ACTIVE,
                        new AddressResponse(
                                "High Street",
                                "10",
                                "",
                                "London",
                                "UK",
                                "SW1A 1AA"
                        )
                );

        when(registerBaptizedMemberUseCase.execute(any(RegisterBaptizedMemberCommand.class)))
                .thenReturn(member);
        when(memberDtoMapper.toResponse(any(Member.class)))
                .thenReturn(response);
        when(addressDtoMapper.toDomain(any()))
                .thenReturn(null);

        mockMvc.perform(post("/api/members/baptism")
                .contentType(MediaType.APPLICATION_JSON)
                .content("""
                        {
                          "fullName":"João da Silva",
                          "email":"joao@email.com",
                          "mobilePhone":"+447700000000",
                          "dateOfBirth":"1990-05-10",
                          "baptismDate":"2026-07-14",
                          "address":{
                            "street":"High Street",
                            "houseNumber":"10",
                            "complement":"",
                            "city":"London",
                            "country":"UK",
                            "postcode":"SW1A 1AA"
                          }
                        }
                        """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(memberId.toString()))
                .andExpect(jsonPath("$.fullName").value("João da Silva"))
                .andExpect(jsonPath("$.email").value("joao@email.com"))
                .andExpect(jsonPath("$.status").value("ACTIVE"));
        ArgumentCaptor<RegisterBaptizedMemberCommand> captor =
                ArgumentCaptor.forClass(RegisterBaptizedMemberCommand.class);
        verify(registerBaptizedMemberUseCase)
                .execute(captor.capture());

        RegisterBaptizedMemberCommand command = captor.getValue();

        assertThat(command.getFullName())
                .isEqualTo("João da Silva");

        assertThat(command.getEmail())
                .isEqualTo("joao@email.com");

        assertThat(command.getMobilePhone())
                .isEqualTo("+447700000000");

        assertThat(command.getDateOfBirth())
                .isEqualTo(LocalDate.of(1990,5,10));

        assertThat(command.getBaptismDate())
                .isEqualTo(LocalDate.of(2026,7,14));


    }





}
