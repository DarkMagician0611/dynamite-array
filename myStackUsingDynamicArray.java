class myStackUsingDynamicArray{

    private dynamicArray A;
    private int top;
    //Other variables to be defined by student
    
    public myStackUsingDynamicArray(){
        A = new dynamicArray();
        //Othe initializations to be done by student
        top = -1;
    }
    
    //This method should return the size of the stack
    public int getSize(){
        //To be written by student
        return (top + 1);
    }
    
    //This should implement the push operation of stack
    public void push(int value){
        //To be written by student
        if(top + 2 > A.getSize())
            A.doubleSize();
        A.modifyElement(value, ++top); 
    }
    
    //This should implement the pop operation of stack.
    //This method should throw an exception in case the stack is empty.
    public int pop() throws ArrayIndexOutOfBoundsException{
        //To be written by student
        if(top == -1)
            return -1;
        int n = A.getElement(top--);
        if(top + 1 == A.getSize() / 2 && top != -1)
            A.halveSize();
        return n;
    }
}