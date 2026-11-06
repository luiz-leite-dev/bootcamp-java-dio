package task.manager.infrastructure.http;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.payload.PayloadDocumentation;
import org.springframework.restdocs.request.RequestDocumentation;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

@ExtendWith({RestDocumentationExtension.class, SpringExtension.class})
@SpringBootTest 
public class TaskControllerTest {

    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setUp(WebApplicationContext webApplicationContext, RestDocumentationContextProvider restDocumentationContextProvider) {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
            .apply(MockMvcRestDocumentation.documentationConfiguration(restDocumentationContextProvider))
            .build();

    }

    @Test
    void should_save_and_retrive_task_by_id() throws Exception {
        final String title = "Aprender Spring RestDocs";
        Map<String, String> taskRequest = new HashMap<>();
        taskRequest.put("title", title);
        taskRequest.put("description", "Ler o guia oficial do spring");

        String responseJson = this.mockMvc.perform(MockMvcRequestBuilders
                .post("/tasks")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(taskRequest)))
            .andExpect(MockMvcResultMatchers.status().isCreated())
            .andDo(MockMvcRestDocumentation.document("create-task", 
                PayloadDocumentation.requestFields(
                    PayloadDocumentation.fieldWithPath("title").description("Título da tarefa"),
                    PayloadDocumentation.fieldWithPath("description").description("Descrição detalhada da tarefa")
                ), 
                PayloadDocumentation.responseFields(
                    PayloadDocumentation.fieldWithPath("id").description("Identificador único da tarefa"),
                    PayloadDocumentation.fieldWithPath("title").description("Título da tarefa"),
                    PayloadDocumentation.fieldWithPath("description").description("Descrição detalhada da tarefa"),
                    PayloadDocumentation.fieldWithPath("status").description("Status da tarefa")
                )))
                .andReturn()
                .getResponse()
                .getContentAsString();
        String generatedId = JsonPath.read(responseJson, "$.id");
        
        this.mockMvc
            .perform(MockMvcRequestBuilders
                .get("/tasks/{id}", generatedId)
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(generatedId))
            .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(title))
            .andDo(MockMvcRestDocumentation.document("get-task-by-id",
                RequestDocumentation.pathParameters(
                    RequestDocumentation.parameterWithName("id").description("Identificador único da tarefa")
                ),
                PayloadDocumentation.responseFields(
                    PayloadDocumentation.fieldWithPath("id").description("Identificador único da tarefa"),
                    PayloadDocumentation.fieldWithPath("title").description("Título da tarefa"),
                    PayloadDocumentation.fieldWithPath("description").description("Descrição detalhada da tarefa"),
                    PayloadDocumentation.fieldWithPath("status").description("Status da tarefa")
                )
            ));
    }
}
