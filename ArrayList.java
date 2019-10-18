class ArrayList<T> implements List<T> {
  // Variables
  protected T[] a;
  protected int size;

  // Constructors
  public ArrayList() {
    a = (T[]) new Object[10];
    size = 0;
  }


  // Function
  public void add(T item) {
    if(size == a.length) {
      grow_array();
    }
    a[size++] = item;
  }

	public void add(int pos, T item) {
    // If the size limit has been reached, grow the array to fit the data
    if(size == a.length) { // NOTE: This may need a.length-1, probably not
      grow_array();
    }
    for(int i = size-1; i > pos ; i--) {
      a[i+1] = a[i];
    }
    a[pos] = item;
    ++size;
  }

	public T get(int pos) {
    return a[pos];
  }

	public T remove(int pos) {
    T temp = a[pos];
    for(int i = pos; i < size - 1 ; i++) {
      a[i] = a[i+1];
    }
    --size;
    return temp;
  }

	public int size() {
    return size;
  }

  private void grow_array() {
    // Create a new generic array of twice the size
    T[] new_a = (T[]) new Object[a.length*2];
    // Copy the values over
		System.arraycopy(a, 0, new_a, 0, a.length);
    // Set the 'a' pointer to the 'new_a' pointer
    a = new_a;
  }
}
