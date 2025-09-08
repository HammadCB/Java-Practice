package Projects;



import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;

// Car Class
class Car {
    private String plateNumber;
    private String ownerName;

    public Car(String plateNumber, String ownerName) {
        this.plateNumber = plateNumber;
        this.ownerName = ownerName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        return "Car[Plate=" + plateNumber + ", Owner=" + ownerName + "]";
    }
}

// Ticket Class
class Ticket {
    private Car car;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;
    private double fee;

    public Ticket(Car car) {
        this.car = car;
        this.entryTime = LocalDateTime.now();
        this.exitTime = null;
        this.fee = 0.0;
    }

    public Car getCar() {
        return car;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public double getFee() {
        return fee;
    }

    public void closeTicket() {
        this.exitTime = LocalDateTime.now();
        Duration duration = Duration.between(entryTime, exitTime);
        long minutes = duration.toMinutes();
        // Pricing logic: Rs.50 per hour (rounded up)
        fee = Math.ceil(minutes / 60.0) * 50;
    }

    @Override
    public String toString() {
        if (exitTime == null) {
            return "Ticket[Car=" + car + ", Entry=" + entryTime + ", Status=Active]";
        }
        return "Ticket[Car=" + car + ", Entry=" + entryTime + ", Exit=" + exitTime + ", Fee=Rs." + fee + "]";
    }
}

// Parking Lot Class
class ParkingLot {
    private ArrayList<Ticket> activeTickets;
    private ArrayList<Ticket> history;
    private int capacity;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        activeTickets = new ArrayList<>();
        history = new ArrayList<>();
    }

    public void parkCar(Car car) {
        if (activeTickets.size() >= capacity) {
            System.out.println("❌ Parking Lot FULL! Cannot park " + car.getPlateNumber());
            return;
        }
        // check if already parked
        for (Ticket t : activeTickets) {
            if (t.getCar().getPlateNumber().equalsIgnoreCase(car.getPlateNumber())) {
                System.out.println("⚠️ Car already parked: " + car.getPlateNumber());
                return;
            }
        }
        Ticket ticket = new Ticket(car);
        activeTickets.add(ticket);
        System.out.println("✅ Car parked successfully. Ticket issued:\n" + ticket);
    }

    public void removeCar(String plateNumber) {
        for (int i = 0; i < activeTickets.size(); i++) {
            Ticket t = activeTickets.get(i);
            if (t.getCar().getPlateNumber().equalsIgnoreCase(plateNumber)) {
                t.closeTicket();
                activeTickets.remove(i);
                history.add(t);
                System.out.println("🚗 Car exited. Receipt:\n" + t);
                return;
            }
        }
        System.out.println("❌ Car not found in lot!");
    }

    public void showActiveCars() {
        if (activeTickets.isEmpty()) {
            System.out.println("🅿️ No cars parked right now.");
            return;
        }
        System.out.println("=== Active Parked Cars ===");
        for (Ticket t : activeTickets) {
            System.out.println(t);
        }
    }

    public void showHistory() {
        if (history.isEmpty()) {
            System.out.println("📜 No history yet.");
            return;
        }
        System.out.println("=== Parking History ===");
        for (Ticket t : history) {
            System.out.println(t);
        }
    }

    public void searchCar(String plate) {
        for (Ticket t : activeTickets) {
            if (t.getCar().getPlateNumber().equalsIgnoreCase(plate)) {
                System.out.println("🔍 Car found: " + t);
                return;
            }
        }
        System.out.println("❌ Car with plate " + plate + " not currently parked.");
    }
}

// Main Class
public class ParkingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLot lot = new ParkingLot(5); // capacity 5

        while (true) {
            System.out.println("\n===== Parking Lot Menu =====");
            System.out.println("1. Park Car");
            System.out.println("2. Remove Car");
            System.out.println("3. Show Active Cars");
            System.out.println("4. Show Parking History");
            System.out.println("5. Search Car");
            System.out.println("6. Exit");
            System.out.print("👉 Choose option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Plate Number: ");
                    String plate = sc.nextLine();
                    System.out.print("Enter Owner Name: ");
                    String owner = sc.nextLine();
                    Car c = new Car(plate, owner);
                    lot.parkCar(c);
                    break;
                case 2:
                    System.out.print("Enter Plate Number to remove: ");
                    String p = sc.nextLine();
                    lot.removeCar(p);
                    break;
                case 3:
                    lot.showActiveCars();
                    break;
                case 4:
                    lot.showHistory();
                    break;
                case 5:
                    System.out.print("Enter Plate Number to search: ");
                    String searchPlate = sc.nextLine();
                    lot.searchCar(searchPlate);
                    break;
                case 6:
                    System.out.println("👋 Exiting Parking System...");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
