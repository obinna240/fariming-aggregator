package osztech.projects.farmingaggregator.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import osztech.projects.farmingaggregator.model.Farms;
import osztech.projects.farmingaggregator.services.FarmsService;
import java.util.UUID;

@RequestMapping("/api/v1/farms")
@RestController
public class FarmController {

    private final FarmsService farmsService;

    public FarmController(FarmsService farmsService) {
        this.farmsService = farmsService;
    }

    @GetMapping("/{farmId}")
    public ResponseEntity<Farms> getFarms(@PathVariable("farmId") UUID farmId){
        return new ResponseEntity<>(farmsService.getFarmsById(farmId), HttpStatus.OK);
    }

    /**
     * Implemen with DB
     * @param farms
     * @return
     */
    @PostMapping
    public ResponseEntity saveFarm(@RequestBody Farms farms){
        Farms farm = farmsService.saveFarm(farms);
        HttpHeaders headers = new HttpHeaders();

        headers.add("loc", "api/v1/farms/"+farms.getId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }

    @PutMapping("/{farmId}")
    public ResponseEntity updateFarm(@RequestBody Farms farms, @PathVariable UUID farmId){
        farmsService.updateFarm(farms, farmId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{farmId}")
    public ResponseEntity deleteFarm(@PathVariable UUID farmId){
        farmsService.deleteFarmById(farmId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
