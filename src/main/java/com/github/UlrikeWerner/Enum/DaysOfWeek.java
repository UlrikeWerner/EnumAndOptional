package com.github.UlrikeWerner.Enum;

public enum DaysOfWeek {
    MONDAY("Werktag"),
    TUESDAY("Werktag"),
    WEDNESDAY("Werktag"),
    THURSDAY("Werktag"),
    FRIDAY("Werktag"),
    SATURDAY("Wochenende"),
    SUNDAY("Wochenende");

    private final String typeOfDay;

    DaysOfWeek(String typeOfDay){
        this.typeOfDay = typeOfDay;
    }

    public String getTypeOfDay() {
        return typeOfDay;
    }
}
