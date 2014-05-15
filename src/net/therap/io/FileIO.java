package net.therap.io;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: imran.azad
 * Date: 5/15/14
 * Time: 9:27 AM
 * To change this template use File | Settings | File Templates.
 */
public class FileIO extends UserIO {

    private BufferedReader bufferedReader;

    public FileIO(String fileName) throws FileNotFoundException {
        File inputFile = new File(fileName);
        bufferedReader = new BufferedReader(new FileReader(inputFile));
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
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void printRowWithHourHitAndDuration(int hour, int hit, int duration) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void printTotalHitAndDuration(int totalHit, int totalDuration) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
