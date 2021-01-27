package library_system;

import java.util.Scanner;

public class Library_System {
    public static void main(String[] args) throws Exception {
        Books_Record br=new Books_Record();
        Students_Record sr=new Students_Record();
        Issue_Record ir=new Issue_Record();
        br.readFile();
        sr.readFile();
        ir.readFile();
        Scanner scr = new Scanner(System.in);
        do{
            System.out.println("---------------Library System---------------");
            System.out.println(" 1 - Add a new Record of Book \n 2 - Available Books \n 3- Add new Student Record \n 4- Registered Students \n 5- Issue Books \n 6- Display Issue Record \n 7 - Exit");
            System.out.println("-------------------*---------------------");
            char input_case = scr.next().charAt(0);
            switch(input_case){
                case '1' :
                    br.addRecord();
                    break;
                case '2' :
                    br.display_rec();
                    break;
                case '3' :
                    sr.addRecord();
                    break;
                case '4' :
                    sr.display_rec();
                    break;
                case '5' :
                    ir.addRecord();
                    break;
                case '6' :
                    ir.display_rec();
                    break;
                case '7' :
                    System.out.println("-------------------*---------------------");
                    System.out.println("\tSystem Closed");
                    System.out.println("-------------------*---------------------");
                    return;
                default :
                    System.out.println("invalid case");
                    break;
            }
            System.out.println("Want to continue?\n 1- yes \n 0- no");
            if(scr.next().charAt(0)=='0'){
                System.out.println("System Closed");
                return;
            }
        }
        while(true);
    }
}