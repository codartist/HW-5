import java.util.Scanner;
/**
 * Justin Fagan
 * BashTerminal
 *id: 112089362
 */
public class BashTerminal {

    private static boolean running = true;
    private static DirectoryTree main = new DirectoryTree();

    /**
     * @param args
     */
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (isRunning()) {
            System.out.print("[jufagan@host]: $ ");
            String option = scanner.nextLine();

            runner(main, option);
        }
        System.out.println("Program terminating normally");
    }

    public static boolean isRunning() {
        return running;
    }

    public static void setRunning(boolean running) {
        BashTerminal.running = running;
    }

    public static void runner(DirectoryTree tree, String option) {
        if (option.contains("mkdir")){
            if (option.split(" ").length == 2){
                try {
                    tree.makeDirectory(option.split(" ")[1]);
                } catch (FullDirectoryException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Make sure there are no spaces in the directory name");
            }

        }
        else if (option.contains("touch")){
            if (option.split(" ").length == 2){
                DirectoryNode newNode = new DirectoryNode(option.split(" ")[1], true);
                try {
                    tree.getCursor().addChild(newNode);
                } catch (NotADirectoryException e) {
                    e.printStackTrace();
                } catch (FullDirectoryException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Make sure there are no spaces in the file name");
            }
        }
        else if (option.contains("cd")){
            tree.changeDirectory(option.split(" ")[1]);
        } else {
            switch (option) {
                case "pwd":
                    System.out.println(tree.presentWorkingDirectory());
                    break;
                case "ls":
                     System.out.println(tree.listDirectory());
                    break;
                case "ls -R":
                    tree.printDirectoryTree();
                    break;
                case "exit":
                    setRunning(false);
                    break;

                default:
                    System.out.println("Make sure you're inputting a valid terminal command.");
                    break;
            }
        }

    }


}
