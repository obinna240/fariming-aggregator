package osztech.projects.farmingaggregator.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import osztech.projects.farmingaggregator.model.Farms;
import osztech.projects.farmingaggregator.services.FarmsService;
import java.util.UUID;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(FarmController.class)
class FarmControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper objectMapper;
    @MockBean
    FarmsService farmService;

    static final String FARM_ID = UUID.randomUUID().toString();
    Farms farms = Farms.builder().id(UUID.randomUUID()).build();

    @Test
    void getFarms() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/farms/"+FARM_ID)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void saveFarm() throws Exception{

        String farmsAsJsonString = objectMapper.writeValueAsString(farms);
        System.out.println("$$$$$$$$$$$$$%"+farms.getId());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/farms/")
            .contentType(MediaType.APPLICATION_JSON)
                .content(farmsAsJsonString))
                .andExpect(status().isCreated());
    }

    @Test
    void updateFarm() throws Exception {
        String farmsAsJsonString = objectMapper.writeValueAsString(farms);
        mockMvc.perform(MockMvcRequestBuilders.put("/api/v1/farms/"+FARM_ID)
                .contentType(MediaType.APPLICATION_JSON)
                .content(farmsAsJsonString))
                .andExpect(status().isNoContent());
    }

    @Test
    void deleteFarm() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/v1/farms/"+FARM_ID)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}