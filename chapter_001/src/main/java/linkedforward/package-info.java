package linkedforward;

/**
 * Remove head in a singly linked list.
 * 3. Удалить head в односвязном списке. [#293761]
 * В этом задании необходимо реализовать метод deleteFirst
 * для односвязного списка.
 *
 * поле Head - всегда указывает на первый элемент.
 * Процесс удаления в такой структуре сводится
 * к обнулению ссылки на следующий узел.
 *
 * Примечание по методу deleteFirst
 * после того как head переместили
 * head = node.next;
 * нужно сделать
 * node.next = null
 * чтоб эта нода не была никак связана с остальными
 * и могла быть убрана ГЦ при сборке мусора
 */

/**
 * Дополнительно сюда добавляем метод revert()
 * из задания 6. Перевернуть связанный список [#293766]
 *
 */
