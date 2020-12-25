package cd;

public class Shell {
    String result = "";

    public void cd(String path) {
        if (path.equals("/")) {
            result = "/";
        } else if (path.contains("..")) {
            result = "/";
        } else {
            result = result + "/" + path;
        }
    }

    public String pwd() {
        return result;
    }
}