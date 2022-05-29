package com.sergdalm.week4.homework.task3;

import java.util.*;
import java.util.function.Predicate;

public class Cinema {
    private final Map<Integer, List<Movie>> movies;

    public Cinema() {
        this.movies = new TreeMap<>();
    }

    public void addMovie(Movie movie) {
        if (movies.containsKey(movie.getYear())) {
            List<Movie> moviesOfThisYear = movies.get(movie.getYear());
            moviesOfThisYear.add(movie);
        } else {
            movies.put(movie.getYear(), new ArrayList<>(List.of(movie)));
        }
    }

    // получить все фильмы по переданному году
    List<Movie> getMoviesByYear(int year) {
        return movies.get(year);
    }

    // получить все фильмы по переданному году и месяцу
    List<Movie> getMoviesByYearAndMonth(int year, int month) {
        List<Movie> moviesByYearAndMonth = getMoviesByYear(year);
        if (moviesByYearAndMonth != null) {
            moviesByYearAndMonth.removeIf(getMovieByMonthPredicate(month));
            return moviesByYearAndMonth;
        } else {
            return null;
        }
    }

    private Predicate<Movie> getMovieByMonthPredicate(int month) {
        return movie -> movie.getMonth() != month;
    }

    // получить все фильмы по переданному жанру
    List<Movie> getMoviesByGenre(Genre genre) {
        List<Movie> moviesByGenre = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : movies.entrySet()) {
            List<Movie> movieList = entry.getValue();
            for (Movie movie : movieList) {
                if (movie.getGenre().equals(genre)) {
                    moviesByGenre.add(movie);
                }
            }
        }
        return moviesByGenre;
    }

    // получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
    List<Movie> getBestTenMovies() {
        List<Movie> beastMovies = new ArrayList<>();
        for (Map.Entry<Integer, List<Movie>> entry : movies.entrySet()) {
            List<Movie> movieList = entry.getValue();
            beastMovies.addAll(movieList);
        }

        beastMovies.sort(new CompareByRating());
        return beastMovies.subList(0, Math.min(movies.size(), 10));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Cinema: \n");
        for (Map.Entry<Integer, List<Movie>> entry : movies.entrySet()) {
            List<Movie> movieList = entry.getValue();
            for (Movie movie : movieList) {
                stringBuilder.append("  " + movie + "\n");
            }

        }
        return stringBuilder.toString();
    }

    static class CompareByRating implements Comparator<Movie> {
        @Override
        public int compare(Movie movie1, Movie movie2) {
            return movie2.getRating() - movie1.getRating();
        }
    }
}


