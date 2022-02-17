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

        String[] elements = duration.split(":");
        if (elements.length < 3) {
            return null;
        }

        int result = Integer.parseInt(elements[2]) * 3600;
        result += Integer.parseInt(elements[1]) * 60;
        result += Integer.parseInt(elements[0]);
        return result;
    }

    @Override
    public String convertToEntityAttribute(Integer duration) {
        if (duration == null || duration < 1) {
            return null;
        }

        int hours = duration / 3600;
        int minutes = duration % 3600;
        int seconds = duration % 60;
        return hours + ":" + minutes + ":" + seconds;
    }

}
