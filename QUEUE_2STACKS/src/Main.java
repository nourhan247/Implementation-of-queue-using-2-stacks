//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Q2S q=new Q2S(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        System.out.println("*******");
        q.dequeue();
        q.display();
    }
}
class Q2S{
    int top1 ,top2;
    int count;
    int stack1[];
    int stack2[];
    int size;
    Q2S(int size){
        this.size=size;
        stack1=new int[size];
        stack2=new int[size];
        top1=top2=-1;
        count=0;
    }
    public void push1(int d){
        if(top1==size-1){
            System.out.println("Stack Overflow");
            return;
        }
        stack1[++top1]=d;
    }
    public void push2(int d){
        if(top2==size-1){
            System.out.println("Stack Overflow");
            return;
        }
        stack2[++top2]=d;
    }

    public void enqueue(int data){ //o(1)
        push1(data);
        count++;
    }
    public int pop1(){
        return stack1[top1--];
    }
    public int pop2(){
        return stack2[top2--];
    }


    public void dequeue(){ //o(n)

        if(top1==-1 && top2==-1){
            System.out.println("Stack Underflow");
            return;
        }
        for(int i=0;i<count;i++){
            int a=pop1();
            push2(a);
        }
        int b=pop2();
        System.out.println("Dequeued Element is: "+b);
        count--;
        for(int i=0;i<count;i++){
            int a=pop2();
            push1(a);
        }
    }
    public void display(){
        System.out.println("ELements are: ");
        for(int i=0;i<=top1;i++){  //or for(int i=0;i<=top1;i++)
            System.out.println(stack1[i]);

        }
    }

}