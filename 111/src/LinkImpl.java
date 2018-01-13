public class LinkImpl implements Link{
    private class Node {
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public void addNode(Node newNode) {
            if (this.next==null){
                this.next=newNode;
            }else {
                this.next.addNode(newNode);
            }
        }

        public void printNode() {
            System.out.println(this.data);
            if (this.next==null){
                return;
            }else {
                this.next.printNode();
            }
        }

        public boolean containsNode(Object data) {
            if (this.data.equals(data)){
                return true;
            }else if (this.next==null){
                return false;
            }else {
                return this.next.containsNode(data);
            }
        }

        public Object getNode(int index) {
            if (foot++==index){
                return this.data;
            }else{
                return this.next.getNode(index);
            }
        }

        public void setNode(int index, Object data) {
            if (foot++==index){
                this.data=data;
            }else{
                this.next.setNode(index,data);
            }
        }

        public void removeNode(Node node,Object data) {
            if (this.data.equals(data)){
                node.next=this.next;
            }else if (this.next==null){
                return;
            }else {
                this.next.removeNode(this,data);
            }
        }

        public Object[] toArrayNode() {
            array[foot++]=this.data;
            if (this.next==null){
                return array;
            }else {
                return this.next.toArrayNode();
            }
        }
    }

    private Node root;
    private int count=0;
    private int foot=0;
    private Object[] array;

    @Override
    public void add(Object data) {
        Node newNode = new Node(data);
        if (root==null){
            root=newNode;
        }else {
            root.addNode(newNode);
        }
        count++;
    }

    @Override
    public void print() {
        if (root==null){
            System.out.println("null");
        }else {
            root.printNode();
        }
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public boolean contains(Object data) {
        if (root==null){
            return false;
        }
        return root.containsNode(data);
    }

    @Override
    public Object get(int index) {
        if (index>count-1||index<0){
            return null;
        }
        foot=0;
        return root.getNode(index);
    }

    @Override
    public void set(int index, Object data) {
        if (index>count-1||index<0){
            return;
        }
        foot=0;
        root.setNode(index,data);
    }

    @Override
    public void remove(Object data) {
        if (root==null){
            return;
        }else if (root.data.equals(data)){
            root=root.next;
        }else {
            root.next.removeNode(root,data);
        }
        count--;
    }

    @Override
    public void clear() {
        root=null;
        count=0;
    }

    @Override
    public Object[] toArray() {
        if (root==null){
            return null;
        }else {
            array=new Object[count];
            foot=0;
            return root.toArrayNode();
        }
    }
}
