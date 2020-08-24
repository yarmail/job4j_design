// В УЧЕБНЫХ ЦЕЛЯХ ОСТАВИЛ СТАРЫЙ ВАРИАНТ ДЛЯ СРАВНЕНИЯ С НОВЫМ
package tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Queue;

class TreeOld<E> implements TreeSimple<E> {
    private final Node<E> root;

    TreeOld(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        if (findBy(child).isEmpty()) {
            Optional<Node<E>> node = findBy(parent);
            if (node.isPresent()) {
                node.get().add(new Node<>(child));
                rsl = true;
            }
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.value.equals(value)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
    /**
     * Определяет бинарность дерева
     * Если дочерних элементов <=2
     * дерево бинарное
     *
     * признак бинарного дерева
     */
    public boolean isBinary() {
        boolean rsl = true;
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.children.size() > 2) {
                rsl = false;
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }
}