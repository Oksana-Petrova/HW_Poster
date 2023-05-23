package ru.netology.domain;

public class PosterManager {

    private ListOfFilms[] films = new ListOfFilms[0]; //создание массива
    private int countOfFilms;

    // количество фильмов по умолчанию
    public PosterManager() {
        countOfFilms = 5;
    }

    //заданное количество фильмов
    public PosterManager(int countOfFilms) {
        this.countOfFilms = countOfFilms;
    }

    //добавление нового фильма
    public void addFilm(ListOfFilms film) {
        ListOfFilms[] tmp = new ListOfFilms[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = film;
        films = tmp;
    }

    //вывод всех фильмов в порядке добавления
    public ListOfFilms[] findALL() {
        return films;
    }

    //вывод N последних добавленных фильмов
    public ListOfFilms[] findLast() {
        int resultLength;
        if (films.length < countOfFilms) {
            resultLength = films.length;
        } else {
            resultLength = countOfFilms;
        }
        ListOfFilms[] result = new ListOfFilms[resultLength];
        for (int i = 0; i < result.length; i++) {
            result[i] = films[films.length - 1 - i];
        }
        return result;
    }
}