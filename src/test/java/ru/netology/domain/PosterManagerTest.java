package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PosterManagerTest {
    ListOfFilms film1 = new ListOfFilms(1, "Бладшот", "боевик");
    ListOfFilms film2 = new ListOfFilms(2, "Вперед", "мультфильм");
    ListOfFilms film3 = new ListOfFilms(3, "Отель \"Белград\"", "комедия");
    ListOfFilms film4 = new ListOfFilms(4, "Джентельмены", "боевик");
    ListOfFilms film5 = new ListOfFilms(5, "Человек-невидимка", "ужасы");
    ListOfFilms film6 = new ListOfFilms(6, "Тролли. Мировой тур", "мультфильм");
    ListOfFilms film7 = new ListOfFilms(7, "Номер один", "комедия");

    @Test
    public void shouldAddFilmInPoster() {
        PosterManager poster = new PosterManager();

        poster.addFilm(film1);
        poster.addFilm(film2);
        poster.addFilm(film3);
        poster.addFilm(film4);
        poster.addFilm(film5);
        poster.addFilm(film6);
        poster.addFilm(film7);

        ListOfFilms[] expected = {film1, film2, film3, film4, film5, film6, film7};
        ListOfFilms[] actual = poster.findALL();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsDefault() {
        PosterManager poster = new PosterManager();

        poster.addFilm(film1);
        poster.addFilm(film2);
        poster.addFilm(film3);
        poster.addFilm(film4);
        poster.addFilm(film5);
        poster.addFilm(film6);
        poster.addFilm(film7);

        ListOfFilms[] expected = {film7, film6, film5, film4, film3};
        ListOfFilms[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsUnderDefault() {
        PosterManager poster = new PosterManager(3);

        poster.addFilm(film1);
        poster.addFilm(film2);
        poster.addFilm(film3);
        poster.addFilm(film4);
        poster.addFilm(film5);
        poster.addFilm(film6);
        poster.addFilm(film7);

        ListOfFilms[] expected = {film7, film6, film5};
        ListOfFilms[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsAboveDefault() {
        PosterManager poster = new PosterManager(7);

        poster.addFilm(film1);
        poster.addFilm(film2);
        poster.addFilm(film3);
        poster.addFilm(film4);
        poster.addFilm(film5);
        poster.addFilm(film6);
        poster.addFilm(film7);

        ListOfFilms[] expected = {film7, film6, film5, film4, film3, film2, film1};
        ListOfFilms[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindLastFilmsIfCountOfFilmsUnderDefault() {
        PosterManager poster = new PosterManager();

        poster.addFilm(film1);
        poster.addFilm(film2);
        poster.addFilm(film3);
        poster.addFilm(film4);

        ListOfFilms[] expected = {film4, film3, film2, film1};
        ListOfFilms[] actual = poster.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}