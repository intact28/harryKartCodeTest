package se.atg.service.harrykart.java.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import se.atg.service.harrykart.java.models.Horse;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RaceRunnerService {
    final int loopDistance = 1000;

    public String runRace(List<Horse> horses) {
        calculateTotalTime(horses);
        return tabulateTopThree(horses);
    }

    private void calculateTotalTime(List<Horse> horses) {
        final int loopDistance = 1000; // Each loop is 1000 meters

        horses.forEach(horse -> {
            // Initial base speed for computing
            horse.setCurrentSpeed(horse.getBaseSpeed());
            int totalTime = horse.getPowerUps()
                    .stream()
                    .reduce(0, (partialTotalTime, powerUp) -> {
                        horse.setCurrentSpeed(horse.getCurrentSpeed() + powerUp);

                        if (horse.getCurrentSpeed() <= 0) {
                            horse.setDisqualified(true);
                            return partialTotalTime; // Stop calculation when disqualified
                        }

                        return partialTotalTime + (loopDistance / horse.getCurrentSpeed());
                    }, Integer::sum);

            horse.setTotalTime(totalTime);
        });
    }

    private String tabulateTopThree(List<Horse> horses) {
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode rankingJson = mapper.createObjectNode();
        ArrayNode rankingArray = mapper.createArrayNode();

        // Filter out disqualified horses and sort by totalTime
        List<Horse> qualifiedHorses = horses.stream()
                .filter(horse -> !horse.isDisqualified())
                .sorted(Comparator.comparingInt(Horse::getTotalTime))
                .toList();

        // Compute ranking, allowing ties
        List<ObjectNode> top3 = new ArrayList<>();
        int position = 1;
        for (int i = 0; i < qualifiedHorses.size() && top3.size() < 3; i++) {
            Horse horse = qualifiedHorses.get(i);

            ObjectNode horseNode = mapper.createObjectNode();
            horseNode.put("position", position);
            horseNode.put("horse", horse.getName());
            top3.add(horseNode);

            // Check if the next horse has a different totalTime to increment the rank
            if (i == qualifiedHorses.size() - 1 || horse.getTotalTime() != qualifiedHorses.get(i + 1).getTotalTime()) {
                position = top3.size() + 1;
            }
        }

        rankingArray.addAll(top3);
        rankingJson.set("ranking", rankingArray);

        // Convert ObjectNode to JSON String
        String jsonString = "";
        try {
            jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(rankingJson);
        } catch (JsonProcessingException e) {
           throw new RuntimeException("Failed to parse results to JSON", e);
        }

        return jsonString;
    }
}


