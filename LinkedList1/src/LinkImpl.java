public class LinkImpl implements Link {
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

        public boolean containsNode(Object data) {
            if(this.data==data){
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
            }else if (this.next==null){
                return null;
            }else {
                return this.next.getNode(index);
            }
        }

        public void setNode(int index, Object data) {
            if (foot++==index){
                this.data=data;
            }else {
                this.next.setNode(index,data);
            }
        }

        public void removeNode(Node previous, Object data) {
            if (this.data.equals(data)){
                previous.next=this.next;
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
        if (data==null){
            return;
        }
        Node newNode = new Node(data);
        if (root==null){
            root=newNode;
        }else {
            root.addNode(newNode);
        }
        count++;
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
        if (index>this.count-1||index<0){
            return null;
        }
        this.foot = 0;
        return root.getNode(index);
    }

    @Override
    public void set(int index, Object data) {
        if (index>this.count-1||index<0){
            return;
        }
        this.foot = 0;
        root.setNode(index,data);
    }

    @Override
    public void remove(Object data) {
        if (root==null){
            return;
        }
        if (root.data.equals(data)){
            root=root.next;
        }
        if (root.next==null){
            return;
        }
        root.next.removeNode(root,data);
        count--;
    }

    @Override
    public void clear() {
        this.root=null;
    }

    @Override
    public Object[] toArray() {
        if (root==null){
            return null;
        }
        array=new Object[count];
        foot=0;
       return root.toArrayNode();
    }
}
