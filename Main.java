package ticket;

import java.util.PriorityQueue;
import java.util.Comparator;

class Ticket {
    String name;
    int urgency;
    int arrivalOrder;

    Ticket(String name, int urgency, int arrivalOrder) {
        this.name = name;
        this.urgency = urgency;
        this.arrivalOrder = arrivalOrder;
    }
}

class TicketComparator implements Comparator<Ticket> {
    public int compare(Ticket a, Ticket b) {
        if (a.urgency != b.urgency) {
            return a.urgency - b.urgency;
        }
        return a.arrivalOrder - b.arrivalOrder;
    }
}

public class Main {
    public static void main(String[] args) {
        PriorityQueue<Ticket> queue =
            new PriorityQueue<Ticket>(new TicketComparator());

        queue.offer(new Ticket("Printer", 3, 1));
        queue.offer(new Ticket("Network", 1, 2));
        queue.offer(new Ticket("Login", 2, 3));

        while (!queue.isEmpty()) {
            Ticket ticket = queue.poll();
            System.out.println(ticket.name);
        }
    }
}

