package readconfig;


/**
 * Reading the configuration file
 * 1. Читаем файл конфигурации [#293815]
 *
 * Наша программа должна запускаться в различном окружении.
 * Например, разные базы данных, разные пути хранения.
 *
 * Все эти настройки нужно хранить вне кода программы.
 * Это позволяет изменять настройки и
 * не трогать собранную программу.
 *
 * Файл настроек должен содержать пары ключ-знания.
 * Ключ-значения должны быть разделены символом равно
 *
 */
/* app.properties
---
## PostgreSQL

hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
hibernate.connection.url=jdbc:postgresql://127.0.0.1:5432/trackstudio
hibernate.connection.driver_class=org.postgresql.Driver
hibernate.connection.username=postgres
hibernate.connection.password=password
---
 */
/**
 * В этом задании нужно реализовать класс Config.
 * Метод load - должен считать все ключи в карту values.
 * Важно в файле могут быть пустые строки и комментарии
 * их нужно пропускать.
 *
 *
 */

