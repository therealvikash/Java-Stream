import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Practice {
    public static void main(String[] args) {
        List<String> languages = new ArrayList<>(
                Arrays.asList("Java", "Python", "Ruby", "Scala", "Java", "Java", "Python"));

        List<Employee> empList = new ArrayList<>();
        Employee employee1 = new Employee(1, "Suresh", 'M', "C", 1000.00, false);
        Employee employee2 = new Employee(2, "Ramesh", 'M', "P", 800.00, false);
        Employee employee3 = new Employee(3, "Geeta", 'F', "C", 1000.00, true);
        Employee employee4 = new Employee(4, "Priya", 'F', "P", 1500.00, true);
        Employee employee5 = new Employee(5, "Dharmesh", 'M', "C", 5000.00, true);
        Employee employee6 = new Employee(6, "Jignesh", 'M', "C", 10000.00, true);
        Employee employee7 = new Employee(7, "Divya", 'F', "P", 1000.00, true);

        empList.add(employee1);
        empList.add(employee2);
        empList.add(employee3);
        empList.add(employee4);
        empList.add(employee5);
        empList.add(employee6);
        empList.add(employee7);

        printCountOfLangs(languages);
        printAllEmployees(empList);
        employeesCountBasedOnGender(empList);
        employeesNameBasedOnGender(empList);
        avgSalaryBasedOnGender(empList);
        employeesListThatNeedsCab(empList);
        contractualEmployeeObjSalaryHike(empList);
        contractualEmployeesNameWithSalaryHike(empList);
    }

    private static void printCountOfLangs(List<String> languages) {
        Map<String, Integer> langCnt1 = languages.stream()
                .collect(Collectors.groupingBy(l -> l, Collectors.reducing(0, l -> 1, Integer::sum)));
        Map<String, Long> langCnt = languages.stream().collect(Collectors.groupingBy(l -> l,
                Collectors.counting()));
        System.out.println("Printing count of languages using Collectors.counting().");
        langCnt.entrySet().stream().forEach(l -> System.out.println(l));
        System.out.println("***********************************************************");
        System.out.println("printing count of languages using Collectors.reducing(x, y, z).");
        langCnt1.entrySet().stream().forEach(l -> System.out.println(l));
    }

    private static void printAllEmployees(List<Employee> empList) {
        System.out.println("***********************************************************");
        System.out.println("Printing Employees Object.");
        empList.stream().forEach(System.out::println);
        System.out.println("***********************************************************");
    }

    private static void employeesCountBasedOnGender(List<Employee> empList) {
        Map<Character, Integer> employeeGroupingBasedOnGender = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.reducing(0, e -> 1, Integer::sum)));
        Map<Character, Long> employeeGroupingBasedOnGender1 = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        // employeeGroupingBasedOnGender.entrySet().stream().forEach(System.out::println);
        System.out.println("Printing Genders and their count using Collectors.counting().");
        for (Map.Entry<Character, Long> map : employeeGroupingBasedOnGender1.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
        System.out.println("***********************************************************");
        System.out.println("Printing Genders and their count using Collectors.reducing(x, y, z).");
        for (Map.Entry<Character, Integer> map : employeeGroupingBasedOnGender.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }

    private static void avgSalaryBasedOnGender(List<Employee> empList) {
        Map<Character, Double> employeeGroupingBasedOnGender = empList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        // employeeGroupingBasedOnGender.entrySet().stream().forEach(System.out::println);
        System.out.println("***********************************************************");
        System.out.println("Printing gender and their average salary.");
        for (Map.Entry<Character, Double> map : employeeGroupingBasedOnGender.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }

    private static void employeesNameBasedOnGender(List<Employee> empList) {
        Map<Character, List<String>> maps = empList.stream().collect(
                Collectors.groupingBy(Employee::getGender, Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("***********************************************************");
        System.out.println("Printing names of employee based on their gender.");
        for (Map.Entry<Character, List<String>> map : maps.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }
    }

    private static void employeesListThatNeedsCab(List<Employee> empList) {
        List<Employee> employeeObj = empList.stream().filter(e -> e.isCabRequired()).collect(Collectors.toList());
        List<String> employeeNames = empList.stream().filter(e -> e.isCabRequired()).map(e -> e.getName())
                .collect(Collectors.toList());
        System.out.println("***********************************************************");
        System.out.println("Printing Employee object who needs cab service.");
        employeeObj.stream().forEach(System.out::println);
        System.out.println("***********************************************************");
        System.out.println("Printing names of employees thet needs cab.");
        employeeNames.stream().forEach(System.out::println);
    }

    private static void contractualEmployeeObjSalaryHike(List<Employee> empList) {
        List<Employee> empL = empList.stream().filter(e -> "C".equalsIgnoreCase(e.getType())).map(e -> {
            double newSal = e.getSalary() + e.getSalary() * 0.1;
            e.setSalary(newSal);
            return e;
        }).collect(Collectors.toList());
        System.out.println("***********************************************************");
        System.out.println("Printing contractual employees object with 10% hike on thier respective salary.");
        empL.stream().forEach(System.out::println);
    }

    private static void contractualEmployeesNameWithSalaryHike(List<Employee> empList) {
        List<String> empL = empList.stream().filter(e -> "C".equalsIgnoreCase(e.getType()))
                .map(e -> e.getName() + " is a contracual employee whose salary is raised by 10% to INR "
                        + (e.getSalary()
                                + 0.1 * e.getSalary()))
                .collect(Collectors.toList());
        System.out.println("***********************************************************");
        System.out.println("Printing employees names with 10% hike on their respective salary.");
        empL.stream().forEach(System.out::println);
    }

}
