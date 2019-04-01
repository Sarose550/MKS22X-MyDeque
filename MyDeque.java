import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }
  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
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
      return ans + "}";
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

  @SuppressWarnings("unchecked")
  private void resize(){
    E[] extra = data;
    data = (E[])new Object[data.length + 10];
    int i = start;
    int j = 0;
    if(size != 0){
      if(end >= start){
        while(i <= end){
          data[j] = extra[i];
          i++;
          j++;
        }
      }
      else{
        while(end >= i){
          data[j]=extra[i];
          i++;
          j++;
          if(i == data.length) i = 0;
        }
      }
    }
  }


  public void addFirst(E element) throws NullPointerException{
    if(element == null) throw new NullPointerException("Cant' add a null element.");
    if(data.length == size)
      resize();
    size++;
    if(start == -1){
      start = 0;
      end = 0;
      data[0] = element;
    }
    else if(start == 0){ 
      data[start = data.length-1] = element;
    }
    else{
      data[--start] = element;
    }
  }


  public void addLast(E element) throws NoSuchElementException{
    if(element == null) throw new NullPointerException("Can't add a null element.");
    if(data.length == size) resize();
    size++;
    if(start == -1){
      start = 0;
      end = 0;
      data[0] = element;
    }
    else if(end == data.length - 1)
      data[end = 0] = element;
    else
      data[++end] = element;
  }


  public E removeFirst() throws NoSuchElementException{
    if(size == 0) throw new NoSuchElementException ("Can't remove from empty deque.");
    size--;
    if(start == end){
      int temp = start;
      start=-1;
      end=-1;
      return data[temp];
    }
    else if(start == data.length - 1){
      start = 0;
      return data[data.length - 1];
    }
    start++;
    return data[start - 1];
  }


  public E removeLast() throws NoSuchElementException{
    if(size ==0) throw new NoSuchElementException ("Can't remove from an empty deque.");
    size--;
    if(start == end){
      int temp = start;
      start =- 1;
      end =- 1;
      return data[temp];
    }
    else if(end == 0){
      end = data.length - 1;
      return data[0];
    }
    return data[end--];
  }


  public E getFirst() throws NoSuchElementException{
    if(size == 0) throw new NoSuchElementException("Can't get element of an empty deque.");
    return data[start];
  }


  public E getLast() throws NoSuchElementException{
    if(size == 0) throw new NoSuchElementException("Can't get element of an empty deque.");
    return data[end];
  }
}
