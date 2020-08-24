package tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

class Tree<E> implements TreeSimple<E> {
    private final Node<E> root;

    Tree(final E root) {
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

    /**
     * Для выполнения принципа DRY избавляемся от дублирования
     * кода в методах findBy(), isBinary()
     */
    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root); // добавляет в очередь или возвращает false
        while (!data.isEmpty()) {
            Node<E> el = data.poll(); // берет первый элемент очереди
            if (condition.test(el)) { // логика остается, условия меняются в методах
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.children);
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(node -> node.value.equals(value));
    }

    /**
     * Дерево является бинарным, если у всех узлов не более двух потоков.
     * Решить эту задачу лучше от обратного, т.е. мы предполагаем,
     * что в дереве есть узел, у которого больше 2 потомков и
     * проверяем, что он не существует
     */
    public boolean isBinary() {
        return findByPredicate(node -> node.children.size() > 2).isEmpty();
    }
}