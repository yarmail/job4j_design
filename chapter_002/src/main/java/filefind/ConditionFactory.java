package filefind;

import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class ConditionFactory {

    public static Predicate<Path> newCondition(ArgFind args) {
        String type = args.searchType();
        Predicate<Path> result = p -> true;
        switch (type.toLowerCase()) {
            case "f":
                result = new RegexSearchCondition(args.pattern());
                break;
            case "m":
                result = new RegexSearchCondition(preparePattern(args.pattern()));
                break;
            case "r":
                result = p -> p.toFile().getName().matches(args.pattern());
                break;
            default:
                break;
        }
        return result;
    }

    private static class RegexSearchCondition implements Predicate<Path> {

        private final Pattern pattern;

        public RegexSearchCondition(String name) {
            this.pattern = Pattern.compile(name);
        }

        @Override
        public boolean test(Path path) {
            return pattern.matcher(path.toFile().getName()).matches();
        }
    }

    private static String preparePattern(String pattern) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (c == '*') {
                sb.append(".*");
            } else if (c == '.') {
                sb.append("\\.");
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}