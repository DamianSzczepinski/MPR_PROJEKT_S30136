package pl.edu.pjatk.MPR_projekt_s30136.model;

public class Monkey {
    private String name;
    private String color;

    public Monkey(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getColor() {
        return color;

    }
    public void setColor(String color) {
        this.color = color;
    }
}
