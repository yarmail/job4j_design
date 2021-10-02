package tddtemplate;

import java.util.Map;

/**
 * (написаны модели тестов)
 */
public interface Generator {

    String produce(String template, Map<String, String> args);
}
