import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.HashMap;
import java.util.Map;

public class modu4 {
    public static void main(String[] args) {
        System.out.println(essay(10, 7, "hello my name is Bessie and this is my essay"));
        System.out.println(Arrays.toString(split("()()()")));
        System.out.println(toSnakeCase("helloEdabit"));
        System.out.println(toCamelCase("hello_edabit"));
        System.out.println(overTime(new double[]{9, 17, 30, 1.5}));
        System.out.println(BMI("205 pounds", "73 inches"));
        System.out.println(bugger(999));
        System.out.println(toStarShorthand("abbccc"));
        System.out.println(doesRhyme("Sam I am!", "Green eggs and ham."));
        System.out.println(trouble("451999277","41177722899"));
        System.out.println(countUniqueBooks("AZYWABBCATTTA", "A"));
    }
//1 n-слова k-символы
    public static String essay(int n, int k, String text) {
        String[] words = text.split(" "); //строка, которая с помощью функции slit разбивает на кусочки
        String currentString = "";
        String result = "";
        if (n > words.length)
            return "NO!";
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (currentString.replace(" ", "").length() + word.length() <= k)
                currentString += word + " ";
            else {
                result += currentString + "\n";
                currentString = word + " ";
            }
        }
        if (currentString.length() > 0) {
            result += currentString + "\n";
        }
        return result;
    }
//2
    public static String[] split(String str) {
        List<String> list = new ArrayList<>();//список
        int count = 0;
        int lastIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(')
            {
                count++;
            } else
                {
                count--;
            }
            if (count == 0)
            {
                list.add(str.substring(lastIndex, i + 1));
                lastIndex = i + 1;
            }
        }
        String[] strs = new String[list.size()];
        return strs = list.toArray(strs);
    }
//3
    public static String toCamelCase(String str) {
        String[] arr = str.split("_");
        String new_str = arr[0];
        for (int i = 1; i < arr.length; i++) {
            new_str += (arr[i].substring(0, 1).toUpperCase() + arr[i].substring(1));//буквы загл
        }
        return new_str;
    }
//3
    public static String toSnakeCase(String str) //по буквам
    {
        String new_str = "";
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.substring(i, i + 1).matches("[A-Z]")) //проверяет слвп с загл
            {
                new_str = new_str + "_" + str.substring(i, i + 1).toLowerCase();
            } else
                {
                new_str += str.substring(i, i + 1);
            }
        }
        new_str += str.substring(str.length() - 1);
        return new_str;
    }

    public static String overTime(double[] arr) {
        double sum = 0.0;
        for (double i = arr[0]; i < arr[1]; i += 0.25) {
            if (i < 17) {
                sum += 0.25 * arr[2];
            } else if (i >= 17) {
                sum += 0.25 * arr[2] * arr[3];
            }
        }
        return String.format("$%.2f", sum);

    }
    private static String BMI(String weight, String height) {
        String[] weig = weight.split(" ");
        String[] heig = height.split(" ");
        String result = "";

        double kilos = weig[1].equals("pounds") ? Double.parseDouble(weig[0]) * 0.453592 : Double.parseDouble(weig[0]);
        double meters = heig[1].equals("inches") ? Double.parseDouble(heig[0]) * 0.0254 : Double.parseDouble(heig[0]);

        double val = kilos / (meters * meters);
        val = Math.round(val * 10.0) / 10.0;

        if (val < 18.5) result += val + " Underweight";
        if (val >= 18.5 && val <= 24.5) result += val + " Normal weight";
        if (val >= 25 && val <= 29.9) result += val + " Overweight";
        if (val >= 30) result += val + " Obesity";
        return result;
    }

    public static int bugger(int num) {
        int count = 0;

        while (Integer.valueOf(num).toString().toCharArray().length > 1)//переволит значение num в строкуиберетеедлину
        {
            int newNum = 1;
            for (char c : Integer.valueOf(num).toString().toCharArray()) {
                newNum *= Integer.valueOf(String.valueOf(c));
            }
            num = newNum;
            count += 1;
        }
        return count;
    }

    public static String toStarShorthand(String input) {
        String result = "";
        int count = 1;
        char currentChar = new Character('a');
        for (int i = 1; i < input.length(); i++) {
            currentChar = input.charAt(i - 1);
            if (currentChar == input.charAt(i)) count++;
            else {
                if (count > 1) result += currentChar + "*" + count;
                else result += currentChar;
                count = 1;
                if (i == input.length() - 1) result += String.valueOf(input.charAt(input.length() - 1));
            }
        }
        if (count != 1) result += currentChar + "*" + count;
        return result;
    }

    public static boolean doesRhyme(String str1, String str2) {
        str1 = str1.replaceAll("\\p{Punct}", "");//пунктуация
        str2 = str2.replaceAll("\\p{Punct}", "");
        char lastletter = str1.charAt(str1.length() - 1);
        char lastletter1 = str2.charAt(str2.length() - 1);

        if (Character.toLowerCase(lastletter1) == Character.toLowerCase(lastletter))
            return true;
        else
            return false;
    }
    public static boolean trouble(String number1, String number2) {
        int count1 = 0;
        int count2 = 0;
        String currentChar = "";
        for (int i = 0; i < number1.length() - 1; i++) {
            currentChar = String.valueOf(number1.charAt(i));
            if (currentChar.equals(String.valueOf(number1.charAt(i + 1))))
                count1++;
            else count1 = 0;
            if (count1 == 3)
            {
                count2 = 0;
                for (int j = 0; j < number2.length(); j++) {
                    if (currentChar.equals(String.valueOf(number2.charAt(j))))
                        count2++;
                    else count2 = 0;
                    if (count2 == 2) return true;
                }
            }
        }
        return false;
    }
    public static int countUniqueBooks(String str1, String str2){

        String s = "";
        int count = 0;
        int index = 0;

//если символ = символу начала или конца строки
        for (int i = 0; i < str1.length(); i++){
            if (str1.charAt(i) == str2.charAt(0)){
                count++;
            }
        }
//у каждой книги д.б. по два символа (кол-во книг)
        for (int j = 0; j < count/2; j++){
//ищем индекс вхождения начала книги и потом еще индекс вхождения
            index = str1.indexOf(str2, index);
            int next = str1.indexOf(str2, index + 1);
//заполняем строку со следующего после начала и до некст
            s += str1.substring(index + 1, next);
            index = next + 1;
        }
//создаем булевый массив, максимальное возмонжое количество позиций
        count = 0;
        boolean[] bool = new boolean[Character.MAX_VALUE];
//проходим всю длину получившейся строки
        for (int x = 0; x < s.length(); x++){
            bool[s.charAt(x)] = true;
        }
//счетчик трушек
        for (int y = 0; y < bool.length; y++){
            if (bool[y]){
                count++;
            }
        }
        return count;
    }
}
