//5️⃣ Hospital Patient Management
//Classes:
//•	Patient
//•	Doctor
//•	Appointment
//Doctor has:
//•	specialization
//•	consult(Patient)
//Appointment:
//•	Creates a link between (Patient, Doctor, date/time)
//Task:
//Use association + encapsulation to show a doctor consulting a patient.

class Patient {
    private String name;
    private int age;
    Patient(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
class Doctor {
    private String name;
    private String specialization;
    Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
    }
    public String getName() {
        return name;
    }
    public String getSpecialization() {
        return specialization;
    }
    public void consult (Patient patient) {
        System.out.println("Dr. "+name+"(Specialist: "+specialization+")"+"is Consultiong a Patient "+patient.getName());
    }
}
class Appointment{
    private Patient patient;  // Association (HAS-A)
    private Doctor doctor;     // Association (HAS-A)
    private String dateTime;

    Appointment(Patient patient, Doctor doctor, String dateTime){
        this.patient = patient;
        this.doctor = doctor;
        this.dateTime = dateTime;
    }
    public void showAppointmentDetails() {
        System.out.println("=====Appointment Details========");
        System.out.println("Patient Name: "+patient.getName());
        System.out.println("Doctor Name Dr. : "+doctor.getName());
        System.out.println("Specialization: "+doctor.getSpecialization());
        System.out.println("Date&Time: "+dateTime);
    }
}
public class Main {
    public static void main(String[] args) {

        Patient p1 = new Patient("Arif", 30);
        Doctor d1 =  new Doctor("Nafeel", "Cardiologist");

        Appointment app = new Appointment(p1, d1, "29-1-2025 & 10:00 AM");
        app.showAppointmentDetails();

        System.out.println();

        d1.consult(p1);
    }
}