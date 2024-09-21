package com.mustafa.weather.utils;

public class Utility {
    public static String fixCityName(String city) {
        if (city == null || city.isEmpty()) {
            return city;
        }

        String converted = city.trim()
                .replace('ç', 'c')
                .replace('ğ', 'g')
                .replace('ı', 'i')
                .replace('ö', 'o')
                .replace('ş', 's')
                .replace('ü', 'u')
                .replace('Ç', 'C')
                .replace('Ğ', 'G')
                .replace('İ', 'I')
                .replace('Ö', 'O')
                .replace('Ş', 'S')
                .replace('Ü', 'U');

        return converted.substring(0, 1).toUpperCase() + converted.substring(1).toLowerCase();
    }
}
