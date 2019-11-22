package blockchain;

public class LinkList {
    private int linkListId;
    private Node head;

    public LinkList(){
        linkListId=0;
        head=null;
    }

    public int getLinkListId() {
        return linkListId;
    }

    public void setLinkListId(int linkListId) {
        this.linkListId = linkListId;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void addToList(Node newNode){
        if(isEmpty()){
            head=newNode;
        }else{
            Node temp=head;
            while (temp.getNextNode()!=null){
                temp=temp.getNextNode();
            }
            temp.setNextNode(newNode);
        }
    }
    public int count(){
        int numOfTransaction=0;
        if(isEmpty()){
            return 0;
        }
        Node temp=head;
        while(temp!=null) {
            numOfTransaction++;
            temp=temp.getNextNode();
            if(numOfTransaction==3){
                break;
            }
        }
        return  numOfTransaction;
    }
    public void checksizeoflist(){
        if(count()!=3){
            System.out.println(count());
        }else{
            System.out.println("Cannot store any more nodes");
        }
    }
    public void validation(LinkList obj){
        if(obj.isEmpty()){
            return;
        }else {
            Node swtich=obj.getHead();
            while (swtich.getNextNode()!=null){
                if(obj.getHead().getTransaction().getReceiver().equals("")||obj.getHead().getTransaction().getSender().equals(""));

            }
        }
        return ;
    }


}
