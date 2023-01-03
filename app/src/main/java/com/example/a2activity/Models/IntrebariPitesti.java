package com.example.a2activity.Models;

public class IntrebariPitesti {

    public static String question[] ={
            "Care este capitala Argesului?",
            "Cate orase se afla in judetul Arges?",
            "In ce regiune este situat judetul Arges?",
            "Cate Municipii se afla in judetul Arges?",
            "Care este indicativul autovehiculelor din Arges?"

    };

    public static String choices[][] = {
            {"Bucuresti","Mioveni","Stefanesti","Pitesti"},
            {"4","5","6","7"},
            {"Dobrogea","Muntenia","Banat","Crisana"},
            {"3","7","4","6"},
            {"AB","AR","AP","AG"}
    };

    public static String correctAnswers[] = {
            "Pitesti",
            "7",
            "Muntenia",
            "3",
            "AG"
    };
}
