import java.util.Scanner;

public class BashTerminal {

    private static boolean running = true;
    private static DirectoryTree main = new DirectoryTree();

    /**
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (isRunning()) {
            System.out.print("[jufagan@host]: $");
            String option = scanner.nextLine();

            runner(main, option);
        }
        System.out.println("Program terminating normally");
    }

    public static boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        BashTerminal.running = running;
    }

    public static void runner(DirectoryTree tree, String option) {
        switch (option) {
            case "pwd":
                tree.presentWorkingDirectory();
                break;
            case "ls":
                tree.listDirectory();
                break;
            case "ls -R":
                tree.listDirectory(tree.getCursor());
                break;
        }
    }


}
