package domain;

import json.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    private String name;
    private String surname;
    private Integer year;
    private Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.exams = exams;
    }

    @Override
    public JsonObject toJsonObject() {
        Json[] jArr = new Json[exams.length];
        int iter = 0;
        boolean passed;
        for (Tuple<String, Integer> i : exams) {
            JsonPair course = new JsonPair("course", new JsonString(i.key));
            JsonPair mark = new JsonPair("mark", new JsonNumber(i.value));
            if (i.value > 2) {
                passed = true;
            }
            else passed = false;
            JsonPair pass = new JsonPair("passed", new JsonBoolean(passed));
            JsonObject object = new JsonObject(course, mark, pass);
            jArr[iter] = object;
            iter++;
        }
        JsonArray array = new JsonArray(jArr);
        JsonPair objName = new JsonPair("name", new JsonString(name));
        JsonPair objSurname = new JsonPair("surname", new JsonString(surname));
        JsonPair objYear = new JsonPair("year", new JsonNumber(year));
        JsonPair objArr = new JsonPair("exams", array);
        JsonObject finalObject = new JsonObject(objName, objSurname, objYear, objArr);

        return finalObject;
    }
}