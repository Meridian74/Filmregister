package hu.guidance.filmregister.model;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class MovieDurationConverter implements AttributeConverter<String, Integer> {

    @Override
    public Integer convertToDatabaseColumn(String duration) {
        if (duration == null || duration.isEmpty() || duration.isBlank()) {
            return null;
        }
        if (duration.contains("-")) {
            return null;
        }

        String[] elements = duration.split(":");
        if (elements.length < 3) {
            return null;
        }

        int secondsOfHours = Integer.parseInt(elements[0]) * 3600;
        int secondsOfMinutes = Integer.parseInt(elements[1]) * 60;
        int seconds = Integer.parseInt(elements[2]);

        if(secondsOfMinutes > 3599 || seconds > 59) {
            return null;
        }

        return secondsOfHours + secondsOfMinutes + seconds;
    }

    @Override
    public String convertToEntityAttribute(Integer duration) {
        if (duration == null || duration < 0) {
            return null;
        }

        String hours = String.valueOf(duration / 3600);
        String minutes = String.valueOf(duration / 60 % 60);
        String seconds = String.valueOf(duration % 60);


        if (minutes.equals("0")) minutes = "00";
        if (minutes.length() == 1) minutes = "0" + minutes;

        if (seconds.equals("0")) seconds = "00";
        if (seconds.length() == 1) seconds = "0" + seconds;

        return hours + ":" + minutes + ":" + seconds;
    }

}
