package com.cbt.utilities;

public class DriverUtility {
    public static void waitFor(int seconds){
        try{
            Thread.sleep(1000*seconds);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
