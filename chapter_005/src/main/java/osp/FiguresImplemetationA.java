package osp;

import java.util.List;

/**
 * Интерфейсы и их реализация
 * Пусть изначально был написан такой код
 */
public class FiguresImplemetationA {
    private static class Rectangle {
        public String draw() {
            return "...";
        }
    }

    public static void main(String[] args) {
        List<Rectangle> rectangles = List.of(new Rectangle());
        rectangles.forEach(Rectangle::draw);
    }
}