package blockchain;

public class Node {
    private Transaction transaction;
    private int node_id;
    private Node nextNode;

    public Node(){
        super();
        transaction=null;
        node_id=0;
        nextNode=null;
    }
    public Node(Transaction transaction,int node_id,Node nextNode){
        super();
        this.transaction=transaction;
        this.node_id=node_id;
        this.nextNode=null;
    }
    public Node(Transaction transaction){
        super();
        this.transaction=transaction;
        this.nextNode=null;
    }

    public int getNode_id() {
        return node_id;
    }

    public void setNode_id(int node_id) {
        this.node_id = node_id;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }
    public String toString(){
        String out;
        out=getNode_id()+"\t"+getTransaction();
        return out;
    }

    public  void Display(){
        System.out.println(toString());
    }
}
