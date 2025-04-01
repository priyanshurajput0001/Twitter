import java.io.IOException;

public class Util {

    public static void clearConsole() {
        final String os = System.getProperty("os.name");
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        }catch(IOException | InterruptedException e){
            throw new RuntimeException(e);
        }
    }
}
