package library_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Issue_Record {
    static ArrayList<Integer> issue_id=new ArrayList<>();
    static ArrayList<String> stu_id=new ArrayList<>();
    static ArrayList<Integer> book_id=new ArrayList<>();
    String path = "C:\\Users\\Muhammad Azhar\\Documents\\NetBeansProjects\\Library_System\\src\\library_system\\issue_record.txt";
    void addRecord(){
        Scanner scr=new Scanner(System.in);
        System.out.print("Enter Student ID\t");
        String std_id=scr.next();
        System.out.print("Enter Book ID\t");
        int b_id=scr.nextInt();
        if(book_id.contains(b_id)){
            System.out.println("Sorry this book is not available for student");
            return;
        }
        int id;
        if(issue_id.size()<1){
           id=1;
        }
        else{
            id=issue_id.size()+1;
        }
        issue_id.add(id);
        stu_id.add(std_id);
        book_id.add(b_id);
        Books_Record.availability.set(Books_Record.books_id.indexOf(b_id),0);
        Books_Record br=new Books_Record();
        br.writeFile();
        this.writeFile();
    }
    void display_rec(){
        if(issue_id.size()<1){
            System.out.println("No record found...");
            return;
        }
        System.out.println("\t\t\tAll Issuance Record");
        System.out.println("Book Id\t Student ID\t\tBook Title\t\t\t\t\tStudent Name");
        for(int index=0;index<issue_id.size();index++){
            System.out.print(book_id.get(index)+"\t"+stu_id.get(index));
            System.out.println("\t"+Books_Record.books_title.get(Books_Record.books_id.indexOf(book_id.get(index)))+"\t\t\t\t\t"+Students_Record.student_name.get(Students_Record.student_id.indexOf(stu_id.get(index))));
        }
    }
    private void writeFile(){
        try {
            File file=new File(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            for(int index=0; index< issue_id.size(); index++){
                int id=issue_id.get(index);
                String st_id=stu_id.get(index);
                int b_id=book_id.get(index);
                String str=id+"###"+st_id+"###"+b_id;
                bw.write(str);
                bw.newLine();
            }
            bw.close();
        }
        catch (Exception ex) {
            System.out.println("System Error..."+ex);
        }
    }
    public void readFile(){
        try{
            File file = new File(path);
            if(!file.exists() && !file.isDirectory()){
                FileOutputStream fos = new FileOutputStream(file);
            }
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));
            String line;
            StringTokenizer strT;
            while((line = br.readLine()) != null){
                strT = new StringTokenizer(line,"###");
                issue_id.add(Integer.parseInt(strT.nextToken()));
                stu_id.add(strT.nextToken());
                book_id.add(Integer.parseInt(strT.nextToken()));
            }
        } catch(IOException | NumberFormatException ex){
            System.out.println("System Error..."+ex);
        }
    }
}
