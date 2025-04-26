public class Staff {
    private int id;
    private String name;
    private String time;

    Staff(){
        this.id = 0;
        this.name = "Unknown";
        this.time = "Morning";
    }

    Staff(int id,String name,String time){
        this.id = id;
        this.name = name;
        this.time = time;
    }

    void setId(int id){
        this.id = id;
    }

    void setName(String name){
        this.name = name;
    }

    void setTime(String time){
        this.time = time;
    }

    int getId(){
        return id;
    }

    String getName(){
        return name;
    }

    String getTime(){
        return time;
    }

    @Override

    public String toString(){
        return "ID: " + id + "Name: " + name + "Duty Shift: " + time;
    }
}
