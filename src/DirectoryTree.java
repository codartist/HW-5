/**
 * Justin Fagan
 * DirectoryTree
 *id: 112089362
 */
public class DirectoryTree {

    private DirectoryNode root;
    private DirectoryNode cursor;

    public DirectoryTree() {

        this.root = new DirectoryNode("root",false);
        this.cursor = root;

    }

    /**
     * Moves the cursor to the root node of the tree.
     *
     * Postconditions:
     *      The cursor now references the root node of the tree.
     */
    public void resetCursor(){

        this.cursor = root;

    }

    /**
     * Moves the cursor to the directory with the name indicated by name.
     * @param name
     *          The name of the Node
     */
    public void changeDirectory(String name) {

            if (name.equals("/"))
                resetCursor();
            if (name.equals("..") && cursor.getParent() != null){
                cursor = cursor.getParent();
            }
            else if (cursor.getLeft() != null && cursor.getLeft().getName().equals(name)){
                cursor = cursor.getLeft();
            } else if(cursor.getMiddle() != null && cursor.getMiddle().getName().equals(name)){
                cursor = cursor.getMiddle();
            } else if(cursor.getRight() != null && cursor.getRight().getName().equals(name)){
                cursor = cursor.getRight();
            } else {
                System.out.println("ERROR: No such directory named " + name);
            }
    }

    /**
     * Returns a String containing the path of directory names from the root node of the tree to the cursor,
     * with each name separated by a forward slash "/".
     *
     * @return A formatted String of DirectoryNode names.
     *
     * Postcondition:
     *      The cursor remains at the same DirectoryNode.
     */
    public String presentWorkingDirectory(){

        String path = absolutePath(cursor);
        return reversePath(path);
    }

    /**
     * Returns a String containing a space-separated list of names of all the child directories or files of the cursor.
     *
     * @return A formatted String of DirectoryNode names.
     */
    public String listDirectory(){
        String ls = "";

        if (cursor.getLeft() != null){
            ls += cursor.getLeft().getName() + " ";
        }
        if (cursor.getMiddle() != null){
            ls += cursor.getMiddle().getName() + " ";
        }
        if (cursor.getRight() != null){
            ls += cursor.getRight().getName();
        }

        return ls;

    }

    /**
     * Recursively lists the directory and every descendant starting at the node
     * @param node the node to start from
     * @return A String with the path of the working directory
     */
    public String listDirectory(DirectoryNode node){
        String ls = "";
        if (node != null) {
            if (node.isFile()) {
                ls += "- " + node.getName() + "\n";
            } else {
                ls += "|- " + node.getName() + "\n";
                ls += "    ";
            }
            if (node.getLeft() != null) {
                ls += listDirectory(node.getLeft());
            }
            if (node.getMiddle() != null) {
                ls += listDirectory(node.getMiddle());
            }
            if (node.getRight() != null) {
                ls += listDirectory(node.getRight());
            }
        }
        return ls;
    }

    public void printDirectoryTree(){

        System.out.println(listDirectory(cursor));

    }

    /**
     * Creates a directory with the indicated name and adds it to the children of the cursor node.
     * @param name
     *          The name of the directory to add.
     * @throws IllegalArgumentException  Thrown if the 'name' argument is invalid.
     * @throws FullDirectoryException Thrown if all child references of this directory are occupied.
     */
    public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException{ //mkdir

        if (name.contains(" ") || name.contains("/")) throw new IllegalArgumentException();
        if (cursor.isOccupied()) throw new FullDirectoryException();

        DirectoryNode newDirectory = new DirectoryNode(name, false);
        try {
            cursor.addChild(newDirectory);
        } catch (NotADirectoryException e) {
            e.printStackTrace();
        }
    }

    public void changeDirectory(DirectoryNode node, String name) throws NotADirectoryException{

        if (node.isFile()) throw new NotADirectoryException();
        if (node.getName().equals(name)){
            cursor = node;
        } else {
            if (node.getLeft() != null){
                changeDirectory(node.getLeft(), name);
            } else if(node.getMiddle() != null){
                changeDirectory(node.getMiddle(), name);
            } else if(node.getRight() != null){
                changeDirectory(node.getRight(), name);
            } else {
                System.out.println("ERROR: No such directory named " + name);
            }
        }

    }

    /**
     * Returns the working directory in reverse order
     * @param node the node
     * @return The reverse path separated by spaces
     */
    public String absolutePath(DirectoryNode node) {
        String path = "";
        if (node != null) {
            path += node.getName() + " ";
        }
        if (node.getParent() != null) {
            path += absolutePath(node.getParent());
        }

        return path;
    }

    public String reversePath(String path){
        String reverse = "";
        String[] directory = path.split(" ");
        for (int i = directory.length-1 ; i >= 0 ; i--) {
            reverse += directory[i] + "/";
        }
        return reverse;
    }

    public DirectoryNode getRoot() {
        return root;
    }

    public void setRoot(DirectoryNode root) {
        this.root = root;
    }

    public DirectoryNode getCursor() {
        return cursor;
    }

    public void setCursor(DirectoryNode cursor) {
        this.cursor = cursor;
    }
}
