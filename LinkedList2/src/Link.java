public class Link {
    private Node root;
    private int count=0;
    private Object[] array;
    public void add(Object data){
        if (data==null){
            return;
        }
        Node newNode = new Node(data);
        if (root==null){
            root=newNode;
        }else {
            root.addNote(newNode);
        }
        count++;
    }
    public int size(){
        return count;
    }
    public boolean isEmpty(){
        return root==null;
    }
    public boolean contains(Object data){
        if (root==null){
            return false;
        }else {
            return root.containsNode(data);
        }
    }
    public Object get(int index){
        if (index<0||index>count-1){
            return null;
        }

        Node.setFoot(0);
        return root.getNode(index);
    }
    public void set(int index,Object data){
        if (index<0||index>count-1){
            return;
        }

        Node.setFoot(0);
        root.setNode(index,data);
    }
    public void remove(Object data){
        if (!this.contains(data)){
            return;
        }
        if (this.root.getData().equals(data)){
            this.root=this.root.getNext();
        }else {
            this.root.getNext().removeNode(root,data);
        }
        count--;
    }
    public void clear(){
        this.root=null;
        this.count=0;
    }
    public Object[] toArray(){
        if (this.root==null){
            return null;
        }
        this.array=new Object[this.count];
        Node.setFoot(0);
        array=this.root.toArrayNode(array);
        return this.array;
    }
}
