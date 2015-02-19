package progargs;

import libs.P;

import java.util.Scanner;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/19/15.
 */
public class StartUp {

    public static float weightInKilos = 0, weightInLbs = 0, heightInMeters = 0, heightInInches = 0;

    public static void weightAndHeight(boolean selectedUnits){

        Scanner user = new Scanner(System.in);

        if(!selectedUnits){
            P.print("What is your weight in lbs?");
            StartUp.weightInLbs = user.nextFloat();

            P.print("What is your height in inches?");
            StartUp.heightInInches = user.nextFloat();
        }else{
            P.print("What is your weight in kilos");
            StartUp.weightInKilos = user.nextFloat();

            P.print("What is your height in meters?");
            StartUp.heightInMeters = user.nextFloat();
        }

    }
}
