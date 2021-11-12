package exircise.serializer.json;

import java.lang.reflect.Field;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.lang.String.format;

public class JsonWriter {

    public static String objectToJson(Object instance, int indentSize) throws IllegalAccessException {
        Field[] fields = instance.getClass().getDeclaredFields();
        StringBuilder builder = new StringBuilder();

        builder.append(indent(indentSize));
        builder.append("{");
        builder.append("\n");

        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);

            if (field.isSynthetic()) {
                continue;
            }

            builder.append(indent(indentSize + 1));
            builder.append(formatStringValue(field.getName()));
            builder.append(":");
            if (field.getType().isPrimitive()) {
                builder.append(field.get(instance));
            } else if (field.getType().equals(String.class)) {
                builder.append(formatStringValue(field.get(instance).toString()));
            } else {
                builder.append(objectToJson(field.get(instance), indentSize + 1));
            }
            if (i != fields.length - 1) {
                builder.append(",");
            }
            builder.append("\n");
        }
        builder.append(indent(indentSize));
        return builder.append("}").toString();
    }

    private static String formatStringValue(String value) {
        return format("\"%s\"", value);
    }

    private static String indent(int indentSize) {
        StringBuilder builder = new StringBuilder();
        return IntStream.range(0, indentSize)
                .mapToObj((int unused) -> builder.append("\t"))
                .collect(Collectors.joining());
    }
}
