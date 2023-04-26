import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  //Задача 1
//Напишите программу, которая:
//
//прочитает целое число из файла res/in.txt
//переведёт его в двоичную запись
//запишет его в файл res/out.txt
//Воспользуйтесь методом decToBin(int number)
// из задачи 1 предыдущего урока или информацией из разбора домашнего задания.
  public static void main(String[] args) throws IOException {

    BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"));
    int number = Integer.parseInt(bufferedReader.readLine());

    FileWriter outputFileWriter = new FileWriter("output.txt");
    outputFileWriter.write(decToBin(number)+"\n");
    outputFileWriter.close();
  }

  public static String decToBin(int number) {

    StringBuilder str = new StringBuilder(" ");//инициализируем строку
    boolean isNegative = number < 0;
    if (isNegative) {
      number = Math.abs(number);// убираем знак
    }

    if (number == 0) {  //
      return "0";
    }
    while (number != 0) { // пока в числе есть цифры
      int digit = number % 2; // последняя цифра - остаток от деления на основание (2)
      number /= 2;// сам остаток от числа делим на основание (2)

      str.insert(0, digit);
      // digit-вписываем как первую цифру в нашу строку и это всё повторяем пока number !=0.
    }
    if (isNegative) {
      str.insert(0, "-");//добавляем знак "-" если число отрицательное
    }

    return str.toString();
  }
}