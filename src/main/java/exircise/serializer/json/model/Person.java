package exircise.serializer.json.model;

public record Person(
        String name,
        String surname,
        int age,
        Address address,
        Company company
) {
}
