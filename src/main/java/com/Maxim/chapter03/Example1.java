package com.Maxim.chapter03;

public class Example1 {
    public static void main(String[] args) {
        int lightspeed;
        long days;
        long seconds;
        long distance;
        // Приблизительная скорость света в милях за се кунду.
        lightspeed = 186000;
        days =1000; // указать количество дней
        seconds =days *24*60*60;
        distance =lightspeed *seconds;

        System.out.print("За "+days );
        System.out.print(" дней свет пройдет около ");
        System.out.println(distance +" миль.");
    }

}

