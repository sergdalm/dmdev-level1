package com.sergdalm.week4.homework.task3;

import java.util.List;

/**
 * Даны 2 класса:
 * - Фильм с 5-ю полями:
 * - Уникальный Целочисленный идентификатор (id),
 * - Год издания,
 * - Месяц издания,
 * - Жанр и
 * - Рейтинг;
 * <p>
 * - Кинотеатр, где есть всего лишь одно единственное поле:
 * отсортированный ассоциативный массив, где ключом является год издания,
 * а значением - все фильмы, выпустившиеся в этом году.
 * <p>
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм
 * - получить все фильмы по переданному году
 * - получить все фильмы по переданному году и месяцу
 * - получить все фильмы по переданному жанру
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * <p>
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него
 * (т.е. предусмотреть порядок значения ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * <p>
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */
public class CinemaRunner {

    public static void main(String[] args) {
        Movie movie1 = new Movie(1993, 2, Genre.COMEDY, 5);
        Movie movie2 = new Movie(2005, 1, Genre.HORROR, 6);
        Movie movie3 = new Movie(2017, 5, Genre.FANTASY, 8);
        Movie movie4 = new Movie(1990, 9, Genre.DRAMA, 10);
        Movie movie5 = new Movie(2010, 10, Genre.ACTION, 8);
        Movie movie6 = new Movie(2009, 8, Genre.DOCUMENTARY, 5);
        Movie movie7 = new Movie(2001, 3, Genre.DRAMA, 9);
        Movie movie8 = new Movie(2016, 6, Genre.HORROR, 7);
        Movie movie9 = new Movie(2013, 4, Genre.FANTASY, 4);
        Movie movie10 = new Movie(2010, 9, Genre.ACTION, 5);
        Movie movie11 = new Movie(1990, 12, Genre.ROMANCE, 6);
        Movie movie12 = new Movie(1991, 5, Genre.COMEDY, 7);
        Movie movie13 = new Movie(2018, 3, Genre.DOCUMENTARY, 3);
        Movie movie14 = new Movie(2020, 1, Genre.ROMANCE, 8);

        Cinema cinema = new Cinema();
        cinema.addMovie(movie1);
        cinema.addMovie(movie2);
        cinema.addMovie(movie3);
        cinema.addMovie(movie4);
        cinema.addMovie(movie5);
        cinema.addMovie(movie6);
        cinema.addMovie(movie7);
        cinema.addMovie(movie8);
        cinema.addMovie(movie9);
        cinema.addMovie(movie10);
        cinema.addMovie(movie11);
        cinema.addMovie(movie12);
        cinema.addMovie(movie13);
        cinema.addMovie(movie14);

        System.out.println(cinema);
        System.out.println();

        System.out.println("Best movies:");
        List<Movie> bestTenMovies = cinema.getBestTenMovies();
        System.out.println(bestTenMovies);
        System.out.println();

        System.out.println("Movies by year:");
        List<Movie> moviesByYear = cinema.getMoviesByYear(2010);
        System.out.println(moviesByYear);
        System.out.println();

        System.out.println("Movies by year and month:");
        List<Movie> moviesByYearAndMonth = cinema.getMoviesByYearAndMonth(2010, 9);
        System.out.println(moviesByYearAndMonth);
        System.out.println();

        System.out.println("Movies by genre");
        List<Movie> moviesByGenre = cinema.getMoviesByGenre(Genre.COMEDY);
        System.out.println(moviesByGenre);
    }
}
