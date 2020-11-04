package logvar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Задание
 * Создайте 8 переменных с примитивным типом.
 * Все типы должны быть разными.
 *
 * Выведите переменные на консоль через логгер.
 */
public class TempVar {


    private static final Logger LOG = LoggerFactory.getLogger(TempVar.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        byte byt = 13;
        short sht = 15;
        long lng = 25;
        float flt = 30;
        double dbl = 35;
        char chr = 'f';
        LOG.debug("User info name : {}, age : {}, byte : {}, short : {}, long : {}, float : {}, double : {}, char : {}",
                             name, age, byt, sht, lng, flt, dbl, chr);
    }
}