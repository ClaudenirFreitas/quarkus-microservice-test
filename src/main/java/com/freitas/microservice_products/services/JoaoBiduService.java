package com.freitas.microservice_products.services;

import com.freitas.microservice_products.models.Signo;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Objects;
import java.util.stream.Stream;

public class JoaoBiduService {

    public static Signo getSigno(LocalDate birthDate) {
        Objects.requireNonNull(birthDate, "birthDate must not be null");

        MonthDay birthDateMonthDay = MonthDay.from(birthDate);

        return signDates.filter(sign ->
                birthDateMonthDay.compareTo(sign.getInicio()) >= 0 && birthDateMonthDay.compareTo(sign.getFim()) <= 0
        ).findFirst().orElseThrow(() -> new IllegalArgumentException("Eita!"));

    }

    private static Stream<Signo> signDates = Stream.of(
            new Signo(MonthDay.of(Month.JANUARY, 1), MonthDay.of(Month.JANUARY, 19), "Capricórnio"),
            new Signo(MonthDay.of(Month.JANUARY, 20), MonthDay.of(Month.FEBRUARY, 18), "Aquário"),
            new Signo(MonthDay.of(Month.FEBRUARY, 19), MonthDay.of(Month.MARCH, 20), "Peixes"),
            new Signo(MonthDay.of(Month.MARCH, 21), MonthDay.of(Month.APRIL, 19), "Aries"),
            new Signo(MonthDay.of(Month.APRIL, 20), MonthDay.of(Month.MAY, 20), "Touro"),
            new Signo(MonthDay.of(Month.MAY, 21), MonthDay.of(Month.JUNE, 21), "Gêmeos"),
            new Signo(MonthDay.of(Month.JUNE, 22), MonthDay.of(Month.JULY, 22), "Câncer"),
            new Signo(MonthDay.of(Month.JULY, 23), MonthDay.of(Month.AUGUST, 22), "Leão"),
            new Signo(MonthDay.of(Month.AUGUST, 23), MonthDay.of(Month.SEPTEMBER, 22), "Virgem"),
            new Signo(MonthDay.of(Month.SEPTEMBER, 23), MonthDay.of(Month.OCTOBER, 22), "Libra"),
            new Signo(MonthDay.of(Month.OCTOBER, 23), MonthDay.of(Month.NOVEMBER, 21), "Escorpião"),
            new Signo(MonthDay.of(Month.NOVEMBER, 22), MonthDay.of(Month.DECEMBER, 21), "Sagitário"),
            new Signo(MonthDay.of(Month.DECEMBER, 22), MonthDay.of(Month.DECEMBER, 31), "Capricórnio")
    );
}
