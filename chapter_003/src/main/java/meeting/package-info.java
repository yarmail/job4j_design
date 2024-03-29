package meeting;

/**
 * 2. Доп. задача
 *
 * 1. Есть таблица встреч(id, name), есть таблица юзеров(id, name).
 *
 * Нужно доработать модель базы данных, так чтобы пользователи
 * могли учавствовать во встречах.
 * У каждого участника встречи может быть разный статус участия
 * - например подтвердил участие, отклонил.
 *
 * 2. Нужно написать запрос, который получит список всех заявок
 * и количество подтвердивших участников.
 *
 * 3. Нужно получить все совещания, где не было
 * ни одной заявки на посещения
 *
 * Для простоты понимания представим, что мы пишем программу,
 * которая регистрирует мероприятия, пользователей.
 * Помимо этого программа может рассылать приглашения пользователям,
 * либо пользователи сами могу подавать заявки, и так и так
 * под "заявкой" подразумевается как заявка от пользователя
 * так и приглашение, т.к. представляют они одну запись в таблице.
 * Ну и конечно программа реализует функционал под запросы,
 * описанные в задании.
 *
 * Давайте уточним:
 * - что значит послать приглашение (учтем то, что пользователь
 * и мероприятие уже существуют). Это значит добавить запись
 * в таблицу, связывающую пользователя и мероприятие.
 * Пусть когда приглашение послано запись в таблице имеет статус
 * "pending" или "в ожидании".
 *
 *  - что значит подать заявку. Это значит опять же связать
 *  пользователя и мероприятие, но в этом случае статус можно
 *  задать как "принято", потому что пользователь сам изъявил желание.
 *
 * - что значит отклонить. Это значит найти запись по пользователю
 * и мероприятию и обновить статус на "rejected" или "отклонено"
 *
 * - что значит принять. Это значит найти запись по
 * пользователю и мероприятию и обновить
 * статус на "accepted" или "принято"
 *
 * - наконец, что значит мероприятие, где не было ни одной
 * заявки на посещение. Так или иначе мероприятие и пользователь
 * связываются через таблицу связывающую их (думаю это понятно).
 * Задание конечно двусмысленно, но лучше его трактовать
 * как мероприятие, у которого нет участников.
 *
 * А это значит, что надо найти такие мероприятия, у которых либо
 * все записи под статусом "rejected" либо о них вовсе
 * не было упоминания в связывающей таблице.
 */
