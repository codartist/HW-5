public class DirectoryNode {

    private String name;
    private boolean isFile;
    private DirectoryNode parent;
    private DirectoryNode left;
    private DirectoryNode middle;
    private DirectoryNode right;

    public DirectoryNode(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
        this.left = null;
        this.middle = null;
        this.right = null;
        this.parent = null;
    }


    /**
     * Returns the name of the node
     *
     * @return the the file or directory name
     */
    public String getName() {

        return name;

    }

    /**
     * Changes the name of the node
     *
     * @param name the new name to set the name value to
     */
    public void setName(String name) {

        this.name = name;

    }

    /**
     * @return
     */
    public boolean isFile() {

        return isFile;

    }

    public void setIsFile(boolean isFile) {

        this.isFile = isFile;

    }

    public DirectoryNode getLeft() {

        return left;

    }

    public void setLeft(DirectoryNode left) {

        this.left = left;

    }

    public DirectoryNode getMiddle() {

        return middle;

    }

    public void setMiddle(DirectoryNode middle) {

        this.middle = middle;

    }

    public DirectoryNode getRight() {

        return right;

    }

    public void setRight(DirectoryNode right) {

        this.right = right;

    }

    public void addChild(DirectoryNode newChild) throws NotADirectoryException, FullDirectoryException{
        if(this.isFile()){
            throw new NotADirectoryException();
        }
        if(isOccupied()){
            throw new FullDirectoryException();
        }
        if (getLeft() == null){
            setLeft(newChild);
        } else if (getMiddle() == null) {
            setMiddle(newChild);
        } else {
            setRight(newChild);
        }

        newChild.setParent(this);
    }

    public DirectoryNode getParent() {
        return parent;
    }

    public void setParent(DirectoryNode parent) {
        this.parent = parent;
    }

    public boolean isOccupied(){

        return getLeft() != null && getMiddle() != null && getRight() != null;

    }
}
