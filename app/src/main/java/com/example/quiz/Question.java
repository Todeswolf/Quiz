package com.example.quiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question
{
    private String text; //Frage
    private List<String> answers;
    private int correctAnswerIndex;

    public Question(String text, List<String> answers, int correctAnswerIndex) {
        this.text = text;
        this.answers = answers;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getText()
    {
        return text;
    }

    public List<String> getAnswers()
    {
        return answers;
    }

    public String getCorrectAnswer() 
    {
        return answers.get(correctAnswerIndex-1); //Index orientiert sich noch an Start = 1 TODO: anpassen
    }

    //Wichtig: Index startet aktuell noch bei 1
    public static ArrayList<Question> getQuestions() {
        ArrayList<Question> questions = new ArrayList<Question>();
        questions.add(new Question("Name der Stadt in der das Sommercamp Informatik stattfindet?", Arrays.asList("Hamburg", "Jena", "Berlin"), 2));
        questions.add(new Question("Wo liegt Jena?", Arrays.asList("Thüringen", "Bayern", "Schweiz"), 1));
        questions.add(new Question("Was ist mein Name (Name vom Appentwickler)?", Arrays.asList("David", "Robert", "Peter"), 1));
        questions.add(new Question("Wie heißt die Uni Jena?", Arrays.asList("E.T.A.-Hoffman", "Wolfgang-von-Goethe", "Friedrich-Schiller"), 3));
        questions.add(new Question("Wie viel Bits hat ein Byte?", Arrays.asList("4", "16", "8"), 3));
        questions.add(new Question("Quadratwurzel aus 144?", Arrays.asList("12", "11", "13"), 1));
        questions.add(new Question("Durch welche Stadt fliesst der Tiber?", Arrays.asList("Athen", "Rom", "Barcelona"), 2));
        questions.add(new Question("Was ist dreidimensional?", Arrays.asList("Kreis", "Kugel", "Quadrat"), 2));
        questions.add(new Question("Wer schuf den Begriff prästabilierte Harmonie?", Arrays.asList("Kant", "Goethe", "Leibniz"), 3));
        questions.add(new Question("Welcher Kobold haust in der Werkstatt von Meister Eder?", Arrays.asList("Muckl", "Jockl", "Pumuckl"), 3));
        questions.add(new Question("Was dient dazu, ein Problem schrittweise zu lösen?", Arrays.asList("Cyberspace", "BIOS", "Algorithmus"), 3));
        questions.add(new Question("Was hilft meistens bei Fehlern?", Arrays.asList("Gerät neustarten", "Fluchen", "Dagegen treten"), 1));
        questions.add(new Question("Was regelt die Übertragung von Dokumenten im WWW?", Arrays.asList("UMTL", "HTTP", "HTML"), 2));
        questions.add(new Question("Von welcher Firma ist MS-DOS?", Arrays.asList("Microsoft", "Apple", "Oracle"), 1));
        questions.add(new Question("Drucker, Steckkarten und Prozessoren gehören zur ...", Arrays.asList("Freeware", "Shareware", "Hardware"), 3));
        questions.add(new Question("Bei wem liegt das Copyright vom Format Bitmap?", Arrays.asList("Apple", "Netscape", "Microsoft"), 3));
        questions.add(new Question("Was bedeutet HTML?", Arrays.asList("Hypertext Markup Language", "Hypertext Mother Language", "Hyperlink Mention Language"), 1));
        questions.add(new Question("Wie hieß der erste Mikroprozessor?", Arrays.asList("Pentium 1", "Apple 44", "Intel 4004"), 3));
        questions.add(new Question("Was ist eine png?", Arrays.asList("Sounddatei", "Bilddatei", "Konsole"), 2));
        questions.add(new Question("Wer schrieb den Erlkönig?", Arrays.asList("Schiller", "Goethe", "Kant"), 2));
        questions.add(new Question("Was ist Jute?", Arrays.asList("Tier", "Gestein", "Pflanze"), 3));
        questions.add(new Question("Was ist die größte Stadt Europas (Einwohner)?", Arrays.asList("London", "Istanbul", "Moskau"), 2));
        questions.add(new Question("Was ist der größte Arbeitgeber von Jena?", Arrays.asList("Friedrich-Schiller-Universität", "Jenoptik", "7S Group GmbH"), 1));
        questions.add(new Question("Was ist das Symbol im Periodensystem für Zinn?", Arrays.asList("Sn", "Zi", "Zn"), 1));
        questions.add(new Question("Was für eine Säure ist die Magensäure?", Arrays.asList("Salpetersäure", "Salzsäure", "Buttersäure"), 2));
        questions.add(new Question("Wie groß ist ein Nibble?", Arrays.asList("4 Bits", "0,5 Kilobyte", "4 Bytes"), 1));
        questions.add(new Question("Was ist der HTML Farbcode für die Farbe Weiß?", Arrays.asList("#000000", "#58FAF4", "#FFFFFF"), 3));
        questions.add(new Question("Wer ist der reichste Mensch der Welt?", Arrays.asList("Bill Gates", "Jeff Bezos", "Mark Zuckerberg"), 2));
        questions.add(new Question("Was ist der erfolgreichste Animationsfilm?", Arrays.asList("Die Eiskönigin – Völlig unverfroren", "Minions", "Toy Story 3"), 1));
        return questions;
    }
}
