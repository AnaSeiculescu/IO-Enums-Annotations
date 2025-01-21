package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        StandingCalculation standingCalculation = new StandingCalculation();
        standingCalculation.getStandingCalculation(standingCalculation.getBiathlonAthletes());

        System.out.println(standingCalculation);

//        for (Athlete standing : standingCalculation.getFinalStandings()) {
//            System.out.println(standing);
//        }

//        CSVContentParsing contentParser = new CSVContentParsing();
//        List<String> input = new ArrayList<>();
//        List<Athlete> biathlonAthletes = new ArrayList<>();
//
////        input = List.of("11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo");
//        List<Athlete> actualResult = contentParser.parsingFileContent(input, false);
//
//        System.out.println(actualResult);

    }
}
