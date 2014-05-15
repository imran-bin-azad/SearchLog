package net.therap.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: imran.azad
 * Date: 5/15/14
 * Time: 9:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class ConsoleIO extends UserIO {

    private BufferedReader bufferedReader;

    public ConsoleIO() {
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    @Override
    public String getLine() {
        String line = null;
        try {
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        return line;
    }

    @Override
    public void printTableHeader() {
        System.out.printf("Hour         HitCount         TotalDuration(ms)\n");
    }

    @Override
    public void printRowWithHourHitAndDuration(int hour, int hit, int duration) {
        System.out.printf("%4d %16d %21d\n", hour, hit, duration);
    }

    @Override
    public void printTotalHitAndDuration(int totalHit, int totalDuration) {
        System.out.println("-------------------------------------------------------");
        System.out.printf("%21d %21d\n", totalHit, totalDuration);
    }

}
