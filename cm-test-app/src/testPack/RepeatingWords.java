package testPack;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RepeatingWords {

    public static void main(String[] args) {
        System.out.println("hello");
/*

        List<Integer> list = new ArrayList<Integer>();
        list.add(2);
        list.add(1);
        list.add(6);
        list.add(5);
        list.add(5);
        list.add(5);
        List<Integer> even = list.stream().filter(n->n%2 ==0).collect(Collectors.toList());
        List<Integer> odd = list.stream().filter(n->n%2 !=0).collect(Collectors.toList());
        System.out.println(even);
        System.out.println(odd);
        Map<Integer, Long> countMap= list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));

        System.out.println(countMap);

        List<Employee> employeeList = new ArrayList<>();

        // unique firstname + lastname

        List<Employee> uniqueEmployee = employeeList.stream().collect(Collectors.toMap(emp ->emp.getFirstName()+ ""+emp.getLastname(),
                emp->emp,(existing,replacement)->existing)).values().stream().collect(Collectors.toList());

        List<Employee> uniqueeEmployee = employeeList.stream().collect(Collectors.toMap(emp ->emp.getFirstName()+ ""+emp.getLastname(),
                emp->emp,(existing,replacement)->existing)).values().stream().collect(Collectors.toList());

        employeeList.stream().map(e->e.getFirstName()).collect(Collectors.toList());
        employeeList.forEach(e->{
            e.setFirstName(e.getFirstName().toUpperCase());
        });

        Map<String,List<Employee>> empMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getFirstName));


        //highest age in each dept

        Map<String, Optional<Employee>> employeeMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept,
                Collectors.maxBy(Comparator.comparing(Employee::getAge))));

        Map<String, Long> employeedeptMapCount = employeeList.stream().collect(Collectors.groupingBy(Employee::getDept,Collectors.counting()));
*/

        // convert list of string to uppercase

        List<String> names = Arrays.asList("alice", "bob", "charlie", "ankita");
        names = names.stream().map(n -> n.toUpperCase()).collect(Collectors.toList());
        System.out.println(names);

        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> evens = nums.stream().filter(n -> n % 2 == 0).collect(Collectors.toList());
        System.out.println(evens);

        // find first element starting with a
        Optional<String> name = names.stream().filter(n -> n.startsWith("A")).findFirst();
        System.out.println(name.get());

        // flatten a list of lists
        List<String> a = new ArrayList<>();
        a.add("a");
        a.add("b");
        List<String> b = new ArrayList<>();
        b.add("c");
        b.add("d");
        List<List<String>> lists = new ArrayList<>();
        lists.add(a);
        lists.add(b);
        List<String> lmap = lists.stream().flatMap(n -> n.stream().map(l -> l)).collect(Collectors.toList());
        System.out.println(lmap);

        List<String> words = Arrays.asList(new String[]{"apple", "banana", "apple", "orange", "banana", "apple"});
        Map<String, Long> wordMapCount = words.stream().collect(Collectors.groupingBy(n -> n, Collectors.counting()));
        System.out.println(wordMapCount);

        // sort employee by salary

        List<Employee> employeeList = new ArrayList<>();
        Employee e1 = new Employee("Alice", "brown", 22, "sales", 1000);
        Employee e2 = new Employee("Bob", "smith", 23, "sales", 2000);
        Employee e3 = new Employee("Charlie", "parker", 28, "ceo", 7000);
        employeeList.add(e3);
        employeeList.add(e1);
        employeeList.add(e2);

        employeeList = employeeList.stream().sorted(Comparator.comparing(e -> e.getSalary(), Comparator.reverseOrder())).collect(Collectors.toList());
        employeeList.stream().forEach(e -> {
            System.out.println(e.getFirstName() + ", " + e.getSalary());
        });

        List<Integer> elements = Arrays.asList(new Integer[]{1, 2, 2, 3, 4, 4, 5});
        elements = elements.stream().distinct().collect(Collectors.toList());
        System.out.println(elements);

        int sum = elements.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        Map<Boolean, List<Integer>> multilist = elements.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println(multilist);

        List<String> joinList = Arrays.asList(new String[]{"apple", "banana", "orange"});
        String joined = joinList.stream().collect(Collectors.joining(","));
        System.out.println(joined);

        Map<String, List<Employee>> empMap = employeeList.stream().collect(Collectors.groupingBy(e -> e.getDept()));
        empMap.entrySet().forEach((k) -> {
            List<String> fnames = k.getValue().stream().map(e -> e.getFirstName()).collect(Collectors.toList());
            System.out.println(k.getKey() + ", " + fnames);
        });

        Optional<Employee> emp = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
        System.out.println(emp.get().getFirstName());

        List<String> countWords = Arrays.asList(new String[]{"banana", "apple", "kiwi", "strawberry"});
        Long cnt = countWords.stream().filter(w->w.length() > 5).count();
        System.out.println(cnt);

        List<Integer> dupElement = Arrays.asList(new Integer[] {1, 2, 3, 2, 4, 5, 1});
        List<Integer> resDupElement = dupElement.stream()
                .collect(Collectors.groupingBy(n->n,Collectors.counting()))
                .entrySet().stream()
                .filter(e->e.getValue() > 1)
                .map(e->e.getKey()).collect(Collectors.toList());
        System.out.println(resDupElement);

        List<Integer> topNum = Arrays.asList(new Integer[] {4, 1, 9, 7, 6, 3});

        List<Integer> restopNum = topNum.stream().sorted(Comparator.reverseOrder()).limit(3).collect(Collectors.toList());
        System.out.println(restopNum);

       Map<String,Integer> employeeMap = employeeList.stream().collect(Collectors.toMap(e -> e.getFirstName(),e->e.getAge()));
       employeeMap.entrySet().forEach(System.out::println);


       // Sort a Map by Value
       Map<String,Integer> mapval = new HashMap<>();
       mapval.put("A",5);
       mapval.put("B",3);
       mapval.put("C",8);
        LinkedHashMap<String, Integer> sortedMap = mapval.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (s1, s2) -> s1,
                        LinkedHashMap::new
                ));

        List<Employee> employeeList1 = new ArrayList<>();
        List<Employee> uniqueEmployee = employeeList1.stream()
                .collect(Collectors.toMap(
                        em ->em.getFirstName()+ ""+em.getLastname(),
                        em->em,
                        (existing,replacement)->existing))
                .values().stream().collect(Collectors.toList());

        List<Employee> uniqueeEmployee = employeeList1.stream().collect(Collectors.toMap(em ->em.getFirstName()+ ""+em.getLastname(),
                em->em,(existing,replacement)->existing)).values().stream().collect(Collectors.toList());

         List<Integer> list = new ArrayList<Integer>();
                list.add(2);
               list.add(1);
                list.add(6);
                list.add(5);
                list.add(5);
                list.add(5);
        List<Integer> list2 = new ArrayList<Integer>();
        list2.add(2);
        Map<Integer, Long> countMap= list.stream().collect(Collectors.groupingBy(n->n,Collectors.counting()));
        Map<Boolean,List<Integer>> oddeven = list.stream().collect(Collectors.partitioningBy(n->n%2 ==0));
        String str ="abdgte";
        str.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(n->n,Collectors.counting()));
        list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        list.stream().filter(n->n/5 ==0).collect(Collectors.toList());
        //IntStream.concat(list,list2).sorted().collect(Collectors.toList());
        List<String> list3 = new ArrayList<>();
        list3.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList());


    }

}
class Employee{
    String firstName;
    String lastname;
    Integer age;
    String dept;

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    Integer salary;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }



    Employee(String firstName, String lastName, Integer age, String dept, Integer salary){
        this.firstName = firstName;
        this.lastname = lastName;
        this.age = age;
        this.dept = dept;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
