public class DirectoryNode {

    private String name;
    private boolean isFile;
    private DirectoryNode left;
    private DirectoryNode middle;
    private DirectoryNode right;

    public DirectoryNode(String name, boolean isFile) {
        this.name = name;
        this.isFile = isFile;
        this.left = null;
        this.middle = null;
        this.right = null;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
        }
        else if(getMiddle() == null){
            setMiddle(newChild);
        } else {
            setRight(newChild);
        }
    }

    public boolean isOccupied(){
        return getLeft() != null && getMiddle() != null && getRight() != null;
    }
}
