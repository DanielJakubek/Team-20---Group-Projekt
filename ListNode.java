public class ListNode {
 private UndoableCommand command;
 private ListNode next;
 
 public ListNode(UndoableCommand command)
 {
	 this.command = command;
	 this.next = null;
 }
 
 public UndoableCommand getCommand()
 {
	 return command;
 }
 
 public ListNode getNext()
 {
	 return next;
 }
 
 public void setNext(ListNode nextNode)
 {
	 this.next = nextNode;
 }
}