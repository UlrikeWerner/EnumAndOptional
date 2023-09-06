package com.github.UlrikeWerner.Enum;

import java.math.BigInteger;

public record Person(
        BigInteger id,
        String name,
        DaysOfWeek favoriteDay
) {
}
