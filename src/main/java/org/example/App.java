package org.example;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.Collections;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        CSVParsing csvParsing = new CSVParsing();

//        csvParsing.readFile();

        CSVContentParsing csvContentParsing = new CSVContentParsing();

        CSVReading csvContent = new CSVReading(Paths.get("src/main/resources/athletesResults.csv"));
        List<String> results = csvContent.getBiathlonResults();

        csvContentParsing.parsingTheFile(results, true);
        List<Athlete> myList = csvContentParsing.biathlonAthletes;

        for(Athlete athlete : myList) {
            TimeResult timpInitial = athlete.getSkiTimeResult();
            Duration timpDupaCalcul = athlete.updateTimeWithPenalties();
            System.out.println("\ntimp initial = " + timpInitial);
            System.out.println("timp final = " + timpDupaCalcul);

        }


//        System.out.println(csvContentParsing.biathlonAthletes);
//        public void printOrdered() {
//            System.out.println(List.sort(csvContentParsing.biathlonAthletes, new AthletesTimeComparator()));
//        }

    }
}
