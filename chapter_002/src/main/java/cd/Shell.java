package cd;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Shell {
    private String result = "";

    private void normalize(String path) {
        Path pathToPath = Paths.get(path).normalize();
        result = pathToPath.toString().replaceAll(".*[/\\\\].*", "/");
    }

    public void cd(String path) {
        if (path.equals("/")) {
            result = "/";
        } else if (result.equals("") && path.contains("..")) {
            normalize(path);
        } else if (!result.equals("") && path.contains("..")) {
            path = result + "/" + path;
            normalize(path);
        } else  {
            result = result + "/" + path;
        }
    }

    public String pwd() {
        return result;
    }
}