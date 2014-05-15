package net.therap.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created with IntelliJ IDEA.
 * User: imran.azad
 * Date: 5/15/14
 * Time: 9:09 AM
 * To change this template use File | Settings | File Templates.
 */
public abstract class UserIO {

    public abstract String getLine();

    public static String getSearchPattern() {
        String line = null;
        try (
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            System.out.println("Pattern to Match:");
            line = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return line;
    }

    public abstract void printTableHeader();

    public abstract void printRowWithHourHitAndDuration(int hour, int hit, int duration);

    public abstract void printTotalHitAndDuration(int totalHit, int totalDuration);

}
