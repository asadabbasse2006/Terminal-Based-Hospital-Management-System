import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner asad = new Scanner(System.in);
        DoctorDAO doctorDAO = new DoctorDAO();
        StaffDAO staffDAO = new StaffDAO();
        PatientDAO patientDAO = new PatientDAO();
        int choice;
        do {
            System.out.println("========== Hospital Management System ==========");
            System.out.println("1. Doctors");
            System.out.println("2. Patients");
            System.out.println("3. Staff");
            System.out.print("Choice: ");
            choice = asad.nextInt();
            switch (choice){
                case 1:
                    int choice1;
                    do {
                        System.out.println("========== Doctors ==========");
                        System.out.println("1. Add Doctors");
                        System.out.println("2. View Doctors");
                        System.out.println("3. Update Doctors");
                        System.out.println("4. Search Doctors using id");
                        System.out.println("5. Delete Doctors");
                        System.out.println("6. Exit");
                        System.out.print("Enter your choice: ");
                        choice1 = asad.nextInt();
                        switch (choice1){
                            case 1:
                                System.out.println("ID: ");
                                int id = asad.nextInt();
                                System.out.println("Name: ");
                                String name = asad.next();
                                Doctor doctor = new Doctor(id,name);
                                doctorDAO.addDoctor(doctor);
                                System.out.println("Doctor Added Successfully");
                                break;
                            case 2:
                               DoctorDAO.viewAllDoctor();
                                break;
                            case 3:
                                System.out.println("Enter ID: ");
                                int id1 = asad.nextInt();
                                System.out.println("Enter name: ");
                                String name1 = asad.next();
                                Doctor doctor1 = new Doctor(id1,name1);
                                doctorDAO.updateDoctor(doctor1);
                                System.out.println("Doctor updated Successfully");
                                break;
                            case 4:
                                System.out.println("Enter id: ");
                                int id2 = asad.nextInt();
                                doctorDAO.searchDoctor(id2);
                                break;
                            case 5:
                                System.out.println("Enter id:");
                                int id3 = asad.nextInt();
                                doctorDAO.deleteDoctor(id3);
                            case 6:
                                System.out.println("Exiting.....");
                                break;
                        }

                    }
                    while(choice != 6);
                    break;
                case 2:
                    int choice2;
                    do {
                        System.out.println("========== Patient ==========");
                        System.out.println("1. Add Patient");
                        System.out.println("2. View All Patients");
                        System.out.println("3. Update Patient");
                        System.out.println("4. Search Patient using ID");
                        System.out.println("5. Delete Patient");
                        System.out.println("6. Exit");
                        System.out.print("Enter your choice: ");
                        choice2 = asad.nextInt();
                        switch (choice2){
                            case 1:
                                System.out.println("ID: ");
                                int id = asad.nextInt();
                                System.out.println("Name: ");
                                String name = asad.next();
                                System.out.println("CNIC: ");
                                String CNIC = asad.next();
                                Patient patient = new Patient(id,name,CNIC);
                                patientDAO.addPatient(patient);
                                System.out.println("Patient Added Successfully");
                                break;
                            case 2:
                                patientDAO.viewAllPatient();
                                break;
                            case 3:
                                System.out.println("Enter ID to update: ");
                                int id1 = asad.nextInt();
                                System.out.println("Enter name: ");
                                String name1 = asad.next();
                                System.out.println("Enter CNIC: ");
                                String CNIC1 = asad.next();
                                Patient patient1 = new Patient(id1,name1,CNIC1);
                                patientDAO.updatePatient(patient1);
                                System.out.println("Patient Updated Successfully");
                                break;
                            case 4:
                                System.out.println("Enter id to find: ");
                                int id2 = asad.nextInt();
                                patientDAO.searchPatientById(id2);
                                break;
                            case 5:
                                System.out.println("Enter id to find: ");
                                int id3 = asad.nextInt();
                                patientDAO.deletePatient(id3);
                                break;
                            case 6:
                                System.out.println("Exiting.......");
                                break;
                        }
                    }
                    while (choice2 != 6);
                    break;
                case 3:
                    int choice3;
                    do {
                        System.out.println("=========== Staff ==========");
                        System.out.println("1. Add Staff");
                        System.out.println("2. View All Staff");
                        System.out.println("3. Update Staff");
                        System.out.println("4. Search Staff using ID");
                        System.out.println("5. Delete Staff");
                        System.out.println("6. Exit");
                        System.out.print("Enter your choice: ");
                        choice3 = asad.nextInt();
                        switch (choice3){
                            case 1:
                                System.out.println("Enter ID: ");
                                int id = asad.nextInt();
                                System.out.println("Enter name: ");
                                String name = asad.next();
                                System.out.println("Enter shift: ");
                                String shift = asad.next();
                                Staff staff = new Staff(id,name,shift);
                                staffDAO.addStaff(staff);
                                System.out.println("Staff Added Successfully");
                                break;
                            case 2:
                                staffDAO.viewAllStaff();
                                break;
                            case 3:
                                System.out.println("Enter id to update: ");
                                int id1 = asad.nextInt();
                                System.out.println("Enter name: ");
                                String name1 = asad.next();
                                System.out.println("Enter shift: ");
                                String shift1 = asad.next();
                                Staff staff1 = new Staff(id1,name1,shift1);
                                staffDAO.updateStaff(staff1);
                                break;
                            case 4:
                                System.out.println("Enter id to find: ");
                                int id2 = asad.nextInt();
                                staffDAO.searchStaffById(id2);
                                break;
                            case 5:
                                System.out.println("Enter id to delete: ");
                                int id3 = asad.nextInt();
                                staffDAO.deleteStaff(id3);
                                break;
                            case 6:
                                System.out.println("Exiting.......");
                                break;
                        }
                    }
                    while (choice3 != 6);
            }
        }
        while (choice != 3);
    }
}
