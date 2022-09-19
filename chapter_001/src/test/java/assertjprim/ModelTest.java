package assertjprim;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ModelTest {
    /**
     * _Порядок написания утверждений в библиотеке
     * AssertJ простой и единообразный - в метод
     * assertThat() передаем результат выполнения э
     * тапа Act (переменная result) и проверяем
     * соответствие ожидаемому результату - мы ожидаем true:
     */
    @Test
    void  checkBoolean() {
        Model model = new Model(1, 5.255d, "name", true);
        boolean result = model.isCondition();
        assertThat(result).isTrue();
    }

    /**
     * Возможна проверка сразу нескольких утверждений
     * для одного assertThat(result)
     */
    @Test
    void checkStringChain() {
        Model model = new Model(1, 5.255d, "I am learning Java", true);
        String result = model.getLine();
        assertThat(result).isNotNull()
                .isNotEmpty()
                .isNotBlank()
                .containsIgnoringCase("java")
                .contains("am", "Java")
                .doesNotContain("javascript")
                .startsWith("I am")
                .endsWith("Java")
                .isEqualTo("I am learning Java");
    }

    /**
     * Проверка целочисленных типов интуитивно понятна:
     * Количественная проверка типов с плавающей точкой
     * на равенство производится с учетом точности оценки,
     * которая может быть выражена как в абсолютных величинах,
     * так и в процентах. Сначала указывается
     * опорная точка оценки (значение 5.25d), а далее
     * допустимая погрешность. Качественная оценка
     * результата эквивалентна понятиям "больше" "меньше"
     */
    @Test
    void checkDoubleChain() {
        Model model = new Model(1, 5.255d, "name", true);
        double result = model.getNum();
        assertThat(result).isEqualTo(5.26d, withPrecision(0.006d))
                .isCloseTo(5.25d, withPrecision(0.01d))
                .isCloseTo(5.25, Percentage.withPercentage(1.0d))
                .isGreaterThan(5.25d)
                .isLessThan(5.26d);
    }
}