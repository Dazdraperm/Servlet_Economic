package kpfu.itis.group907.Economic.Models;

import java.util.HashMap;

public class DiagramDefaultUser {
    HashMap<String, Double> hashMapDefaultUser = new HashMap<>();

    public DiagramDefaultUser(String nameCategory, Double count) {
        this.hashMapDefaultUser.put(nameCategory, count);
    }

    public HashMap<String, Double> getHashMapDefaultUser() {
        return hashMapDefaultUser;
    }

    public void increaseCategory(String nameCategory, Double count) {
        this.hashMapDefaultUser.put(nameCategory, count);
    }
}
