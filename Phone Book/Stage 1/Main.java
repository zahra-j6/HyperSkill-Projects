package phonebook;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File find_txt = new File ("C:\\Users\\zahra\\Downloads\\find.txt");
        File directory = new File("C:\\Users\\zahra\\Downloads\\directory.txt");
        Scanner scanf=new Scanner(find_txt);
        Scanner scand = new Scanner(directory);
       ArrayList<String> name = new ArrayList<>();
        while(scand.hasNextLine()){
            String line[]=scand.nextLine().split(" ");
            if (line.length==2)
                name.add(line[1]);
            else
           name.add(line[1]+" "+line[2]);
        }
        long start_time=System.currentTimeMillis();
        int entry=0;
        while(scanf.hasNextLine()){
            String names = scanf.nextLine();
            for(int i=0;i<name.size();i++){
                if (name.get(i).equals(names))
                    entry++;
            }
        }
        long end_time=System.currentTimeMillis();
        long time_elapsed = end_time-start_time;
        long minutes = (time_elapsed / 1000) / 60;
        long seconds = (time_elapsed / 1000) % 60;
        long milliseconds = time_elapsed - ((minutes * 60000) + ( seconds * 1000));
        System.out.printf("Start searching...\nFound %d / %d entries. Time taken: %d min. %d sec. %d ms.",entry,entry,minutes,seconds,milliseconds);

        

    }
}
