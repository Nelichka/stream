import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10_000_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }
        long minors = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        // System.out.println("Несовершеннолетних: " + minors);
        List<String> conscript = persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 27)
                .filter(person -> person.getSex() == Sex.MAN)
                .map(person -> person.getFamily().toString())
                .collect(Collectors.toList());
        // System.out.println("Призывников: " + conscript);
        List<String> workMen = persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 65)
                .filter(person -> person.getSex() == Sex.MAN)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .map(person -> person.getFamily().toString())
                .collect(Collectors.toList());
        List<String> workWomen = persons.stream()
                .filter(person -> person.getAge() > 18)
                .filter(person -> person.getAge() < 60)
                .filter(person -> person.getSex() == Sex.WOMAN)
                .filter(person -> person.getEducation() == Education.HIGHER)
                .map(person -> person.getFamily().toString())
                .collect(Collectors.toList());
        List<String> work = new ArrayList<>();
        work.addAll(workMen);
        work.addAll(workWomen);
        Collections.sort(work);

        // System.out.println("В отсортированном списке рабочих женщин и мужчин: " + work.size());

    }

}

