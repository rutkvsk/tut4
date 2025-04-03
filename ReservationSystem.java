import java.util.ArrayList;

public class ReservationSystem {
    private ArrayList<Event> events;
    private ArrayList<Customer> customers;

    public ReservationSystem() {
        this.events = new ArrayList<>();
        this.customers = new ArrayList<>();
    }


    public void addEvent(Event event) {
        events.add(event);
    }

    public void addEvent(String name, double price) {
        events.add(new Event(name, price));
    }


    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addCustomer(String firstName, String lastName, String email) {
        customers.add(new Customer(firstName, lastName, email));
    }


    public Event findEvent(String name) {
        for (Event event : events) {
            if (event.getName().equals(name)) {
                return event;
            }
        }
        return null;
    }


    public Customer findCustomer(String lastName) {
        for (Customer customer : customers) {
            if (customer.getLastName().equals(lastName)) {
                return customer;
            }
        }
        return null;
    }


    public void makeReservation(Customer customer, Event event) {
        if (event.reserveSeat()) {
            customer.addReservation(event);
            System.out.println("Reservation made for event: " + event.getName());
        } else {
            System.out.println("No available seats for event: " + event.getName());
        }
    }


    public void changeEventPrice(String name, double newPrice) {
        Event event = findEvent(name);
        if (event != null) {
            event.setPrice(newPrice);
        } else {
            System.out.println("Event not found.");
        }
    }
}

