package net.therap;

import net.therap.io.IOFactory;
import net.therap.io.UserIO;

public class Main {


    public static void main(String[] args) {
        UserIO input = IOFactory.getResourceAsUserIO(IOFactory.TYPE_FILE);
        UserIO output= IOFactory.getResourceAsUserIO(IOFactory.TYPE_CONSOLE);
        SearchLog searchlog = new SearchLog(input, output);

        String pattern;
        pattern= UserIO.getSearchPattern();
        searchlog.generateStatisticsFromMatchedLines(pattern);
        searchlog.showStatisticsByHour();
    }
}
