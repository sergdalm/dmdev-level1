package com.sergdalm.week4.homework.task3;

import java.util.Objects;

/**
 * Фильм с 5-ю полями:
 * - Уникальный Целочисленный идентификатор (id),
 * - Год издания,
 * - Месяц издания,
 * - Жанр
 * - Рейтинг;
 */
public class Movie {
    private static int counter;
    private final int id;
    private final Integer year;
    private final int month;
    private final Genre genre;
    private final int rating;

    public Movie(Integer year, int month, Genre genre, int rating) {
        this.id = counter++;
        this.year = year;
        this.month = month;
        this.genre = genre;
        this.rating = Math.max(0, Math.min(10, rating));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Movie movie = (Movie) o;
        return id == movie.id && month == movie.month && rating == movie.rating && Objects.equals(year, movie.year) && genre == movie.genre;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, year, month, genre, rating);
    }

    @Override
    public String toString() {
        return "Movie {" +
                "id: " + id +
                ", year: " + year +
                ", month: " + month +
                ", genre: " + genre +
                ", rating: " + rating +
                "}";
    }

    public static int getCounter() {
        return counter;
    }

    public int getId() {
        return id;
    }

    public Integer getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public Genre getGenre() {
        return genre;
    }

    public int getRating() {
        return rating;
    }
}
