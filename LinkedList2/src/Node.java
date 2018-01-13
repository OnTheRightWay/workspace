public class Node {
    private Object data;
    private Node next;
    private static int foot=0;

    public Object getData() {
        return data;
    }

    public static int getFoot() {
        return foot;
    }

    public Node getNext() {
        return next;
    }

    public static void setFoot(int foot) {
        Node.foot = foot;
    }

    public Node(Object data) {
        this.data = data;
    }
    public void addNote(Node newNode){
        if (this.next==null){
            this.next=newNode;
        }else {
            this.next.addNote(newNode);
        }
    }

    public boolean containsNode(Object data) {
        if (data==null){
            return false;
        }else if (this.data.equals(data)){
            return true;
        }else if(this.next==null){
            return false;
        }else {
            return this.next.containsNode(data);
        }
    }

    public Object getNode(int index) {
        if (foot==index){
            return this.data;
        }else if (this.next==null){
            return null;
        }else {
            foot++;
            return this.next.getNode(index);
        }
    }

    public void setNode(int index, Object data) {
        if (foot==index){
            this.data=data;
        }else if (this.next==null){
            return;
        }else {
            foot++;
            this.next.setNode(index,data);
        }
    }

    public void removeNode(Node previous,Object data) {
        if (this.data.equals(data)){
            previous.next=this.next;
        }else if (this.next==null){
            return;
        }{
            this.next.removeNode(this,data);
        }
    }

    public Object[] toArrayNode(Object[] array) {
        array[foot]=this.data;
        if (this.next==null){
            return array;
        }else {
            foot++;
            return this.next.toArrayNode(array);
        }
    }
}
