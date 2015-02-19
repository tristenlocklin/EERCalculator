import conversions.ConvertItems;

import java.util.Scanner;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/17/15.
 */
public class EERCalc {

    public static void print(String message){
        System.out.println(message);
    }

    /**
     * TODO: Add the ability to use SI Units -- DONE
     * TODO: Add /healthy/ bulking and dieting options. -- DONE
     * TODO: Give percentages for how much fat, carbohydrates, and proteins you should be consuming. -- DONE
     * TODO: Move shit to its own classes, cause this shit is messy.
     */

    public static void main(String[] args){

        Scanner user = new Scanner(System.in);

        print("EER Calculator v0.2");

        print("Are you (M)Male or (F)Female?");
        String gender = user.nextLine();
        boolean boolGender = gender.toLowerCase().equals("m");

        print("Would you like to use (1)SI Units or (2)Imperial Units?");
        int units = user.nextInt();
        boolean selectedUnits = (units == 1);

        float weightInKilos = 0, weightInLbs = 0, heightInMeters = 0, heightInInches = 0;

        if(!selectedUnits){
            print("What is your weight in lbs?");
            weightInLbs = user.nextFloat();

            print("What is your height in inches?");
            heightInInches = user.nextFloat();
        }else{
            print("What is your weight in kilos");
            weightInKilos = user.nextFloat();

            print("What is your height in meters?");
            heightInMeters = user.nextFloat();
        }

        print("How old are you currently?");
        int age = user.nextInt();

        print("Are you currently trying to (1)Gain some weight, (2)Lose some weight, or (3)Maintain your weight?");
        int toDiet = user.nextInt();

        boolean boolAge = (age <= 17);

        ConvertItems.proceedToConvert((int)heightInInches, (int)weightInLbs);

//        print("Your weight in Kilograms is: " + convertedToKilos + "kgs");
//        print("Your height in Meters is: " + convertedToMeters + "m");

        print("How active are you?");
        print("(1) Sedentary");
        print("(2) Low Active");
        print("(3) Active");
        print("(4) Very Active");
        int activeLevel = user.nextInt();

        float activeIndex;
        int EER = 0;

        if (boolGender && boolAge /*This is if the user is a male and is under 18 years old*/){
            if(activeLevel == 1){
                activeIndex = 1.0F;
            }else if(activeLevel == 2){
                activeIndex = 1.13F;
            }else if(activeLevel == 3){
                activeIndex = 1.26F;
            }else{
                activeIndex = 1.42F;
            }
        }else if (!boolGender && boolAge/*This is if the user is a female and is under 18 years old*/){
            if(activeLevel == 1){
                activeIndex = 1.0F;
            }else if(activeLevel == 2){
                activeIndex = 1.16F;
            }else if(activeLevel == 3){
                activeIndex = 1.31F;
            }else{
                activeIndex = 1.56F;
            }
        }else if (boolGender && !boolAge/*This is if the user is a male and is 18 or over*/){
            if(activeLevel == 1){
                activeIndex = 1.0F;
            }else if(activeLevel == 2){
                activeIndex = 1.11F;
            }else if(activeLevel == 3){
                activeIndex = 1.25F;
            }else{
                activeIndex = 1.48F;
            }
        }else{
            if(activeLevel == 1){
                activeIndex = 1.0F;
            }else if(activeLevel == 2){
                activeIndex = 1.12F;
            }else if(activeLevel == 3){
                activeIndex = 1.27F;
            }else{
                activeIndex = 1.45F;
            }
        }

        if(!selectedUnits){
            if (boolGender){
                //EER = 662 - (9.53 x age [y]) + PA x { (15.91 x weight [kg]) + (539.6 x height [m]) }
                //This is the equation for a male.
                EER = (int) (662 - (9.53 * age) + activeIndex * ((15.91 * ConvertItems.convertedToKilos) + (539.6 * ConvertItems.convertedToMeters)));
            }else{
                //EER = 354 - (6.91 x age [y]) + PA x { (9.36 x weight [kg]) + (726 x height [m]) }
                //This is the equation for a female.
                EER = (int) (354 - (9.91 * age) + activeIndex * ((9.36 * ConvertItems.convertedToKilos) + (726 * ConvertItems.convertedToMeters)));
            }
        }else{
            if(boolGender){
                EER = (int) (662 - (9.53 * age) + activeIndex * ((15.91 * weightInKilos) + (539.6 * heightInMeters)));
            }else{
                EER = (int) (354 - (9.91 * age) + activeIndex * ((9.36 * weightInKilos) + (726 * heightInMeters)));

            }
        }

        int updateEER;

        if (toDiet == 2){
            updateEER = EER - 500;
        }else if (toDiet == 1){
            updateEER = EER + 500;
        }else{
            updateEER = EER;
        }

        int carbLimit = ((updateEER / 2) / 4);
        int fatLimit = (int) ((updateEER * .3F) / 9);
        int proteinLimit = (int) ((updateEER * .2F) / 4);

        print("According to what you provided, your EER is: " + updateEER + "kcal");
        print("Meaning, you should be consuming at least " + updateEER + " calories a day to sustain your weight.");
        print("You should consume " + carbLimit + "g of Carbohydrates a day.");
        print("You should consume " + fatLimit + "g of Fats a day.");
        print("You should consume " + proteinLimit + "g of Proteins a day.");
    }
}