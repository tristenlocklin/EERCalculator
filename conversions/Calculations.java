package conversions;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/19/15.
 */
public class Calculations {

    public static int EER;

    public static void runEERImperial(int age, boolean selectedUnits, boolean boolGender, float weightInKilos, float heightInMeters){

        if(!selectedUnits){
            if (boolGender){
                //EER = 662 - (9.53 x age [y]) + PA x { (15.91 x weight [kg]) + (539.6 x height [m]) }
                //This is the equation for a male.
                Calculations.EER = (int) (662 - (9.53 * age) + ActiveIndex.activeIndex * ((15.91 * ConvertItems.convertedToKilos) + (539.6 * ConvertItems.convertedToMeters)));
            }else{
                //EER = 354 - (6.91 x age [y]) + PA x { (9.36 x weight [kg]) + (726 x height [m]) }
                //This is the equation for a female.
                Calculations.EER = (int) (354 - (9.91 * age) + ActiveIndex.activeIndex * ((9.36 * ConvertItems.convertedToKilos) + (726 * ConvertItems.convertedToMeters)));
            }
        }else{
            if(boolGender){
                Calculations.EER = (int) (662 - (9.53 * age) + ActiveIndex.activeIndex * ((15.91 * weightInKilos) + (539.6 * heightInMeters)));
            }else{
                Calculations.EER = (int) (354 - (9.91 * age) + ActiveIndex.activeIndex * ((9.36 * weightInKilos) + (726 * heightInMeters)));

            }
        }
    }
}
