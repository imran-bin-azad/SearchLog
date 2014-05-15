package net.therap;

import net.therap.io.UserIO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: imran.azad
 * Date: 4/6/14
 * Time: 5:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchLog {

    private UserIO input;
    private UserIO output;
    private final int HOUR_IN_DAY=24;
    private int hitCount[],durationCount[];

    SearchLog(UserIO inputObject, UserIO outputObject) {
        input = inputObject;
        output = outputObject;
        hitCount= new int[HOUR_IN_DAY];
        durationCount= new int[HOUR_IN_DAY];
    }

    void generateStatisticsFromMatchedLines (String patternString) {
        /*
            searches the pattern string in the log file
            Generates status (hitcount,duration) for each hour
         */
        int positionOfTimestamp = 1, positionOfDurationString = 16, positionOfPatternToMatch = 14;
        String delimiters = " ";
        String parts[];
        Pattern pattern = Pattern.compile(patternString);

        String line;
        while((line=input.getLine())!=null) {
            if (line.contains("PROFILER")) {
                parts= line.split(delimiters);

                Matcher matcher;
                boolean match;
                matcher= pattern.matcher(parts[positionOfPatternToMatch]);
                match= matcher.find();

                if (match) {
                    int hour,duration;
                    hour= getHourValueFromTimestamp(parts[positionOfTimestamp]);
                    duration= getTimeValueFromDurationString(parts[positionOfDurationString]);

                    hitCount[hour]++;
                    durationCount[hour]+= duration;
                }
            }
        }
    }

    void showStatisticsByHour () {
        int totalHit=0,totalDuration=0;

        output.printTableHeader();
        for (int loop=0;loop<HOUR_IN_DAY;loop++) {
            output.printRowWithHourHitAndDuration(loop, hitCount[loop], durationCount[loop]);

            totalHit+= hitCount[loop];
            totalDuration+= durationCount[loop];
        }
        output.printTotalHitAndDuration(totalHit, totalDuration);
    }

    int getHourValueFromTimestamp (String timestamp) {
        String delimitedTimestamp[];
        String delimiters = ":";
        delimitedTimestamp = timestamp.split(delimiters);

        int positionOfHourValue = 0;
        return Integer.parseInt(delimitedTimestamp[positionOfHourValue]);
    }

    int getTimeValueFromDurationString (String duration) {
        String delimitedDurationString[];
        String delimiters = "=|m";
        delimitedDurationString = duration.split(delimiters);

        int positionOfTimeValue = 2;
        return Integer.parseInt(delimitedDurationString[positionOfTimeValue]);
    }

}
