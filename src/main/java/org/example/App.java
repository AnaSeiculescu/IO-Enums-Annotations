package org.example;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        StandingCalculation standingCalculation = new StandingCalculation();
        standingCalculation.calculationOfTheStandings();

        System.out.println(standingCalculation);

//        for (Athlete standing : standingCalculation.getFinalStandings()) {
//            System.out.println(standing);
//        }

    }
}
