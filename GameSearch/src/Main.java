import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        try {
            File f = new File("DATA");
            Scanner FileRead = new Scanner(f);
            System.out.println("aaa");
            String[] names={"Action", "Fighting","MMO","Puzzle","Racing", "RogueLike", "RPG", "SandBox", "Shooter", "SoulsLike"};

            JFrame fr=new JFrame();
            JButton b=new JButton("Search");
            b.setBounds(350,200,100, 50);
            fr.add(b);
            fr.setSize(800,500);
            JComboBox li=new JComboBox(names);
            JLabel la=new JLabel("Select a category");
            li.setBounds(50,50,100,30);
            li.
            fr.add(li);
            fr.setLayout(null);
            fr.setVisible(true);
            fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);

        }
        catch (FileNotFoundException a){
            System.out.println("Problem");
        }
    }
}
