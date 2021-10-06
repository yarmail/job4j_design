package osp;

import java.util.List;

/**
 * Теперь поступило требование рисовать круги.
 * Можно ли здесь использовать наследование? Нет.
 * Т.к. при наследовании, наследуется состояние объекта предка.
 * Круг не может иметь те же характеристики,
 * что и прямоугольник, потому что круг «не является»
 * прямоугольником (отношение «is A» наследование),
 * но они оба могут быть отрисованы.
 * Таким образом исходный код изначально спроектирован неверно.
 * Нужно было сделать так:
 */
public class FiguresImplemetationB {
    private interface Drawable {
        String draw();
    }

    private static class Rectangle implements Drawable {
        @Override
        public String draw() {
            return "...";
        }
    }

    public static void main(String[] args) {
        List<Drawable> rectangles = List.of(new Rectangle());
        rectangles.forEach(Drawable::draw);
    }
}
