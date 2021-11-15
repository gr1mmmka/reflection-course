package exircise.serializer.json.model;

public record Person(
        String name,
        String surname,
        int age,
        String[] children,
        Address[] address,
        Company company
) {
}
