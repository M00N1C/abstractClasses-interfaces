public class FulltimeEmployee extends Employee {
    private double salary;
    public FulltimeEmployee(String name, int id, double salary) {
        super(name, id);
        this.salary = salary;
    }

    @Override
    public double getSalary() {
        return salary;
    }
}
