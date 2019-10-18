public class Node<T> {
  // Variables
  public T data;
  public Node next;

  // Constructors
  public Node() {
    data = null;
    next = null;
  }

  public Node(T inData) {
    data = inData;
    next = null;
  }

  public Node(T inData, Node inNext) {
    data = inData;
    next = inNext;
  }



  // Functions
  public T getData() {
    return data;
  }

  public void setData(T inData) {
    data = inData;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node inNext) {
    next = inNext;
  }
}
