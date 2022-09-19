package assertjprim;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class BoxTest {
     Box box;

    @Test
    void isThisSphere() {
        box = new Box(0, 10);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Sphere")
                .isNotEqualTo("Tetrahedron")
                .isNotEmpty();
    }

    @Test
    void isThisTetrahedron() {
        box = new Box(4,  4);
        String name = box.whatsThis();
        assertThat(name).isEqualTo("Tetrahedron")
                .isNotEqualTo("Sphere")
                .contains("Tetra");
    }

    @Test
    void whenFourVertices() {
        box = new Box(4, 4);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(4)
                .isNotZero()
                .isPositive();
    }

    @Test
    void whenEightVertices() {
        box = new Box(8, 6);
        int vertex = box.getNumberOfVertices();
        assertThat(vertex).isEqualTo(8)
                .isNotZero()
                .isGreaterThan(7);
    }

    @Test
    void isExist() {
        box = new Box(0, 10);
        boolean result = box.isExist();
        assertThat(result).isTrue()
                .isEqualTo(true);
    }

    @Test
    void isNotExist() {
        box = new Box(7, 6);
        boolean result = box.isExist();
        assertThat(result).isFalse()
                .isEqualTo(false);
    }

    @Test
    void areaOfSphere() {
        box = new Box(0, 10);
        double result = box.getArea();
        assertThat(result).isNotZero()
                .isGreaterThan(1000.100)
                .isEqualTo(1256.6370614359173);
    }

    @Test
    void areaOfCube() {
        box = new Box(8, 6);
        double result = box.getArea();
        assertThat(result).isNotZero()
                .isLessThan(300)
                .isEqualTo(216.0);
    }

}