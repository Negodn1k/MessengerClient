package com.client.content;

import java.util.ArrayList;
import java.util.HashMap;

public class Data {
    private final HashMap<Integer, String> idAndNames = new HashMap<>();

    private void collectData() {
        idAndNames.put(1111, "Misha");
        idAndNames.put(2222, "Sasha");
    }

    public ArrayList<String> getData() {
        collectData();
        ArrayList<String> names = new ArrayList<>(idAndNames.values());
        return names;
    }
}
