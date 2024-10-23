package org.plexus.starship.infrastructure.rest.adapter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class StarshipControllerITTest {

    private static final String API_URI = "/api/starships";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void whenGetStarshipByIdThenReturnStarship() throws Exception {
        mockMvc.perform(get(API_URI + "/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"name\":\"X-Wing\",\"type\":\"attack\"}"));
    }

    @Test
    void whenGetStarshipByIdThenReturnNotFound() throws Exception {
        mockMvc.perform(get(API_URI + "/999")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void whenGetStarshipsByNameThenReturnStarships() throws Exception {
        mockMvc.perform(get(API_URI + "/search?name=X-Wing")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("[{\"id\":1,\"name\":\"X-Wing\",\"type\":\"attack\"}]"));
    }


    @Test
    void whenCreateStarshipThenReturnCreatedStarship() throws Exception {
        String starshipRequestJson = "{\"name\":\"X-Wing\",\"type\":\"attack\"}";

        mockMvc.perform(post(API_URI)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(starshipRequestJson))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":13,\"name\":\"X-Wing\",\"type\":\"attack\"}"));
    }

    @Test
    void whenGetAllStarshipsThenReturnStarships() throws Exception {
        mockMvc.perform(get(API_URI + "?size=5&page=1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.content.length()").value(5))
                .andExpect(jsonPath("$.pageable.pageNumber").value(1))
                .andExpect(jsonPath("$.pageable.pageSize").value(5));
    }

    @Test
    void whenUpdateStarshipByIdThenReturnUpdatedStarship() throws Exception {
        String starshipRequestJson = "{\"name\":\"X-Wing\",\"type\":\"attack\"}";

        mockMvc.perform(put(API_URI + "/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(starshipRequestJson))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"id\":1,\"name\":\"X-Wing\",\"type\":\"attack\"}"));
    }

    @Test
    void whenDeleteStarshipByIdThenReturnNoContentAndGetNotFound() throws Exception {
        mockMvc.perform(delete(API_URI + "/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        mockMvc.perform(get(API_URI + "/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }
}