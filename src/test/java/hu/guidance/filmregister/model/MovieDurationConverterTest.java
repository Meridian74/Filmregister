package hu.guidance.filmregister.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class MovieDurationConverterTest {

    static Stream<Arguments> secondsToTimeCode() {
        return Stream.of(
                arguments(0, "0:00:00"),
                arguments(12896, "3:34:56"),
                arguments(264896, "73:34:56")
        );
    }

    static Stream<Arguments> wrongTimeToNull() {
        return Stream.of(
                arguments("-1:00:00"),
                arguments("1:60:12"),
                arguments("1:12:60")
        );
    }

    static Stream<Arguments> timeCodeToSeconds() {
        return Stream.of(
                arguments("0:00:00", 0),
                arguments("0:02:01", 121),
                arguments("3:34:56", 12896),
                arguments("73:34:56", 264896)
        );
    }

    private static final MovieDurationConverter MDC = new MovieDurationConverter();


    @ParameterizedTest
    @MethodSource("secondsToTimeCode")
    void durationSecondsConvertTimeCode(Integer expectedSeconds, String timeCode) {
        Integer time = MDC.convertToDatabaseColumn(timeCode);
        assertEquals(expectedSeconds, time);
    }

    @ParameterizedTest
    @MethodSource("wrongTimeToNull")
    void wrongTimeCodeToNull(String wrongTimeCode) {
        Integer time = MDC.convertToDatabaseColumn(wrongTimeCode);
        assertNull(time);
    }

    @Test
    void durationSecondsConvertTimeCode() {
        String timeCode = null;
        Integer time = MDC.convertToDatabaseColumn(timeCode);
        assertNull(time);
    }


    @ParameterizedTest
    @MethodSource("timeCodeToSeconds")
    void durationTimeCodeConvertSeconds(String expectedTimeCode, Integer time) {
        String timeCode = MDC.convertToEntityAttribute(time);
        assertEquals(expectedTimeCode, timeCode);
    }

    @Test
    void durationTimeCodeConvertSecondsTestNegative() {
        Integer time = -1;
        String timeCode = MDC.convertToEntityAttribute(time);
        assertNull(timeCode);
    }

    @Test
    void durationTimeCodeConvertSecondsTestNull() {
        Integer time = null;
        String timeCode = MDC.convertToEntityAttribute(time);
        assertNull(timeCode);
    }

}
