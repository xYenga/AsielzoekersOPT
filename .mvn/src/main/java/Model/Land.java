package Model;

public class Land{
    private String name;
    private boolean veilig;

    public Land(String name, boolean safe){
        this.name=name;
        this.veilig=safe;
    }
    public Land(String land){
        this.name = land;
    }

    public String getName() {
        return name;
    }
}
