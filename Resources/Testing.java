public class Testing {

    public static void main(String[] args) {
        Stacks bucket = new Stacks(4);

        System.out.println(bucket.isEmpty());
        bucket.push(1);
        System.out.println(bucket.size());

        bucket.push(2);
        System.out.println(bucket.size());

        bucket.push(3);
        System.out.println(bucket.size());
        System.out.println(bucket.peek());

        bucket.push(4);
        System.out.println(bucket.size());

        bucket.push(5);

        bucket.pop(); 

        bucket.push(5);  
        System.out.println(bucket.size());

        System.out.println(bucket.pop()+bucket.pop());
        System.out.println(bucket.pop());


        System.out.println(bucket.isEmpty());
    }

}