package com.example.a2activity;

public class IntrebariPitesti {

    public static String question[] ={
            "Ce comanda folosesti pentru a folosi un Layout?",
            "Prin ce comanda creezi un buton?",
            "Ce baza de date are inclusa Android Studio?",
            "Ce limbaje foloseste Android Studio?",
            "Cate layout-uri are Android Studio ?"

    };

    public static String choices[][] = {
            {"<NumeLayout></NumeLayout>","Il tragi din Pallete","Cauti pe net","Intrebi un coleg"},
            {"<Button>","<Button .../>","<Create btnButon>","Folosesti Pallete"},
            {"SQL","Oracle","MySql","SQLite"},
            {"Kotlin si C#","Java si C++","Java si Kotlin","C# si C++"},
            {"2","4","7","10"}
    };

    public static String correctAnswers[] = {
            "<NumeLayout></NumeLayout>",
            "<Button .../>",
            "SQLite",
            "Java si Kotlin",
            "7"
    };
}
