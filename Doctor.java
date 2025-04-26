public class Doctor {
    private int id;
    private String name;

    Doctor(){
        this.id = 0;
        this.name = "Unknown";
    }

    Doctor(int id,String name){
        this.name = name;
        this.id = id;
    }

    void setId(int id){
        this.id = id;
    }

    void setName(String name){
        this.name = name;
    }

    int getId(){
        return id;
    }

    String getName(){
        return name;
    }

    public String toString(){
        return "ID: " + id + "Name: " + name;
    }
}
