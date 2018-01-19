public class 汉若塔 {
    static double d = 0;
    public static void move(int n,String A,String B,String C){

        //这个方法用于把n个盘子从A搬到C
        if (n==1){
            //当A上面的盘子只有一个时，直接从A搬到C
            System.out.println("把盘子从"+A+"搬到"+C+"----"+(++d));

        } else{
            //当A大于1时
            //先把A上面n-1个搬到B
            move(n-1,A,C,B);
            //再把剩下的一个搬到C
            move(1,A,B,C);
            //此时C上面是最大的一个，所有盘子都可以放在上面
            //因此可以看做C上面是空的
            //现在只需要把B上面的n-1个盘子搬到C上

            //只需把B看成A，A看成B，调用move方法，再搬n-1个盘子
            //每次-1，直到全搬到C上面
            move(n-1,B,A,C);
        }
    }

    public static void main(String[] args) {
        move(12,"A","B","C");
    }
}
