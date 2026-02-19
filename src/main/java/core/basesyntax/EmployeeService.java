package core.basesyntax;

import java.util.*;

public class EmployeeService {
    public Set<Employee> getEmployByOrder(List<Employee> employees) {

        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int sortByAge = Integer.compare(o1.getAge(), o2.getAge());
                if (sortByAge != 0) return sortByAge;
                return o1.getName().compareTo(o2.getName());
            }
        };

        Set<Employee> employeeSet = new TreeSet<>(employeeComparator);
        for (Employee employee : employees) {
            employeeSet.add(employee);
        }
        return employeeSet;
    }
}
