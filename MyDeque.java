
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 10;
    start = 0;
    end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = initialCapacity;
    start = 0;
    end = 0;
  }

  public int size(){
    return size;
   }

  public String toString(){
    if(size == 0){
      return "{}";
    }

    if(size == 1){
      return "{" + data[start] + " }";
    }
    String ans = "{";
    if(start < end){
      for(int i = start; i < end; i++){
        ans += data[i] + " ";
      }
      return ans + " ";
    } else {
      for(int i = start; i < size; i++){
        ans += data[i] + " ";
      }
      for(int i = 0; i < end; i++){
        ans += data[i] + " ";
      }
      return ans + "}";
    }
  }

  private boolean isFull(){
    for(int i = 0; i < size; i++){
      if(data[i] == null){
        return false;
      }
    }
    return true;
  }


  public void addFirst(E element){
    if(isFull){
      resize();
      //resize always sets start to 0
      start = data.length - 1;
      data start = element;
    } else {
      start--;
      if(start > 0){
      data[start] = element;
    } else {
      start += data.length;
      data[start] = element;
    }
    }
  }


  public void addLast(E element){
    if(isFull){
      resize();
      end ++;
      data[end] = element;
    } else {
      if(end == data.length - 1){
        end = 0;
        data[end] = element;
      } else {
        end++;
        data[end] = element;
      }
    }
  }

  @SuppressWarnings("unchecked")
  public E removeFirst(){
    errorIfEmpty();
       int elementIndex = getQueueIndex();
       E objectRetrieved = (E) data[elementIndex];
       // Make the element at the index null so there isn't a memory leak
       data[elementIndex] = null;
       startIndex = elementIndex;
       size--;
       return objectRetrieved;
 }


  public E removeLast(){
    errorIfEmpty();
        int elementIndex = getStackIndex();
        @SuppressWarnings("unchecked")
        T objectRetrieved = (T) data[elementIndex];
        // Make the element at the index null so there isn't a memory leak
        data[elementIndex] = null;
        endIndex = elementIndex;
        size--;
        return objectRetrieved;
  }


  public E getFirst(){
    errorIfEmpty();
       return (E) data[start];
  }





  public E getLast(){
    errorIfEmpty();
    return (E) data[start];
  }



  @SuppressWarnings("unchecked")
  private void reSize(){
    //if size is 0 make it one
    if(size == 0){
      data = new(E[])new Object[1];
      start = 0;
      end = 0;
      return;
    }
    //make a copy array with double the size
    E[] dataCopy = new(E[])new Object[size];
    if(size == 1){
      dataCopy[start] = data[start]
      data = new(E[])new Object[size * 2];
      start = 0;
      end = 1;

      return;
    }

    //for new cases, copy data into dataCopy
    dataCopy = Arrays.copy(data);
    //Then clear data();
    data = new int[size *2];
    size = size * 2;
    //NOW see if end > start and such
    if(end > start){
      for(int i = start; i <= end; i++){
        data[i - start] = dataCopy[i];
      }
    } else {
      for(int i = start; i < dataCopy.length; i++){
          data[i - start] = dataCopy[i];
      }
      for(int i = 0; i <= end; i++){
        data[i + (data.length - start)] = dataCopy[i];
      }
    }
    start = 0;
    end = dataCopy.length - 1;
    //now redo start and end

    //copy all the starts into the beginning, then make the array in order again cuz y not

  }
    private void errorIfEmpty() {
    if (size == 0) {
        throw new NoSuchElementException();
    }
  }
}
