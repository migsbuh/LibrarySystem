
class DynamicArray{
  private int capacity = 1;
  private int size = 0;
  private String[] array;

  public DynamicArray(){
    array=new String[capacity];
  }

  public void add(String element){
    if (size == capacity){
      resize(2 * capacity);
    }
    array[size] = element;
    size++;
  }

  public void insert(int index, String element){
    if (index < 0  || index > size){
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
    if(size == capacity){
      resize(2 * capacity);
    }
    for (int i = size; i > index; i--) { // Shift elements to the right
      array[i] = array[i - 1];
    }
    array[index] = element;
    size++;
  }

  public String remove(int index){
    if(index < 0 || index > size){
      throw new IndexOutOfBoundsException("Index out of bounds");
    }
        return array[index];
  }
  public int getSize() {
    return size;
  }
  public boolean isEmpty(){
    return size ==0;
  }
  private void resize(int newCapacity){
    String[] newArray = new String[newCapacity];
    for(int i = 0;i<size;i++){
      newArray[i] = array[i];
    }
    array = newArray;
    capacity = newCapacity;
  
  }

}