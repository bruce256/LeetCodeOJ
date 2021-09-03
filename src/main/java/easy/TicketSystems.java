package easy;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author LvSheng
 * @date 2021/9/3
 **/
public class TicketSystems {
    List<Integer>       cabins;
    List<List<Order>>   waitQueue;
    List<BitSet>        available;
    Map<Integer, Order> orderMap = new HashMap();

    public TicketSystems(List<Integer> cabins) {
        this.cabins    = cabins;
        this.available = new ArrayList<BitSet>();
        for (int i = 0; i < cabins.size(); i++) {
            BitSet bitset = new BitSet(cabins.get(i));
            bitset.set(0, cabins.get(i));

            available.add(bitset);
        }

        waitQueue = new ArrayList<>();
        for (int i = 0; i < cabins.size(); i++) {
            waitQueue.add(new ArrayList<>());
        }
    }

    public boolean Book(int id, int cabinId, int num) {
        Order order = new Order(id, cabinId, num);
        orderMap.put(id, order);
        BitSet      bitSet    = available.get(cabinId);
        List<Order> waitQueue = this.waitQueue.get(cabinId);
        if (waitQueue.isEmpty() && bitSet.cardinality() >= num) {
            for (int i = 0; i < num; i++) {
                int index = bitSet.nextSetBit(0);
                order.seatNums.add(index);
                bitSet.set(index, false);
            }

            return true;
        } else {
            waitQueue.add(order);
            return false;
        }
    }

    public boolean Cancel(int id) {
        Order order = orderMap.get(id);
        if (order == null) {
            return false;
        }
        if (order != null && order.seatNums.size() > 0) {
            BitSet bitSet = available.get(order.cabinId);
            for (Integer seatNum : order.seatNums) {
                bitSet.set(seatNum, true);
            }
            orderMap.remove(id);

            handleWaitQueue(order, bitSet);
            return true;
        }

        List<Order> orderQueue = waitQueue.get(order.cabinId);
        for (int i = 0; i < orderQueue.size(); i++) {
            Order order1 = orderQueue.get(i);
            BitSet bitSet = available.get(order.cabinId);
            if (order1.id == id) {
                orderQueue.remove(order1);
                orderMap.remove(id);

                handleWaitQueue(order, bitSet);
                return true;
            }
        }

        return false;
    }

    private void handleWaitQueue(Order order, BitSet bitSet) {
        List<Order> orderQueue = waitQueue.get(order.cabinId);
        int         i          = 0;
        while (bitSet.cardinality() > 0 && orderQueue.size() > i) {
            Order o = orderQueue.get(i);
            if (o.num <= bitSet.cardinality()) {
                for (int idx = 0; idx < o.num; idx++) {
                    int index = bitSet.nextSetBit(0);
                    o.seatNums.add(index);
                    bitSet.set(index, false);
                }
                orderQueue.remove(i);
                continue;
            }
            i++;
        }
    }

    public int Query(int id) {
        Order order = orderMap.get(id);
        if (order == null) {
            return -1;
        }

        if (!order.seatNums.isEmpty()) {
            return order.seatNums.get(0);
        }

        return -1;
    }

    public static void main(String[] args) {
/*        List list = new ArrayList();
        list.add(6);
        list.add(5);
        TicketSystems ts = new TicketSystems(list);
        System.out.println(ts.Book(10, 1, 3));
        System.out.println(ts.Query(10));
        System.out.println(ts.Cancel(10));
        System.out.println(ts.Cancel(20));*/

        List list = new ArrayList();
        list.add(10);
        list.add(1);
        TicketSystems ts = new TicketSystems(list);
        System.out.println(ts.Book(71, 0, 2));
        System.out.println(ts.Book(73, 0, 10));
        System.out.println(ts.Book(72, 0, 2));
        System.out.println(ts.Query(72));
        System.out.println(ts.Book(74, 0, 2));
        System.out.println(ts.Cancel(73));
        System.out.println(ts.Query(74));
        System.out.println(ts.Query(72));
        System.out.println(ts.Cancel(72));
        System.out.println(ts.Book(75, 0, 3));
        System.out.println(ts.Query(75));
        System.out.println(ts.Cancel(75));
        System.out.println(ts.Book(76,0,2));
        System.out.println(ts.Book(77,0,2));
        System.out.println(ts.Cancel(76));
        System.out.println(ts.Book(78,0,3));
        System.out.println(ts.Query(78));
    }
}


class Order {
    int           id;
    int           cabinId;
    int           num;
    List<Integer> seatNums = new ArrayList<>();

    public Order(int id, int cabinId, int num) {
        this.id      = id;
        this.cabinId = cabinId;
        this.num     = num;
    }
}