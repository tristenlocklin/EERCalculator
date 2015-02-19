package progargs;

import libs.P;

import java.util.Scanner;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/19/15.
 */
public class StartUp {

    public static float weightInKilos = 0, weightInLbs = 0, heightInMeters = 0, heightInInches = 0;
    public static boolean boolGender, selectedUnits, boolAge;
    public static int age, toDiet, activeLevel;

    public static Scanner user = new Scanner(System.in);


    public static void weightAndHeight(boolean selectedUnits){

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

    public static void whoAreYou(){

        P.print("Are you (M)Male or (F)Female?");
        String gender = user.nextLine();
        StartUp.boolGender = gender.toLowerCase().equals("m");

        P.print("Would you like to use (1)SI Units or (2)Imperial Units?");
        int units = user.nextInt();
        StartUp.selectedUnits = (units == 1);
    }

    public static void moarInformation(){

        P.print("How old are you currently?");
        StartUp.age = user.nextInt();

        P.print("Are you currently trying to (1)Gain some weight, (2)Lose some weight, or (3)Maintain your weight?");
        StartUp.toDiet = user.nextInt();

        StartUp.boolAge = (StartUp.age <= 17);

    }

    public static void yourActiveLevel(){

        P.print("How active are you?");
        P.print("(1) Sedentary");
        P.print("(2) Low Active");
        P.print("(3) Active");
        P.print("(4) Very Active");
        StartUp.activeLevel = user.nextInt();

    }
}
