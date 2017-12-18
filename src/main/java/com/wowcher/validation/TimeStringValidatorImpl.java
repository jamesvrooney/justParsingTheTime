package com.wowcher.validation;

import com.wowcher.exceptions.InvalidTimeStringException;

import java.util.regex.Pattern;

/**
 * Created by jamesvrooney on 18/12/2017.
 */
public class TimeStringValidatorImpl implements TimeStringValidator {
    private static final String TIME_PATTERN = "^([0-1][0-9]|2[0-3]):[0-5][0-9]$";

    private final Pattern pattern = Pattern.compile(TIME_PATTERN);

    @Override
    public void validate(String time) throws InvalidTimeStringException {
        if (!pattern.matcher(time).matches()) {
            throw new InvalidTimeStringException("The time string format should be 24hr clock format: (0-2)(0-3):(0-5)(0-9)");
        }
    }
}
