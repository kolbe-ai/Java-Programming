import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static PatientDAO patientDAO = new PatientDAO();
    static DoctorDAO doctorDAO = new DoctorDAO();
    static AppointmentDAO appointmentDAO = new AppointmentDAO();
    static BillingDAO billingDAO = new BillingDAO();

    public static void main(String[] args) {

        int choice;
        do {
            System.out.println("\n===== HOSPITAL BOOKING SYSTEM =====");
            System.out.println("1. Add Patient");
            System.out.println("2. View All Patients");
            System.out.println("3. Add Doctor");
            System.out.println("4. View All Doctors");
            System.out.println("5. Book Appointment");
            System.out.println("6. View All Appointments");
            System.out.println("7. Cancel Appointment");
            System.out.println("8. Generate Bill");
            System.out.println("9. View All Bills");
            System.out.println("10. Mark Bill as Paid");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> viewPatients();
                case 3 -> addDoctor();
                case 4 -> viewDoctors();
                case 5 -> bookAppointment();
                case 6 -> viewAppointments();
                case 7 -> cancelAppointment();
                case 8 -> generateBill();
                case 9 -> viewBills();
                case 10 -> markBillPaid();
                case 0 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid choice, try again.");
            }
        } while (choice != 0);

        sc.close();
    }

    static void addPatient() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Age: ");
        int age = Integer.parseInt(sc.nextLine());
        System.out.print("Gender: ");
        String gender = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();

        patientDAO.addPatient(name, age, gender, phone, address);
    }

    static void viewPatients() {
        List<String> patients = patientDAO.getAllPatients();
        System.out.println("\n--- Patients ---");
        patients.forEach(System.out::println);
    }

    static void addDoctor() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Specialization: ");
        String spec = sc.nextLine();
        System.out.print("Phone: ");
        String phone = sc.nextLine();
        System.out.print("Department ID: ");
        int deptId = Integer.parseInt(sc.nextLine());

        doctorDAO.addDoctor(name, spec, phone, deptId);
    }

    static void viewDoctors() {
        List<String> doctors = doctorDAO.getAllDoctors();
        System.out.println("\n--- Doctors ---");
        doctors.forEach(System.out::println);
    }

    static void bookAppointment() {
        System.out.print("Patient ID: ");
        int patientId = Integer.parseInt(sc.nextLine());
        System.out.print("Doctor ID: ");
        int doctorId = Integer.parseInt(sc.nextLine());
        System.out.print("Room ID: ");
        int roomId = Integer.parseInt(sc.nextLine());
        System.out.print("Date (yyyy-MM-dd): ");
        String date = sc.nextLine();
        System.out.print("Time (HH:mm): ");
        String time = sc.nextLine();

        appointmentDAO.bookAppointment(patientId, doctorId, roomId, date, time);
    }

    static void viewAppointments() {
        List<String> appointments = appointmentDAO.getAllAppointments();
        System.out.println("\n--- Appointments ---");
        appointments.forEach(System.out::println);
    }

    static void cancelAppointment() {
        System.out.print("Appointment ID to cancel: ");
        int id = Integer.parseInt(sc.nextLine());
        appointmentDAO.updateStatus(id, "Cancelled");
    }

    static void generateBill() {
        System.out.print("Appointment ID: ");
        int apptId = Integer.parseInt(sc.nextLine());
        System.out.print("Consultation Fee: ");
        double consult = Double.parseDouble(sc.nextLine());
        System.out.print("Room Charge: ");
        double room = Double.parseDouble(sc.nextLine());
        System.out.print("Other Charges: ");
        double other = Double.parseDouble(sc.nextLine());

        billingDAO.addBill(apptId, consult, room, other);
    }

    static void viewBills() {
        List<String> bills = billingDAO.getAllBills();
        System.out.println("\n--- Bills ---");
        bills.forEach(System.out::println);
    }

    static void markBillPaid() {
        System.out.print("Bill ID to mark as paid: ");
        int id = Integer.parseInt(sc.nextLine());
        billingDAO.markAsPaid(id);
    }
}
