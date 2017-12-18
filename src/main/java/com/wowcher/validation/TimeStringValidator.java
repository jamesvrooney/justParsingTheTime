package com.wowcher.validation;

import com.wowcher.exceptions.InvalidTimeStringException;

/**
 * Created by jamesvrooney on 18/12/2017.
 */
public interface TimeStringValidator {
    void validate(String time) throws InvalidTimeStringException;
}
