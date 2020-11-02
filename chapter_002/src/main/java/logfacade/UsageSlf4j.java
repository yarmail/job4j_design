package logfacade;

import log.UsageLog4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageSlf4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }

}
