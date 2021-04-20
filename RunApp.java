package task;

/**
 * Написать на Java программу распаковывания строки.
 * На вход поступает строка вида число[строка], на выход - строка, содержащая повторяющиеся подстроки.
 *
 * Пример:
 * Вход: 3[xyz]4[xy]z
 * Выход: xyzxyzxyzxyxyxyxyz
 *
 * Ограничения:
 * - одно повторение может содержать другое. Например: 2[3[x]y]  = xxxyxxxy
 * - допустимые символы на вход: латинские буквы, числа и скобки []
 * - числа означают только число повторений
 * - скобки только для обозначения повторяющихся подстрок
 * - входная строка всегда валидна.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RunApp {
    public static void main(String[] args){

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            String in = reader.readLine();

            new App().checkString(in);

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}