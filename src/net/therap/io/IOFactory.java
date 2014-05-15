package net.therap.io;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: imran.azad
 * Date: 4/6/14
 * Time: 3:41 PM
 * To change this template use File | Settings | File Templates.
 */
public class IOFactory {

    public static final int TYPE_FILE = 0, TYPE_DB = 1, TYPE_URL = 2, TYPE_CONSOLE = 3;

    public static UserIO getResourceAsUserIO(int resourceType) {
        UserIO userIO = null;

        if (resourceType == TYPE_FILE) {
            userIO = getFileIO();
        } else if (resourceType == TYPE_DB) {

        } else if (resourceType == TYPE_URL) {

        } else if (resourceType == TYPE_CONSOLE) {

        }

        return userIO;
    }

    private static FileIO getFileIO() {
        FileIO fileIO = null;

        BufferedReader bufferedReader;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Input File Location:");
        try {
            String filename;
            filename = bufferedReader.readLine();
            fileIO = new FileIO(filename);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }

        return fileIO;
    }

}
