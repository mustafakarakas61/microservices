const weatherTranslations: Record<string, string> = {
    "clear sky": "açık hava",
    "few clouds": "az bulutlu",
    "scattered clouds": "dağınık bulutlar",
    "broken clouds": "kapalı bulutlar",
    "shower rain": "yağmur",
    "rain": "yağmur",
    "thunderstorm": "gök gürültülü fırtına",
    "snow": "kar",
    "mist": "sis",
    "light intensity shower rain": "hafif şiddette sağanak yağmur"
};

export const translateWeatherDescription = (description: string) => {
    return weatherTranslations[description] || description;
};