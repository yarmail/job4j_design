package encoding;

/**
 * Encoding
 * 6. Кодировка. [#293818]
 *
 * В этом уроке мы познакомимся с понятием кодировка
 * и научимся применять его в своем коде, чтобы избегать
 * недоразумений при работе с текстовыми файлами.
 *
 * В общем случае кодировка - это однозначное
 * соответствие между подмножеством целых чисел
 * (как правило идущих подряд) и некоторым набором символов.
 * Ключевым понятием здесь является понятие символа.
 * Это может быть как буква, может соответствовать звуку речи,
 * а также может быть представлен графическим знаком.
 * Проще говоря - это мельчайшая неделимая частица информации.
 *
 * Например латинское "A" и кириллическое "А" - это разные  символы,
 * потому что они употребляются в разных контекстах и несут в себе
 * разную информацию.
 *
 * Определяющим для любой кодировки является количество охватываемых
 * ею кодов и, соответственно, символов. Поскольку тексты
 * в компьютере хранятся в виде последовательности байтов,
 * большинство кодировок естественным образом распадаются
 * на однобайтовые, или восьмибитные, способные закодировать
 * не больше 256 символов, и двухбайтовые, или шестнадцатибитные,
 * чья емкость может достигать 65636 знакомест.
 *
 * Если говорить совсем простым языком, то кодировка для
 * компьютера - это просто разные языка, как человека английский,
 * русский или китайский. Для кодировки есть отдельные таблицы,
 * в котором указано соответствие между символом и числом
 * в которое кодируется этот символ. Например большинство шрифтов,
 * которые определены в программе Microsoft Word имеют
 * кодировку Windows-1251, одной из основоположниц кодирования
 * является кодировка ASCII. Мы же в своих проектах используем
 * кодировку UTF-8  и с самых первых шагов обучения
 * рекомендуем проверить, чтобы среда разработки
 * Inteliji IDEA была настроена на использование именно
 * этой кодировки - увидеть это можно в правом нижнем углу
 * открытого окна среды разработки:
 *
 * Создадим UsageEncoding.java - для чтения файла и записи новых данных
 * Создадим файл по пути /src/data/text.txt и заполним его
 * несколькими строками произвольного содержания:
 * Строка 1
 * Строка 2
 * Строка 3
 *
 * Все выполнено успешно, такой вывод нас устраивает.
 * Давайте откроем наш файл в программке WordPad в котором есть
 * набор шрифтов, аналогичных шрифтам Microsoft Word
 * (как было упомянуто ранее большинство из них имеют
 * кодировку Windows-1251), и добавим еще несколько новых
 * текстовых строк (в качестве шрифта я выбрал Times New Roman):
 *
 * Строка 4
 * Строка 5
 * Строка 6
 *
 * уже на стадии добавления новых строк мы видим что те строки,
 * которые в документе ранее отображаются как "кракозябры".
 * Всему виной то, что первые строки закодированы в кодировке
 * UTF-8, а нижние три Windows-1251. Вернемся в Intelij IDEA
 * и посмотрим как этот файл выглядит там/
 *
 * тут все наоборот - в файле не распознаются нижние три строки.
 * Давайте попробуем прочитать данные из этого файла -
 * вывод в консоль будет следующим:
 *
 * результат вполне предсказуемый. Но давайте попробуем разобраться
 * как быть в такой ситуации. Обратимся к официальной документации
 * и прочитаем как работает с данными класс FileReader():
 *
 * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/io/FileReader.html#%3Cinit%3E(java.lang.String)
 *
 * Получается что при чтении файла класс использует кодировку
 * платформы по умолчанию, т.е. в нашем случае это UTF-8.
 * Нам это не совсем подходит, поскольку у нас в файле есть другая
 * кодировка и нас в данную секунду мало интересуют первые три строки,
 * мы хотим прочитать последние три, которые дописал для нас другой
 * пользователь. Что же делать в данной ситуации?
 * Все очень просто - надо использовать другой конструктор FileReader,
 * в котором можно указать какую кодировку для чтения использовать:
 *
 * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/io/FileReader.html#%3Cinit%3E(java.io.File,java.nio.charset.Charset)
 *
 * Для передачи экземпляра Charset (он определен в пакете java.nio.charset), как того требует этот
 * конструктор можно использовать следующую конструкцию:
 *
 * Charset.forName("WINDOWS-1251")
 *
 * и тогда весь конструктор в измененном виде будет иметь вид:
 *
 * new FileReader(path, Charset.forName("WINDOWS-1251"))
 *
 * В нашем случае потеряли 3 первые строки(кодировка в них UTF-8),
 * однако узнали содержимое последних строк. Также для определения
 * стандартных кодировок можно использовать статические поля,
 * которые определены в классе StandardCharsets(он определен
 * в пакете java.nio.charset):
 *
 * https://docs.oracle.com/en/java/javase/14/docs/api/java.base/java/nio/charset/StandardCharsets.html
 *
 * Но мы все еще не решили проблему - данные в одном файле
 * у нас определены в разных кодировках. Тут стоит поступить
 * простым способом - наш код должен уметь читать данные из
 * файла и записывать в него новые данные. При этом делать
 * это в одной кодировке. Добавим метод, который будет
 * записывать новые данные файл и при этом сразу определим
 * для него кодировку данных для записи:
 *
 * (см UsageEncodingB)
 * new FileWriter(path, Charset.forName("WINDOWS-1251"), true)))
 * Видоизменим наш метод main и запишем его следующим образом:
 * (см main)
 * т.е. все работает корректно, несмотря на то, что в самом файле
 * в среде Intelij IDEA данные не распознаются:
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */
