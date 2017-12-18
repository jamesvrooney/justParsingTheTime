package com.wowcher.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by jamesvrooney on 18/12/2017.
 */
public class TimeStringConverterImpl implements TimeStringConverter {
    private final String COLON = ":";
    private final Map<Integer, String> singleDigitStrings = new HashMap<>();
    private final Map<Integer, String> tenToNineteen = new HashMap<>();
    private final Map<Integer, String> twentyToFifty = new HashMap<>();

    public TimeStringConverterImpl() {
        populateNumberMaps();
    }

    @Override
    public String convertFromNumbersToWords(String inputTime) {
        String[] timeParts = inputTime.split(COLON);
        int hrs = Integer.parseInt(timeParts[0]);
        int mins = Integer.parseInt(timeParts[1]);

        String convertedHours;
        String convertedMinutes;
        int singleDigitPart;
        int tensPart;

        if (hrs == 0 && mins == 0) {
            return "It's Midnight";
        } else if (hrs == 12 && mins == 0) {
            return "It's Midday";
        }

        if (hrs < 10) {
            convertedHours = singleDigitStrings.get(hrs);
        } else if (hrs > 9 && hrs < 20) {
            convertedHours = tenToNineteen.get(hrs);
        } else {
            singleDigitPart = hrs % 10;
            tensPart = hrs - singleDigitPart;
            convertedHours = twentyToFifty.get(tensPart) + " " + singleDigitStrings.get(singleDigitPart);
        }

        if (mins < 10) {
            convertedMinutes = "zero " + singleDigitStrings.get(mins);
        } else if (mins > 9 && mins < 20) {
            convertedMinutes = tenToNineteen.get(mins);
        } else {
            singleDigitPart = mins % 10;
            tensPart = mins - singleDigitPart;
            convertedMinutes = twentyToFifty.get(tensPart) + " " + singleDigitStrings.get(singleDigitPart);
        }

        return "It's " + convertedHours + " " + convertedMinutes;
    }

    private void populateNumberMaps() {
        singleDigitStrings.put(0, "zero");
        singleDigitStrings.put(1, "one");
        singleDigitStrings.put(2, "two");
        singleDigitStrings.put(3, "three");
        singleDigitStrings.put(4, "four");
        singleDigitStrings.put(5, "five");
        singleDigitStrings.put(6, "six");
        singleDigitStrings.put(7, "seven");
        singleDigitStrings.put(8, "eight");
        singleDigitStrings.put(9, "nine");

        tenToNineteen.put(10, "ten");
        tenToNineteen.put(11, "eleven");
        tenToNineteen.put(12, "twelve");
        tenToNineteen.put(13, "thirteen");
        tenToNineteen.put(14, "fourteen");
        tenToNineteen.put(15, "fifteen");
        tenToNineteen.put(16, "sixteen");
        tenToNineteen.put(17, "seventeen");
        tenToNineteen.put(18, "eighteen");
        tenToNineteen.put(19, "nineteen");

        twentyToFifty.put(20, "twenty");
        twentyToFifty.put(30, "thirty");
        twentyToFifty.put(40, "forty");
        twentyToFifty.put(50, "fifty");
    }
}
