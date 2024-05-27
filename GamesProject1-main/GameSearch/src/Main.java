import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

    }
    public static void WindowOpen(){
        try {
            File f = new File("DATA");
            Scanner FileRead = new Scanner(f);
            List<Game> list = new ArrayList<Game>();
            while(FileRead.hasNextLine()){
                String TextFromFIle=FileRead.nextLine();
                String[] Para=TextFromFIle.split("|");
                Game NewEntry=new Game(Para[0],Double.parseDouble(Para[1]),Para[2]);
                list.add(NewEntry);
            }




            String[] names={" ","Action", "Fighting","MMO","Puzzle","Racing", "RogueLike", "RPG", "SandBox", "Shooter", "SoulsLike"};
            JFrame fr=new JFrame();
            JButton b=new JButton("Search");
            b.setBounds(350,200,100, 50);
            fr.add(b);
            fr.setSize(800,500);
            JComboBox li=new JComboBox(names);
            li.setBounds(50,50,100,30);

            fr.add(li);
            fr.setLayout(null);
            fr.setVisible(true);
            fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);

        }
        catch (FileNotFoundException a){
            System.out.println("Problem");
        }
    }
    public static List<Game> FindAndPut(List<Game> list,String genre,Double price){
        List<Game> newlist=new ArrayList<Game>();
        for (Game g:list) {
            if(g.price==price&&g.Genre==genre){newlist.add(g);}
        }
        return newlist;
    }

}
