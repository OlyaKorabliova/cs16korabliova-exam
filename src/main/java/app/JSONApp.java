package app;

import domain.*;
import json.*;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JSONApp {
    public static void main(String[] args) {
        Json jYear = new JsonNumber(2);
        print(jYear); // 2

        Json jMarks = new JsonArray(new JsonNumber(3), new JsonNumber(4));
        print(jMarks); // [3, 4]

        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        JsonPair marks = new JsonPair("marks", jMarks);
        JsonPair year = new JsonPair("year", jYear);
        JsonObject jsonObj = new JsonObject(name, surname, year, marks);
        print(jsonObj); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        print(jsonObj.projection("surname", "age", "year", "marks")); // {'surname': 'Rodionov', 'year': 2, 'marks': [3, 4]}

        BasicStudent basicStudent = new BasicStudent("Andrii", "Rodionov", 2);
        print(basicStudent.toJsonObject()); // {'name': 'Andrii', 'surname': 'Rodionov', 'year': 2}

    }

    private static void print(Json json) {
        System.out.println(json.toJson());
    }

    public static JsonObject sessionResult() {
        JsonPair name = new JsonPair("name", new JsonString("Andrii"));
        JsonPair surname = new JsonPair("surname", new JsonString("Rodionov"));
        Json jYear = new JsonNumber(2);

        JsonPair course1 = new JsonPair("course", new JsonString("OOP"));
        JsonPair mark1 = new JsonPair("mark", new JsonNumber(3));
        JsonPair passed1 = new JsonPair("passed", new JsonBoolean(true));
        JsonObject obj1 = new JsonObject(course1, mark1, passed1);

        JsonPair course2 = new JsonPair("course", new JsonString("English"));
        JsonPair mark2 = new JsonPair("mark", new JsonNumber(5));
        JsonPair passed2 = new JsonPair("passed", new JsonBoolean(true));
        JsonObject obj2 = new JsonObject(course2, mark2, passed2);

        JsonPair course3 = new JsonPair("course", new JsonString("Math"));
        JsonPair mark3 = new JsonPair("mark", new JsonNumber(2));
        JsonPair passed3 = new JsonPair("passed", new JsonBoolean(false));
        JsonObject obj3 = new JsonObject(course3, mark3, passed3);


        Json jExams = new JsonArray(obj1, obj2, obj3);
        JsonPair year = new JsonPair("year", jYear);
        JsonPair exams = new JsonPair("exams", jExams);
        JsonObject jsonObject = new JsonObject(name, surname, year, exams);
        return jsonObject;
    }
}
