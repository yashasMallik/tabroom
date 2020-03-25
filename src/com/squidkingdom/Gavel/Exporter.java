package com.squidkingdom.Gavel;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Exporter {

    public static void exportSchedule(ArrayList<RoundData> rounds, String fileName) throws IOException {
        FileWriter csvWriter = new FileWriter("tmp/" + fileName + ".csv");
        csvWriter.append("Aff Team");
        csvWriter.append(",");
        csvWriter.append("Neg Team");
        csvWriter.append(",");
        csvWriter.append("Judge");
        csvWriter.append(",");
        csvWriter.append("Room");
        csvWriter.append("\n");

        for (RoundData round : rounds) {
            csvWriter.append(String.join(",", round.affTeam.code, round.negTeam.code, round.judge.code, Integer.toString(round.room)));
            csvWriter.append("\n");
        }

        csvWriter.flush();
        csvWriter.close();
    }

    public static void exportRounds(String fileName) throws IOException {
        FileWriter csvWriter = new FileWriter("tmp/" + fileName + ".csv");
        csvWriter.append("Round");
        csvWriter.append(",");
        csvWriter.append("Winner");
        csvWriter.append(",");
        csvWriter.append("Aff Team");
        csvWriter.append(",");
        csvWriter.append("Aff Speaks");
        csvWriter.append(",");
        csvWriter.append("Neg Team");
        csvWriter.append(",");
        csvWriter.append("Neg Speaks");
        csvWriter.append(",");
        csvWriter.append("Judge");
        csvWriter.append(",");
        csvWriter.append("Room");
        csvWriter.append("\n");


        for (Room room : RoomManager.roomArray) {
            int i = 1;
            for (RoundData round : room.data) {
                if (round.isFinished) {
                    String winner = round.affWon ? "Aff" : "Neg";

                    csvWriter.append(String.join(",", Integer.toString(i), winner, round.affTeam.code, Integer.toString(round.affSpeaks), round.negTeam.code, Integer.toString(round.negSpeaks), round.judge.code, Integer.toString(room.id)));
                    csvWriter.append("\n");
                }
                i++;
            }
        }

        csvWriter.flush();
        csvWriter.close();
    }
}
