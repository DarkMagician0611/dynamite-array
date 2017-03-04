import java.lang.*;
class myQueueUsingDynamicArray{

    private dynamicArray A;
    //Other variables to be defined by student
    int head, tail;
    
    public myQueueUsingDynamicArray(){
        A = new dynamicArray();
        //Othe initializations to be done by student
        head = tail = -1;
    }
    
    //This method should return the number of elements in the queue
    public int getSize(){
        //To be written by student
        if(head == -1)
            return 0;
        if(head > tail){
            return A.getSize() - head + tail + 1;
        }
        return tail - head + 1;
    }
    
    //This should implement the enqueue operation of Queue
    public void enqueue(int value){
        //To be written by student
        if(getSize() + 1 > A.getSize()){
            rearrange();
            A.doubleSize();
        }
        if(++tail == A.getSize())
            tail = 0;
        A.modifyElement(value, tail);
        if(head == -1)
            head = 0;
    }
    //This should implement the dequeue operation of Queue
    //This method should throw an exception in case the queue is empty.
    public int dequeue() throws ArrayIndexOutOfBoundsException{
        //To be written by student
        if(getSize() == 0){
            return -1;
        }
        else if(getSize() == 1){
            head = tail = -1;
            return A.getElement(0);
        }
        int n = A.getElement(head++);
        if(getSize() == A.getSize() / 2){
            rearrange();
            A.halveSize();
        }
        return n;
    }

    public void rearrange(){
        int i = head, count = getSize(), j = 0;
        int n = count - 1;
        if(head == 0)
            return;
        int[] B = new int[getSize()];
        while(count > 0){
            if(i == A.getSize())
                i = 0;
            B[j++] = A.getElement(i++);
            count--;
        }
        for(i = 0;i < getSize();i++)
            A.modifyElement(B[i], i);
        head = 0;
        tail = n;
    }

    public void printArray(){
        int i = 0;
        while(i < A.getSize()){
            System.out.print(A.getElement(i) + " ");
            i++;
        }
        System.out.println();
    }
}