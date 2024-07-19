public class Employee {
    private int id;
    private String name;
    private char gender;
    private String type;
    private double salary;
    private boolean isCabRequired;

    public Employee(int id, String name, char gender, String type, double salary, boolean isCabRequired) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.type = type;
        this.salary = salary;
        this.isCabRequired = isCabRequired;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isCabRequired() {
        return isCabRequired;
    }

    public void setCabRequired(boolean isCabRequired) {
        this.isCabRequired = isCabRequired;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", gender=" + gender + ", type=" + type + ", salary=" + salary
                + ", isCabRequired=" + isCabRequired + "]";
    }

}