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
     * @throws NotADirectoryException
     *      Thrown if the node with the indicated name is a file, as files cannot be selected by the cursor, or cannot be found.
     */
    public void changeDirectory(String name) throws NotADirectoryException{
        try {
            changeDirectory(root, name);
        } catch (NotADirectoryException e){
            e.printStackTrace();
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
        String wd = "";
        DirectoryNode tracker = root;
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

    public String listDirectory(DirectoryNode node){

        if(node.isFile()){
            return "-" + node.getName();
        } else {
            return "|- " + node.getName();
        }


    }

    public void printDirectoryTree(){

    }

    /**
     * Creates a directory with the indicated name and adds it to the children of the cursor node.
     * @param name
     *          The name of the directory to add.
     * @throws IllegalArgumentException  Thrown if the 'name' argument is invalid.
     * @throws FullDirectoryException Thrown if all child references of this directory are occupied.
     */
    public void makeDirectory(String name) throws IllegalArgumentException, FullDirectoryException{ //mkdir

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
                System.out.println("Directory not found. Please enter another directory.");
            }
        }

    }

    public void preorder(DirectoryNode node){

    }

}
