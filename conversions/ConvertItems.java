package conversions;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/17/15.
 */
public class ConvertItems {

    public static float convertedToMeters;
    public static float convertedToKilos;


    public static void proceedToConvert(int heightInches, int weightLbs){

        ConvertItems.convertedToMeters = (heightInches * 0.0254F);
        ConvertItems.convertedToKilos = (weightLbs * 0.453592F);

    }
}
