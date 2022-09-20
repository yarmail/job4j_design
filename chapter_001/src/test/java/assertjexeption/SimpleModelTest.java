package assertjexeption;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

/**
 *
 */
class SimpleModelTest {

    /**
     * Так можно проверить генерацию исключения,
     * когда метод класса не принимает аргументы
     */
    @Test
    void checkGetName() {
        SimpleModel simpleModel = new SimpleModel();
        assertThatThrownBy(simpleModel::getName)
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Так проверяется метод, принимающий аргументы
     */
    @Test
    void checkName() {
        SimpleModel simpleModel = new SimpleModel();
        assertThatThrownBy(() -> simpleModel.setName("name", 5))
                .isInstanceOf(IllegalArgumentException.class);
    }

    /**
     * Так можно проверить наличие текстового
     * информационного сообщения, сопровождающее исключение
     */
    @Test
    void checkMessage() {
        SimpleModel simpleModel = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> simpleModel.setName(word, number))
                /* проверяем наличие исключения */
                .isInstanceOf(IllegalArgumentException.class)
                /* проверяем факт наличия сообщения */
                .message()
                .isNotEmpty();
    }

    @Test
    void checkWordMessage() {
        SimpleModel simpleModel = new SimpleModel();
        String word = "name";
        int number = 5;
        assertThatThrownBy(() -> simpleModel.setName(word, number))
                /* проверяем класс исключения */
                .isInstanceOf(IllegalArgumentException.class)
                /* с помощью регулярного выражения проверяем факт наличия сообщения*/
                .hasMessageMatching("^.+")
                /* проверяем, что в сообщении есть соответствующие параметры*/
                .hasMessageContaining(word, number)
                /* проверяем наличие конкретного слова в сообщении*/
                .hasMessageContaining("name");
    }
}