import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
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
    List<Game> list = new ArrayList<Game>();
    WindowOpen(){

        try {
            File f = new File("GameSearch/DATA");
            Scanner FileRead = new Scanner(f);

            while(FileRead.hasNextLine()){
                String TextFromFIle=FileRead.nextLine();

                String[] Para=TextFromFIle.split(":");
                Game NewEntry=new Game(Para[0],Double.parseDouble(Para[2]),Para[1]);
                list.add(NewEntry);
            }



            JFrame fr=new JFrame("Game Filter");
            JButton b=new JButton("Search");
            b.setBounds(350,150,100, 50);
            fr.add(b);
            fr.setBounds(0,0,800,550);


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

            JButton b2=new JButton("Add a game");
            b2.setBounds(450,50,150, 50);

            fr.add(b2);
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

            JTextArea TextA=new JTextArea(10,40);
            TextA.setBounds(0,250,800,300);
            JPanel panel2=new JPanel();
            panel2.setBounds(0,250,800,500);
            panel2.add(TextA);
            fr.add(panel2);

            fr.setDefaultCloseOperation(fr.EXIT_ON_CLOSE);

            JScrollPane scrollPane=new JScrollPane(TextA, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(750,300,20,300);
            panel2.add(scrollPane);
            TextA.setEditable(false);
            fr.setVisible(true);
            b.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            TextA.setText("");
                            List<Game> NewestList=new ArrayList<Game>();
                            if(check(list,ac,"Action").isEmpty()==false){NewestList.addAll(check(list,ac,"Action"));}
                            if(check(list,fi,"Fighting").isEmpty()==false){NewestList.addAll(check(list,fi,"Fighting"));}
                            if(check(list,mm,"MMO").isEmpty()==false){NewestList.addAll(check(list,mm,"MMO"));}
                            if(check(list,pz,"Puzzle").isEmpty()==false){NewestList.addAll(check(list,pz,"Puzzle"));}
                            if(check(list,rc,"Racing").isEmpty()==false){NewestList.addAll(check(list,rc,"Racing"));}
                            if(check(list,rl,"RogueLike").isEmpty()==false){NewestList.addAll(check(list,rl,"RogueLike"));}
                            if(check(list,rp,"RPG").isEmpty()==false){NewestList.addAll(check(list,rp,"RPG"));}
                            if(check(list,sh,"Shooter").isEmpty()==false){NewestList.addAll(check(list,sh,"Shooter"));}
                            if(check(list,so,"SoulsLike").isEmpty()==false){NewestList.addAll(check(list,so,"SoulsLike"));}
                            if(check(list,sb,"Sandbox").isEmpty()==false){NewestList.addAll(check(list,sb,"Sandbox"));}
                            if(ac==false&&fi==false&&mm==false&&pz==false&&rc==false&&rl==false&&rp==false&&sh==false&&so==false&&sb==false){
                               for(int i=0; i<list.size(); i++){
                                   TextA.append(list.get(i).name);
                                   TextA.append(" - "+list.get(i).Genre);
                                   TextA.append(" - "+list.get(i).price+" lv.\n");

                               }
                           }

                            for(int i=0; i<NewestList.size(); i++){
                                TextA.append(NewestList.get(i).name);
                                TextA.append(" - "+NewestList.get(i).Genre);
                                TextA.append(" - "+NewestList.get(i).price+" lv.\n");

                            }

                        }
                    }
            );
            b2.addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            createFrame();
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
    public void createFrame()
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JFrame frame = new JFrame("Game adder");
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                JPanel panel = new JPanel();
                JPanel panel2=new JPanel();
                panel.setBounds(0,0,500,50);
                panel2.setBounds(0,50,500,150);
                JPanel panel3=new JPanel();
                panel3.setBounds(0,200,500,50);
                JLabel lab=new JLabel("Type the name, genre and price of the game (put them on seperate lines)");
                lab.setBounds(0,0,500,100);

                panel.add(lab);
                frame.add(panel);
                frame.add(panel2);
                frame.setBounds(0,0,500,300);
                frame.setLayout(null);

                JTextArea TA=new JTextArea();
                TA.setBounds(50,200,400,100);
                TA.setColumns(20);
                TA.setRows(5);
                panel2.add(TA);
                frame.add(panel3);
                JButton b=new JButton("Add game");
                b.setBounds(200,150,50,50);
                b.addActionListener(
                        new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String a=TA.getText();
                                String[] a1=a.split("\n");
                                File f = new File("GameSearch/DATA");
                                try {
                                    FileWriter fw= new FileWriter(f,true);
                                    fw.write("\n"+a1[0]+":"+a1[1]+":"+a1[2]);
                                    fw.close();
                                    Game NewEntry=new Game(a1[0],Double.parseDouble(a1[2]),a1[1]);
                                    list.add(NewEntry);
                                } catch (IOException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        }
                );
                panel3.add(b);
                frame.setVisible(true);
            }
        });
    }

}
