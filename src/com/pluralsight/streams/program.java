package com.pluralsight.streams;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class program {
    public static void main(String[] args) {
        List<Person> people = new ArrayList<>();
        people.add(new Person("Liam", "Reynolds", 34));
        people.add(new Person("Olivia", "Parker", 28));
        people.add(new Person("Noah", "Robinson", 22));
        people.add(new Person("Emma", "Campbell", 44));
        people.add(new Person("Ava", "Mitchell", 19));
        people.add(new Person("Sophia", "Turner", 31));
        people.add(new Person("Mason", "Collins", 25));
        people.add(new Person("Isabella", "Bennett", 41));
        people.add(new Person("Lucas", "Bailey", 30));
        people.add(new Person("Mia", "Griffin", 38));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a name to search (first or last): ");
        String search = scanner.nextLine().toLowerCase();

        List<Person> matches = people.stream()
                .filter(p -> p.getFirstName().equalsIgnoreCase(search) || p.getLastName().equalsIgnoreCase(search))
                .collect(Collectors.toList());

        System.out.println("\nMatching people:");
        for (Person p : matches) {
            System.out.println(p);
        }

        // Step 3: Age stats
        if (!people.isEmpty()) {
            double averageAge = people.stream()
                    .mapToInt(Person::getAge)
                    .average()
                    .orElse(0);

            int maxAge = people.stream()
                    .mapToInt(Person::getAge)
                    .max()
                    .orElse(0);

            int minAge = people.stream()
                    .mapToInt(Person::getAge)
                    .min()
                    .orElse(0);

            System.out.printf("\nAverage Age: %.2f\n", averageAge);
            System.out.println("Oldest Age: " + maxAge);
            System.out.println("Youngest Age: " + minAge);
        }
    }
}