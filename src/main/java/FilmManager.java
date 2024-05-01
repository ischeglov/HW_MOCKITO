public class FilmManager {

    private String[] films = new String[0];
    private int countFilms;

    public FilmManager() {
        this.countFilms = 8;
    }

    public FilmManager(int countFilms) {
        this.countFilms = countFilms;
    }

    public void addFilms(String movie) {
        String[] tmp = new String[films.length + 1];
        for (int i = 0; i < films.length; i++) {
            tmp[i] = films[i];
        }
        tmp[tmp.length - 1] = movie;
        films = tmp;
    }

    public String[] findAll() {
        return films;
    }

    public String[] findLast() {
        int resultLength;
        if (countFilms > films.length) {
            resultLength = films.length;
        } else {
            resultLength = countFilms;
        }
        String[] tmp = new String[resultLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = films[films.length - 1 - i];
        }
        return tmp;
    }
}
