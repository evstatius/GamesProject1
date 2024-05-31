import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WindowOpen extends JFrame implements ActionListener {
    Boolean filteron=false;
    Popup pp;
    Boolean ac=false;
    Boolean fi=false;
    Boolean mm=false;
    Boolean pz=false;
    Boolean rc=false;
    Boolean rl=false;
    Boolean rp=false;
    Boolean sb=false;
    Boolean sh=false;
    Boolean so=false;
    WindowOpen(){

        try {
            File f = new File("GameSearch/DATA");
            Scanner FileRead = new Scanner(f);
            List<Game> list = new ArrayList<Game>();
            while(FileRead.hasNextLine()){
                String TextFromFIle=FileRead.nextLine();

                String[] Para=TextFromFIle.split(":");
                Game NewEntry=new Game(Para[0],Double.parseDouble(Para[2]),Para[1]);
                list.add(NewEntry);
            }



            JFrame fr=new JFrame();
            JButton b=new JButton("Search");
            b.setBounds(350,150,100, 50);
            fr.add(b);
            fr.setBounds(0,0,800,600);


            JPanel panel=new JPanel();

            JCheckBox AC=new JCheckBox("Action");
            JCheckBox FI=new JCheckBox("Fighting");
            JCheckBox MM=new JCheckBox("MMO");
            JCheckBox PZ=new JCheckBox("Puzzle");
            JCheckBox RC=new JCheckBox("Racing");
            JCheckBox RL=new JCheckBox("RogueLike");
            JCheckBox RP=new JCheckBox("RPG");
            JCheckBox SB=new JCheckBox("Sandbox");
            JCheckBox SH=new JCheckBox("Shooter");
            JCheckBox SO=new JCheckBox("Soulslike");
            panel.add(AC);
            panel.add(FI);
            panel.add(MM);
            panel.add(PZ);
            panel.add(RC);
            panel.add(RL);
            panel.add(RP);
            panel.add(SB);
            panel.add(SH);
            panel.add(SO);
            PopupFactory pf = new PopupFactory();

            JButton b1=new JButton("Filter");
            b1.setBounds(200,50,100, 50);

            int i1=fr.getX();
            b1.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(filteron){pp.hide();filteron=false;}
                            else{pp=pf.getPopup(fr,panel,200+fr.getX(),50+fr.getY());pp.show();filteron=true;}
                        }
                    }

            );

            fr.add(b1);
            fr.setLayout(null);
            JLabel label = new JLabel();

            JTextArea TextA=new JTextArea();


            fr.setVisible(true);
            fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);

            b.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    }
            );

            AC.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(ac){ac=false;}
                            else{ac=true;}
                        }
                    }
            );
            FI.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(fi){fi=false;}
                            else{fi=true;}
                        }
                    }
            );
            MM.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(mm){mm=false;}
                            else{mm=true;}
                        }
                    }
            );
            PZ.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(pz){pz=false;}
                            else{pz=true;}
                        }
                    }
            );
            RC.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(rc){rc=false;}
                            else{rc=true;}
                        }
                    }
            );
            RL.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(rl){rl=false;}
                            else{rl=true;}
                        }
                    }
            );
            RP.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(rp){rp=false;}
                            else{rp=true;}
                        }
                    }
            );
            SB.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(sb){sb=false;}
                            else{sb=true;}
                        }
                    }
            );
            SH.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(sh){sh=false;}
                            else{sh=true;}
                        }
                    }
            );
            SO.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if(so){so=false;}
                            else{so=true;}
                        }
                    }
            );
        }
        catch (FileNotFoundException a){
            System.out.println("Problem");
        }

    }
    public void actionPerformed(ActionEvent e){}
    public List <Game> check(List<Game> list, boolean ch, String genr){
        List<Game> NewList=new ArrayList<Game>();
        if(ch){
            for(int i=0; i<list.size(); i++){
                if(list.get(i).Genre.equals(genr)){NewList.add(list.get(i));}
            }
        }
        return NewList;
    }

}
