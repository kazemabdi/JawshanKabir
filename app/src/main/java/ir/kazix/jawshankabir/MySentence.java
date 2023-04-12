package ir.kazix.jawshankabir;

import java.util.ArrayList;

public class MySentence {

    public static ArrayList<MySentence> mySentenceArrayList = new ArrayList<>();

    public static void setMySentenceArrayList() {

        for (int i = 0; i < MySentenceDB.stringsA.length; i++) {

            mySentenceArrayList.add(new MySentence(MySentenceDB.stringsA[i], MySentenceDB.stringsB[i]));
        }
    }

    public static ArrayList<MySentence> getMySentenceArrayList() {

        return mySentenceArrayList;
    } // end getMySentenceArrayList()

    private final String stringA;
    private final String stringB;

    MySentence(String stringA, String stringB) {
        this.stringA = stringA;
        this.stringB = stringB;
    }

    public String getStringA() {
        return this.stringA;
    }

    public String getStringB() {
        return this.stringB;
    }
}