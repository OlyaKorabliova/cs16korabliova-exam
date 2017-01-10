package json;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private List<String> obj = new ArrayList<>();
    private List<JsonPair> lstOfJsonPair = new ArrayList<>();
    public JsonObject(JsonPair... jsonPairs) {
        for (JsonPair jPair : jsonPairs) {
            lstOfJsonPair.add(jPair);
        }
    }

    @Override
    public String toJson() {
        String s;
        String k = "{";
        for (JsonPair j : lstOfJsonPair) {
            s = "'" + j.key + "': " + j.value.toJson();
            obj.add(s);
        }
        if (obj.size() >= 1) {
            for (int i = 0; i < obj.size() - 1; i++) {
                k += obj.get(i) + ", ";
            }
            k += obj.get(obj.size() - 1) + "}";
        }
        else k = "{}";
        return k;
    }

    public void add(JsonPair jsonPair) {
        if (lstOfJsonPair.contains(jsonPair)) {
            int ind = lstOfJsonPair.indexOf(jsonPair);
            lstOfJsonPair.set(ind, jsonPair);
        }
        else {
            lstOfJsonPair.add(jsonPair);
        }
    }
    public boolean contains(String name) {
        for (JsonPair j : lstOfJsonPair) {
            if (j.key.equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    public Json find(String name) {
        for (JsonPair j : lstOfJsonPair) {
            if (j.key.equalsIgnoreCase(name)) {
                return j.value;
            }
        }
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject objProj = new JsonObject();
        for (String s : names) {
            for (JsonPair j : lstOfJsonPair) {
                if (s.equalsIgnoreCase(j.key)) {
                    objProj.add(j);
                }
            }
        }
        return objProj;
    }
}
