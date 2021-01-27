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

public class Books_Record {
    static ArrayList<Integer> books_id=new ArrayList<>();
    static ArrayList<String> books_title=new ArrayList<>();
    static ArrayList<String> author_name=new ArrayList<>();
    static ArrayList<Integer> availability=new ArrayList<>();
    String path = "C:\\Users\\Muhammad Azhar\\Documents\\NetBeansProjects\\Library_System\\src\\library_system\\record.txt";
    //    String path = "record.txt";
    void addRecord(){
        Scanner scr=new Scanner(System.in);
        System.out.print("Enter Book Title\t");
        String book_title=scr.next();
        System.out.print("Enter Author Name\t");
        String author=scr.next();
        System.out.print("Enter Books Quantity\t");
        int quantity=scr.nextInt();
        int id;
        for(int count=quantity;count>0;count--){
            if(books_id.size()<1){
               id=1;
            }
            else{
                id=books_id.size()+1;
            }
            books_id.add(id);
            books_title.add(book_title);
            author_name.add(author);
            availability.add(1);
        }
        this.writeFile();
    }
    void display_rec(){
        if(books_id.size()<1){
            System.out.println("No record found...");
            return;
        }
        System.out.println("\t\t\tAll Books Record");
        System.out.println("Id\tTitle\t\t\tAuthor");
        for(int index=0;index<books_id.size();index++){
            if(availability.get(index)==1)
                System.out.println(books_id.get(index)+"\t"+books_title.get(index)+"\t\t"+author_name.get(index));
        }
    }
    void writeFile(){
        try {
            File file=new File(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            for(int index=0; index< books_id.size(); index++){
                int id=books_id.get(index);
                String title=books_title.get(index);
                String name=author_name.get(index);
                int check=availability.get(index);
                String str=id+"###"+title+"###"+name+"###"+check;
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
            InputStreamReader obj = new InputStreamReader(new FileInputStream(file), "UTF-8");
            BufferedReader br = new BufferedReader(obj);
            String line;
            StringTokenizer strT;
            while((line = br.readLine()) != null){
                strT = new StringTokenizer(line,"###");
                books_id.add(Integer.parseInt(strT.nextToken()));
                books_title.add(strT.nextToken());
                author_name.add(strT.nextToken());
                availability.add(Integer.parseInt(strT.nextToken()));
            }
        } catch(IOException | NumberFormatException ex){
            System.out.println("System Error..."+ex);
        }
    }
}