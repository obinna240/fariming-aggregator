package osztech.projects.farmingaggregator.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import osztech.projects.farmingaggregator.domain.Farm;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class FarmsTest extends BaseFarmTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void serializeObject() throws Exception{
        objectMapper.setPropertyNamingStrategy(PropertyNamingStrategy.KEBAB_CASE);
        String farmObj = objectMapper.writeValueAsString(farm);
        System.out.println(farmObj);
    }

    @Test
    void deSerialize() throws Exception {
        String farmObj = objectMapper.writeValueAsString(farm);
        Farm farm = objectMapper.readValue(farmObj, Farm.class);
        System.out.println(farm);
    }

}