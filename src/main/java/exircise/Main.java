package exircise;

import exircise.serializer.json.JsonWriter;
import exircise.serializer.json.model.Address;
import exircise.serializer.json.model.Company;
import exircise.serializer.json.model.Person;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Address home = new Address("Belarus", "Gomel", 246012);
        Address work = new Address("Belarus", "Minsk", 247700);
        Company company = new Company("Self-employed", "software developer", 600);
        Person person = new Person("Anton", "Khmara", 24, new String[] {"Anton", "Ksenia"}, new Address[] {home, work}, company);

        System.out.println(JsonWriter.objectToJson(person, 0));

//        Computer computer = createObjectRecursively(Computer.class);
//        computer.launch();

    }
}
