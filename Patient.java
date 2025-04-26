public class Patient {
    private int id;
    private String name;
    private String CNIC;

    Patient(){
        this.id = 0;
        this.name = "Unknown";
        this.CNIC = "00000-0000000-0";
    }

    Patient(int id, String name, String CNIC){
        this.CNIC = CNIC;
        this.name = name;
        this.id = id;
    }

    void setId(int id){
        this.id = id;
    }

    void setName(String name){
        this.name = name;
    }

    void setCNIC(String CNIC){
        this.CNIC = CNIC;
    }

    int getId(){
        return id;
    }

    String getName(){
        return name;
    }

    String getCNIC(){
        return CNIC;
    }

    @Override

    public String toString(){
        return "ID: " + id +  "Name: " + name + "CNIC" + CNIC;
    }
}
