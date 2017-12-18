package com.wowcher;

import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

import com.wowcher.exceptions.*;

public class SpeakingClockTest {

    private static SpeakingClock speakingClock;

    @BeforeClass
    public static void setup() {
        speakingClock = new SpeakingClock();
    }

    @Test(expected = InvalidTimeStringException.class)
    public void testNonNumericString() throws InvalidTimeStringException {
        // Given
        String inputTime = "ac:dc";

        String actual = speakingClock.convert(inputTime);
    }

    @Test(expected = InvalidTimeStringException.class)
    public void testInvalidHour() throws InvalidTimeStringException {
        // Given
        String inputTime = "29:34";

        String actual = speakingClock.convert(inputTime);
    }

    @Test(expected = InvalidTimeStringException.class)
    public void testInvalidMinute() throws InvalidTimeStringException {
        // Given
        String inputTime = "12:76";

        String actual = speakingClock.convert(inputTime);
    }

    @Test
    public void testValidAMTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "08:34";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's eight thirty four";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testValidPMTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "14:52";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's fourteen fifty two";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testValidMidnightTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "00:00";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's Midnight";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testValidOneMinuteBeforeMidnightTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "23:59";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's twenty three fifty nine";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testValidOneMinuteAfterMidnightTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "00:01";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's zero zero one";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testValidMiddayTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "12:00";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's Midday";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testValidOneMinuteBeforeMiddayTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "11:59";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's eleven fifty nine";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test
    public void testValidOneMinuteAfterMiddayTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "12:01";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's twelve zero one";

        assertThat(actual, is(equalTo(expected)));
    }

    @Test(expected = InvalidTimeStringException.class)
    public void testInvalidNegativeTime() throws InvalidTimeStringException {
        // Given
        String inputTime = "-12:01";

        String actual = speakingClock.convert(inputTime);
        String expected = "It's twelve zero one";

        assertThat(actual, is(equalTo(expected)));
    }
}