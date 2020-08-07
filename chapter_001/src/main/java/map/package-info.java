package map;

/**
 * Impact of hashcode and equals on comparing objects and Map
 * Влияние hashcode и equals на сравнение объектов и Map
 *
 * Ситуация 1 класс User1
 * 2. Не перекрывать equals hashCode [#293790]
 *
 * Мы создаем 2 одинаковых объекта
 * User first = new User("Petr");
 * User second = new User("Petr");
 * В результате сравнения этих объетов
 * System.out.println(first.equals(second));
 * получаем false т.к не переопределен метод equals
 * java.base\java\lang\Object.class
 *
 * Как я понимаю, в переменных хранятся ссылки на разные
 * куски (адреса) памяти (хотя и с одинаковым значением)
 * поэтому equals без переопределения,
 * (например сравнение по полям) показывает false
 *
 * Когда мы эти объекты используем как ключи
 * для map, то происходит следующее:
 * Если бы ключи были одинаковыми
 * (т.е. equals определял бы их одинаковыми)
 * то map должен был бы заменить first на second
 * и при печати оставить только 1 объект,
 * но так как он считает их разными объектами
 * то он их не заменяет и при печати мы видим их 2.
 * (уточнить)
 *
 * ===================
 *
 * Ситуация 2 Класс UserB
 * 3. Переопределить только hashCode [#293788]
 * Когда мы не переопределяли hashcode
 * он показывал разные значения, а теперь,
 * когда переопределили, он показывает одинаковые
 *
 * Это позволяет предположить, что нативый
 * (не переопределенный) метод hashcode
 * видит разницу между объектами
 * т.к. объекты находятся в разных местах памяти
 *
 * Однако, даже при одинаковых показателях
 * hashcode map показывает 2 объекта,
 * Это говорит о том, что этого не достаточно
 * и нужно ещё переопределять equals, если мы хотим
 * добиться замены в map
 *
 * На данный момент print map все равно показывает 2 объекта.
 * ==============
 *
 * Ситуация 3 Класс UserC
 * Переопределяем только equals без hashcode
 * на примере класса UserC
 * Используем переопределение по умолчанию от Idea
 * Используется сравнение по полям
 *
 * first.equals(second) показывает true - то есть по
 * equals объекты одинаковые
 *
 * Однако (не переопределенный) hashcode показывает,
 * что объекты разные т.к. он настроен не на расчетах
 * по полям
 *
 * Таким образом, при укладке в map println показывает
 * 2 объекта, а не затирает один другим
 *
 * ============
 *
 * Ситуация 4, класс UserD
 *
 * В этом примере переопределяем equals и hashcode
 * на примере класса UserD и наблюдаем результаты
 * И equals и hashcode показывают равенство ключей
 *
 * В результате мы видим, что при добавлении в маp - второй
 * ключ заменил первый и остался там один.
 *
 * Общий вывод: внимательно, аккуратно и правильно работать c equals
 * и hashcode объектов, во многих случаях (например hashmap)
 * требуется переопределение и того и другого для правильной
 * работы по сравнению.
 */