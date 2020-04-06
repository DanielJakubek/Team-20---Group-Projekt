public class List {
 private ListNode head;
 
 public List()
 {
	 head = null;
 }
 
 public ListNode getHead()
 {
	 return head;
 }
 
 public void setHead(ListNode newHead)
 {
	 this.head = newHead;
 }
 
 public void addToList(UndoableCommand newCommand)
 {
	 ListNode newNode = new ListNode(newCommand);
	 newNode.setNext(head);
	 head = newNode;
 }
 
 public void deleteFromList(int position)
 {
	 if(head == null) {
		 return;
	 }
	 
	 ListNode temp = head;
	 
	 if(position == 0)
	 {
		 head = temp.getNext();
		 return;
	 }
	 
	 for(int i=0; (temp != null) && (i < position-1); i++)
		 temp = temp.getNext();
	 
	 if(temp == null || temp.getNext() == null)
		 return;
	 
	 ListNode nextNode = temp.getNext().getNext();
	 temp = temp.getNext();
	 temp = nextNode;
 }
}