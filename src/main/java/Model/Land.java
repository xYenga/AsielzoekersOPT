package Model;

public class Land{
    private String name;
    private boolean veilig;

    //constructor
    public Land(String name, boolean safe){
        this.name=name;
        this.veilig=safe;
    }

    //methods


    //getters en setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVeilig(boolean safe) {
        this.veilig = safe;
    }

    public boolean isVeilig() {
        return veilig;
    }

}
