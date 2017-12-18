package com.wowcher;

import com.wowcher.exceptions.InvalidTimeStringException;
import com.wowcher.service.TimeStringConverter;
import com.wowcher.service.TimeStringConverterImpl;
import com.wowcher.validation.TimeStringValidator;
import com.wowcher.validation.TimeStringValidatorImpl;

public class SpeakingClock {

    private TimeStringValidator timeStringValidator = new TimeStringValidatorImpl();
    private TimeStringConverter timeStringConverter = new TimeStringConverterImpl();

    public String convert(String inputTime) throws InvalidTimeStringException {
        timeStringValidator.validate(inputTime);

        String convertedTime = timeStringConverter.convertFromNumbersToWords(inputTime);

        return convertedTime;
    }
}
