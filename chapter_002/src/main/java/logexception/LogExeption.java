package logexception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogExeption {

    private static final Logger LOG = LoggerFactory.getLogger(LogExeption.class.getName());

    /**
     * В этом примере stack исключения печатается
     * напрямую в консоль.
     */
    public static void mainOld(String[] args) {
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Перенаправим его в логгер.
     * в описании пакета показаны ошибки
     *
     */
    public static void main(String[] args) {
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Exception in log example", e);
        }
    }
}