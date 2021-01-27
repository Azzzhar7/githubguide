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

public class Students_Record {
    static ArrayList<String> student_id=new ArrayList<>();
    static ArrayList<String> student_name=new ArrayList<>();
    String path = "C:\\Users\\Muhammad Azhar\\Documents\\NetBeansProjects\\Library_System\\src\\library_system\\stu_record.txt";
    void addRecord(){
        Scanner scr=new Scanner(System.in);
        System.out.print("Enter Student ID\t");
        String std_id=scr.next();
        System.out.print("Enter Student Name\t");
        String std_name=scr.next();
        student_id.add(std_id);
        student_name.add(std_name);
        this.writeFile();
    }
    void display_rec(){
        if(student_id.size()<1){
            System.out.println("No record found...");
            return;
        }
        System.out.println("\t\t\tAll Student Record");
        System.out.println("Id\t\tName");
        for(int index=0;index<student_id.size();index++){
            System.out.println(student_id.get(index)+"\t"+student_name.get(index));
        }
    }
    private void writeFile(){
        try {
            File file=new File(path);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file),"UTF-8"));
            for(int index=0; index< student_id.size(); index++){
                String id=student_id.get(index);
                String name=student_name.get(index);
                String str=id+"###"+name;
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
                student_id.add(strT.nextToken());
                student_name.add(strT.nextToken());
            }
        } catch(IOException | NumberFormatException ex){
            System.out.println("System Error..."+ex);
        }
    }
}
