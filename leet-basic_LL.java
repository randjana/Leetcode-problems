class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() { 
        this.size = 0;
        this.head = null;
    }
    
    public int get(int index) {
        //System.out.println("Get..."+size);
        if (index < 0 || index >= size) return -1; // 0 1 2 3
        ListNode current = head;
        for (int i = 0;i < index;i++) {
            current = current.next;
        }
        return current.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            size++;
            return;
        }
        ListNode current = head;   //what if head/current is null?
        
        for (int i=0;i<size-1;i++) { //again - size could be zero and this will be -ve
            current = current.next;
        }
        current.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if (index <0 || index >size)
            return;
        if (index == 0) {
            addAtHead(val);
            size++;
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode prev = head;
        for (int i=0;i<index-1;i++) {  
            prev = prev.next;
        }
        newNode.next = prev.next;
        prev.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) return;
        if (index == 0) {
            head = head.next;
            size--;
            return;
        }
        ListNode prev = head;
        for (int i=0;i<index-1;i++) {
            prev = prev.next;
        }
        if (index == size-1) 
            prev.next = null;
        else {
            prev.next = prev.next.next;
        }
        size--;
    }

    public void printList() {
        ListNode current = head;
        System.out.println("Printing......");
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
