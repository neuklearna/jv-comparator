package core.basesyntax;

import java.util.*;

public class EmployeeService {
    public Set<Employee> getEmployByOrder(List<Employee> employees) {

        Comparator<Employee> employeeComparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                int sortByAge = Integer.compare(o1.getAge(), o2.getAge());
                if (sortByAge != 0) return sortByAge;

                int sortByName = o1.getName().compareTo(o2.getName());
                if (sortByName != 0) return sortByName;

                int sortBySex = o1.getSex().compareTo(o2.getSex());
                if (sortBySex != 0) return sortBySex;

                return o1.getPhoneNumber().compareToIgnoreCase(o2.getPhoneNumber());
            }
        };

        Set<Employee> employeeSet = new TreeSet<>(employeeComparator);
        for (Employee employee : employees) {
            employeeSet.add(employee);
        }
        return employeeSet;
    }
}
