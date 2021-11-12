package exircise;

import exircise.di.model.Computer;

import java.lang.reflect.InvocationTargetException;

import static exircise.di.DependencyInjection.createObjectRecursively;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
//        Address address = new Address("Belarus", "Gomel", 246012);
//        Company company = new Company("Self-employed", "software developer", 600);
//        Person person = new Person("Anton", "Khmara", 24, address, company);
//
//        System.out.println(JsonWriter.objectToJson(person, 0));

        Computer computer = createObjectRecursively(Computer.class);
        computer.launch();

    }
}
