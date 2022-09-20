package assetjcollection;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class SimpleCollectionTest {

    /**
     * Этот метод показывает основные
     * операции проверки содержания коллекции
     */
    @Test
    void generalAssert() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).isNotEmpty()
                /*размер:*/
                .hasSize(5)
                /*содержит элементы:*/
                .contains(1, 5, 4)
                /*содержит это в любом порядке, дубликаты не важны:*/
                .containsOnly(1, 5, 4, 3)
                /*содержит только это и только в указанном порядке:*/
                .containsExactly(1, 1, 3, 4, 5)
                /*содержит только это в любом порядке:*/
                .containsExactlyInAnyOrder(5, 1, 3, 4, 1)
                /*содержит хотя бы один из:*/
                .containsAnyOf(200, 100, 3)
                /*не содержит ни одного из:*/
                .doesNotContain(0, 6)
                /*начинается с последовательности:*/
                .startsWith(1, 1)
                /*заканчивается на последовательность:*/
                .endsWith(4, 5)
                /* содержит последовательность:*/
                .containsSequence(1, 3);
    }

    /**
     * Этот тестовый метод показывает,
     * как можно проверить выполнение элементами
     * коллекции нужных условий
     */
    @Test
    void satisfyAssert() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        assertThat(sc).isNotNull()
                /*все элементы выполняют условие*/
                .allSatisfy(e -> {
                    assertThat(e).isLessThan(10);
                    assertThat(e).isGreaterThan(0);
                })
                /*хотя бы один элемент выполняет условие*/
                .anySatisfy(e -> {
                    assertThat(e).isLessThan(5);
                    assertThat(e).isEqualTo(3);
                })
                .allMatch(e -> e < 10)
                .anyMatch(e -> e == 5)
                .noneMatch(e -> e < 1);
    }

    /**
     * Этот метод показывает, что можно выбрать
     * один элемент из коллекции и
     * дальше проверять только его
     */
    @Test
    void checkNavigationList() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        /*первый элемент*/
        assertThat(sc).first().isEqualTo(1);
        /*элемент по индексу*/
        assertThat(sc).element(0).isNotNull()
                .isEqualTo(1);
        /*последний элемент*/
        assertThat(sc).last().isNotNull()
                .isEqualTo(5);
    }

    /**
     * Этот метод показывает, как можно выбрать из коллекции
     * группу элементов по некоторому условию и
     * дальше работать с отобранной группой
     */
    @Test
    void checkFilteredList() {
        SimpleCollection<Integer> sc = new SimpleCollection<>(1, 1, 3, 4, 5);
        /*фильтруем источник по предикату и работаем с результатом фильтрации*/
        assertThat(sc).filteredOn(e -> e > 1).first().isEqualTo(3);
        /*фильтруем с помощью assertThat() и работаем с результатом фильтрации*/
        assertThat(sc).filteredOnAssertions(e -> assertThat(e).isLessThan(3))
                .hasSize(2)
                .first().isEqualTo(1);
    }
}