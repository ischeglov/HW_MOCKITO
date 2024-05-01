import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FilmManagerTest {

    FilmManager filmManager = new FilmManager(4);

    @BeforeEach
    void setUp() {
        filmManager.addFilms("Бладшот");
        filmManager.addFilms("Вперед");
        filmManager.addFilms("Отель 'Белград'");
    }

    @AfterAll
    static void tearDown() {
        System.out.println("Тесты завершены");
    }

    @Test
    void shouldAllFilms() {
        String[] expected = {"Бладшот", "Вперед", "Отель 'Белград'"};
        String[] actual = filmManager.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFilms() {
        FilmManager filmManager = new FilmManager();
        filmManager.addFilms("Бладшот");
        filmManager.addFilms("Вперед");
        filmManager.addFilms("Отель 'Белград'");
        filmManager.addFilms("Джентельмены");
        filmManager.addFilms("Человек-невидимка");
        filmManager.addFilms("Тролли. Мировой тур");
        filmManager.addFilms("Номер один");
        filmManager.addFilms("Фильм №8");

        String[] expected = {"Фильм №8", "Номер один", "Тролли. Мировой тур", "Человек-невидимка", "Джентельмены", "Отель 'Белград'", "Вперед", "Бладшот"};
        String[] actual = filmManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldLimit() {
        filmManager.addFilms("Джентельмены");
        filmManager.addFilms("Человек-невидимка");

        String[] expected = {"Человек-невидимка", "Джентельмены", "Отель 'Белград'", "Вперед"};
        String[] actual = filmManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldMoreLimit() {
        filmManager.addFilms("Джентельмены");
        filmManager.addFilms("Человек-невидимка");
        filmManager.addFilms("Тролли.Мировой тур");
        filmManager.addFilms("Номер один");

        String[] expected = {"Номер один", "Тролли.Мировой тур", "Человек-невидимка", "Джентельмены"};
        String[] actual = filmManager.findLast();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLessLimit() {
        String[] expected = {"Отель 'Белград'", "Вперед", "Бладшот"};
        String[] actual = filmManager.findLast();

        assertArrayEquals(expected, actual);
    }
}