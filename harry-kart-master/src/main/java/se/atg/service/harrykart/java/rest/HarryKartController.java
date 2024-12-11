package se.atg.service.harrykart.java.rest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.atg.service.harrykart.java.models.Horse;
import se.atg.service.harrykart.java.services.HorseService;
import se.atg.service.harrykart.java.services.RaceRunnerService;

import java.util.List;

@RestController
@RequestMapping("/java/api")
public class HarryKartController {
    HorseService horseService;
    RaceRunnerService raceRunnerService;
    @PostMapping(path = "/play", consumes = MediaType.APPLICATION_XML_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public String playHarryKart(@RequestBody String inputData){
        horseService = new HorseService();
        raceRunnerService = new RaceRunnerService();

        //Get a list of horses with base data
        List<Horse> participatingHorses  = horseService.getHorses(inputData);
        //Simulate and return the result of the test
        return raceRunnerService.runRace(participatingHorses);

    }

}
