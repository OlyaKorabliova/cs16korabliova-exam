package json;

/**
 * Created by Olia on 10.01.2017.
 */
public class Main {
    public static void main(String ar[]) {
        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        System.out.println(name);
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", new JsonString("gfdg"));
        JsonPair year = new JsonPair("year", new JsonString("qwerty"));
        JsonObject jsonObj = new JsonObject(name, surname, marks);
        jsonObj.add(year);
    }
}
