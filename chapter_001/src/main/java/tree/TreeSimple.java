package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface TreeSimple<E> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

    class Node<E> {
        final E value;
        final List<Node<E>> children = new ArrayList<>();

        public Node(E value) {
            this.value = value;
        }

        //Метод добавления child в список children
        public void add(Node<E> child) {
            this.children.add(child);
        }

        public List<Node<E>> getChildren() {
            return children;
        }
    }
}
