package tempfolder;

/**
 *
 * В рамках темы 3.0. Тестирование IO [#293809]
 *
 * Рассмотрим задачу по удалению из файла запрещенных слов.
 * Результат работы этой программы будет новый файл.
 * Давайте напишем на него тест и обсудим его.
 *
 * Чтобы создать файлы во временной директории, нужно
 * использовать класс org.unit.rules.TemporaryFolder.
 * Этот класс позволяет создавать файлы и директории
 * во временном каталоге.
 *
 * После запуска теста файлы созданные через
 * TemporaryFolder будут удалены.
 * Теперь нам нет необходимости заботиться о мусоре,
 * который оставляет наш тест, потому что его уберет
 * класс  TemporaryFolder.
 */