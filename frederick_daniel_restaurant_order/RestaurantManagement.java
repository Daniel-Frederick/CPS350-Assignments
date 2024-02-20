package frederick_daniel_restaurant_order;

public class RestaurantManagement {
    
    public static void main(String[] args) {
        // SOP: how many order are you making?

        ArrayQueue orderQueue = new ArrayQueue(10);
        OrderStack processedOrderStack = new OrderStack(10);

        Order order1 = new Order(1, "Burger and Fries");
        Order order2 = new Order(2, "Pizza");

        order1.orderQueuing(order1, orderQueue);
        order2.orderQueuing(order2, orderQueue);

        order1.orderProcessing(order1, orderQueue, processedOrderStack);    
        order2.orderProcessing(order2, orderQueue, processedOrderStack);    


    }

}
