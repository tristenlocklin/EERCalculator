package conversions;

/**
 * Copyright tristenlocklin -- Tristen Locklin 2015.
 * File created on 2/19/15.
 */
public class ActiveIndex {

//    public static int activeLevel;
    public static float activeIndex;

    public static void index(boolean boolGender, boolean boolAge, int activeLevel){

        if (boolGender && boolAge /*This is if the user is a male and is under 18 years old*/){
            if(activeLevel == 1){
                ActiveIndex.activeIndex = 1.0F;
            }else if(activeLevel == 2){
                ActiveIndex.activeIndex = 1.13F;
            }else if(activeLevel == 3){
                ActiveIndex.activeIndex = 1.26F;
            }else{
                ActiveIndex.activeIndex = 1.42F;
            }
        }else if (!boolGender && boolAge/*This is if the user is a female and is under 18 years old*/){
            if(activeLevel == 1){
                ActiveIndex.activeIndex = 1.0F;
            }else if(activeLevel == 2){
                ActiveIndex.activeIndex = 1.16F;
            }else if(activeLevel == 3){
                ActiveIndex.activeIndex = 1.31F;
            }else{
                ActiveIndex.activeIndex = 1.56F;
            }
        }else if (boolGender && !boolAge/*This is if the user is a male and is 18 or over*/){
            if(activeLevel == 1){
                ActiveIndex.activeIndex = 1.0F;
            }else if(activeLevel == 2){
                ActiveIndex.activeIndex = 1.11F;
            }else if(activeLevel == 3){
                ActiveIndex.activeIndex = 1.25F;
            }else{
                ActiveIndex.activeIndex = 1.48F;
            }
        }else{
            if(activeLevel == 1){
                ActiveIndex.activeIndex = 1.0F;
            }else if(activeLevel == 2){
                ActiveIndex.activeIndex = 1.12F;
            }else if(activeLevel == 3){
                ActiveIndex.activeIndex = 1.27F;
            }else{
                ActiveIndex.activeIndex = 1.45F;
            }
        }
        
    }
}
