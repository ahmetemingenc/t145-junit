package day07_assertions_testBaseClass;

import java.util.InputMismatchException;
import java.util.Scanner;

public class s {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        double sayi1 = 0;
        double sayi2 = 0;

        try {
            System.out.print("Birinci sayıyı giriniz: ");
            sayi1 = scanner.nextDouble();
        }catch (InputMismatchException i){
            System.out.println("Sadece sayı girebilirsiniz!");
            System.exit(0);
        }

        try {
            System.out.print("İkinci sayıyı giriniz: ");
            sayi2 = scanner.nextDouble();
        }catch (InputMismatchException i){
            System.out.println("Sadece sayı girebilirsiniz!");
            System.exit(0);
        }

        scanner.nextLine();


        System.out.println("Yapmak istediğiniz işlemi girin (+, -, *, /, %)");

        char operator = scanner.nextLine().charAt(0);

        double sonuc = 0;

        if (operator == '+'){
            sonuc = sayi1 + sayi2;
            System.out.println("Sonuç = " + sonuc);
        } else if (operator == '-') {
            sonuc = sayi1 - sayi2;
            System.out.println("Sonuç = " + sonuc);
        } else if (operator == '*') {
            sonuc = sayi1 * sayi2;
            System.out.println("Sonuç = " + sonuc);
        } else if (operator == '/') {
            sonuc = sayi1 / sayi2;
            System.out.println("Sonuç = " + sonuc);
        } else if (operator == '%') {
            sonuc = sayi1 % sayi2;
            System.out.println("Sonuç = " + sonuc);
        }else {
            System.out.println("Bu operatör geçerli değil!");
        }
    }
}