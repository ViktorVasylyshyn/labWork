package lab3;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LabWorkStrings {

    private String charRaw;

    public LabWorkStrings(String charRaw) {
        this.charRaw = charRaw;
    }

    public void findCapitalFirstLetterWords() {
        char[] charArray = charRaw.toCharArray();  // преобразуем String в массив символов
        Pattern patternCapital = Pattern.compile("^[A-Z]$"); // паттерн для определения верхнего регистра
        Pattern patternAll = Pattern.compile("^[a-zA-Z]$"); // паттерн для определения букв в целом
        Pattern targetPattern = patternCapital; // пересенная, для определения используемого паттерна.

        StringBuilder wordCapitalChar = new StringBuilder();

        for (int i = 0; i < charArray.length; i++) {
            Matcher matcher = targetPattern.matcher(String.valueOf(charArray[i]));
            if (matcher.find()) {
                wordCapitalChar.append(charArray[i]);
                targetPattern = patternAll; //
            } else {
                if (wordCapitalChar.length() > 0) {
                    System.out.println(wordCapitalChar.toString());
                    wordCapitalChar = new StringBuilder();
                }
                targetPattern = patternCapital;
            }
        }
    }

    public void findMatches(String targetString) {
        Pattern pattern = Pattern.compile(targetString);
        Matcher matcher = pattern.matcher(charRaw);

        int count = 0;
        while (matcher.find()) {
            count++;
        }
        System.out.println("Count of matches 'auto' is = " + count);
    }
}
