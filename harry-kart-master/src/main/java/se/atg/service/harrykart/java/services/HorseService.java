package se.atg.service.harrykart.java.services;

import se.atg.service.harrykart.java.models.Horse;
import se.atg.service.harrykart.java.xmlhandling.XmlObjects.HarryKartType;
import se.atg.service.harrykart.java.xmlhandling.XmlObjects.LaneType;
import se.atg.service.harrykart.java.xmlhandling.XmlObjects.LoopType;
import se.atg.service.harrykart.java.xmlhandling.XmlParser;

import java.util.List;
import java.util.stream.Collectors;

public class HorseService {
    XmlParser parser;

    public HorseService() {
        parser = new XmlParser();
    }

    public List<Horse> getHorses(String inputData) {
        parser = new XmlParser();

        //Construct object containing all data of the race to be run
        HarryKartType race = parser.getHarryKart(inputData);

        return getHorses(race);
    }

    private List<Horse> getHorses(HarryKartType raceData) {
        // Create horses list from race data
        List<Horse> horses = raceData.getStartList()
                .getParticipants()
                .stream()
                .map(participantType -> new Horse(participantType.getName(), participantType.getBaseSpeed(), participantType.getLane()))
                .collect(Collectors.toList());

        // Get power-ups list
        List<LoopType> lanePowerUpsList = raceData.getPowerUps().getLoop();

        // Map power-ups to horses
        horses.forEach(horse -> {
            List<Integer> powerUpsForHorse = lanePowerUpsList.stream()
                    .flatMap(loopType -> loopType.getLane().stream())
                    .filter(laneType -> laneType.getNumber() == horse.getLane())
                    .map(LaneType::getValue)
                    .collect(Collectors.toList());

            horse.setPowerUps(powerUpsForHorse);
        });

        return horses;
    }
}
