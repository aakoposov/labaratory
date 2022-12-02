import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void println(Object l){
        System.out.println(l);
    }

    public static void main(String[] args) {
        println("Придумайте пароль . Пароль может содержать только латинские буквы, " +
                "Цифры от 0 до 9 и символ.Чтобы пароль был надёжным, он должен содержать минимум " +
                "8 символов,  одну заглавную букву, одну маленькую букву и одну цифру.");
        try{
            while(true){
                Scanner scn = new Scanner(System.in);
                String input = scn.nextLine().replaceAll("\\n", "").strip();

                //проверям некорректные символы
                String symbols = "[a-zA-Z0-9_]*";

                Pattern s = Pattern.compile(symbols);
                Matcher correct = s.matcher(input);

                if(!correct.matches()){
                    println("Пароль содержит недопустимые символы");
                    continue;
                }

                //проверям надёжность
                String check = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9]).{8,}$";

                Pattern p = Pattern.compile(check);
                Matcher m = p.matcher(input);

                if(!m.matches()){
                    println("Пароль ненадёжен");
                    continue;
                }

                println("Пароль надёжен");

            }
        } catch (Exception e) {
            println("ошибка");
        }
    }
}