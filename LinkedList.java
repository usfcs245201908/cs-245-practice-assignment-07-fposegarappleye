class LinkedList<T> implements List<T> {
  // Variables
  protected Node head;
  protected int size;

  // Constructors
  public LinkedList() {
    head = new Node();
    size = 0;
  }

  public LinkedList(Node inNode) {
    head = inNode;
    size = 1;
  }


  // Functions
  public void add(T item) {
    if(size == 0) {
      head = new Node(item);
      ++size;
    } else {
      if(head == null) {
        head = new Node(item);
        ++size;
      } else {
        Node last = new Node(item);
        Node prev = head;
        while(prev.getNext() != null) {
          prev = prev.getNext();
        }
        prev.setNext(last);
        ++size;
      }
    }
  }

  public int size() {
    return size;
  }


  public T get(int pos) {
    if(pos >= size) {
      return null;
    }
    Node<T> focus = head;             // NOTE: <T> cast avoids error
    for(int i = 0 ; i < pos ; i++) {
      focus = focus.getNext();
    }
    return focus.getData();
  }


	public void add(int pos, T item) {
    if(pos == 0) {
      Node node = new Node(item);
      node.setNext(head);
      head = node;
      ++size;
    } else {
      Node node = new Node(item);
      Node prev = head;
      // Iterate along until finding the position
      for(int i = 0 ; i < pos-1 ; i++) {
        prev = prev.getNext();
      }
      node.setNext(prev.getNext());
      prev.setNext(node);
      size++;

    }
  }



	public T remove(int pos) {
    // Check if position DNE
    if(pos < 0 || pos > size-1){
      return null;
    }
    if(pos == 0) {
      Node<T> node = head;
      head = head.getNext();
      size--;
      return node.getData();
    }

    Node<T> prev = head;
    for(int i = 0; i < pos-1; i++) {
      prev = prev.getNext();
    }

    Node<T> node = prev.getNext();
    prev.next = node.next;
    size--;
    return node.getData();
    /*
    if(pos == 0) {
      Node<T> node = head;       // Use 'node' to capture head value
      head = head.getNext(); // Overwrite head value with head's next
      --size;
      return node.getData();
    } else {
      // Keep to the node before the target
      Node prev = head;
      // Iterate along until finding the position
      for(int i = 0 ; i < pos ; i++) { // NOTE: Possible -1 after pos here
        prev = prev.getNext();
      }
      // Capture the focus item
      Node<T> node = prev.getNext();
      // Set prev.next to prev.next.next
      prev.setNext(prev.getNext().getNext());
      // Iterate size downward
      --size;
      // return the value
      return node.getData();
    }
  }



  */
  }

}
