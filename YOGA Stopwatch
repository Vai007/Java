<package>;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Scanner;

public class Main extends JFrame implements ItemListener {

    JLabel jltime;
    JButton jbt;
    NumberFormat format;

    public Timer timer;
    public long initial;
    public long ttime2;
    public String ttime;
    public long remaining;

    public Main()throws Exception {
        showPts();

        JLabel pts = new JLabel("Your Pts:-");
        pts.setBounds(40,135,100,30);
        pts.setForeground(Color.WHITE);
        pts.setFont(new Font("Arial",Font.BOLD,15));
        add(pts);

        JLabel temp = new JLabel(<banner>);
        temp.setBounds(220,20,400,80);
        temp.setForeground(Color.white);
        temp.setFont(new Font("Arial", Font.BOLD, 96));
        add(temp);

        JPanel timePanel = new JPanel();
        timePanel.setForeground(Color.BLACK);

        jltime = new JLabel();
        jltime.setForeground(Color.WHITE);
        jltime.setBackground(Color.BLACK);
        jltime.setFont(new Font("Arial", Font.BOLD, 96));
        timePanel.add(jltime);
        timePanel.setBackground(Color.BLACK);

        JPanel jp1 = new JPanel();
        jp1.setLayout(new FlowLayout());
        BufferedImage img = ImageIO.read(new File(<FilePath>));
        JLabel lbl = new JLabel(new ImageIcon(img));
        lbl.setBounds(0,-300,500,800);
        add(lbl);

        ttime = <Time in minutes>;    //Must be written in string

        jbt = new JButton("START");
        jp1.add(jbt);
        jp1.setBounds(500,285,70,35);
        jp1.setBackground(Color.black);
        add(jp1);
        add(timePanel);

        Event e = new Event();
        jbt.addActionListener(e);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setBounds(200,200,700,500);
        setBackground(Color.BLACK);
        setResizable(false);
    }

    public void showPts()throws Exception{
        JLabel pts1= new JLabel("--");
        pts1.setBounds(40,180,300,80);
        pts1.setFont(new Font("Arial", Font.BOLD,96));
        pts1.setForeground(Color.WHITE);
        add(pts1);

        File file = new File("score.txt");
        if (file.createNewFile()){
        }
        else {
            Scanner sc = new Scanner(file);
            pts1.setText(sc.nextLine());
        }
    }

    public static void main(String[] args) throws Exception {
        Main obj = new Main();

        Scanner sc = new Scanner(System.in);
        AudioInputStream aud = AudioSystem.getAudioInputStream(new File(<FilePath>).getAbsoluteFile());
        Clip clip= AudioSystem.getClip();
        clip.open(aud);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        int a = sc.nextInt();
    }
    void updateDisplay() {

        Timeclass tc = new Timeclass();
        timer = new Timer(1000, tc);
        initial = System.currentTimeMillis();
        timer.start();
    }

    public class Event implements ActionListener {
        public void actionPerformed(ActionEvent e) {
                try {
                    jbt.setEnabled(false);
                    updateDisplay();
                }
                catch (Exception q){
                }
        }
    }

    public class Timeclass implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            remaining = convertTime();
            long current = System.currentTimeMillis();
            long elapsed = current - initial;
            remaining -= elapsed;

            format = NumberFormat.getNumberInstance();
            format.setMinimumIntegerDigits(2);

            if (remaining < 0)
                remaining = (long) 0;
            int minutes = (int) (remaining / 60000);
            int seconds = (int) ((remaining % 60000) / 1000);
            jltime.setText(format.format(minutes) + ":"
                    + format.format(seconds));

            if (remaining == 0) {
                try {
                    scrEdit();
                    timer.stop();
                }
                catch (Exception q){
                }
            }
        }

        public void scrEdit()throws Exception{
            JFrame frm;
            frm= new JFrame();

            File fileReaddata= new File("datafile.txt");
            File fileRead= new File("score.txt");

            if (fileReaddata.createNewFile()){
            }
            if (fileRead.createNewFile()){
                FileWriter writ = new FileWriter(fileRead);
                writ.write("0");
                writ.close();
            }
            Scanner sc1 = new Scanner(fileReaddata);

            Scanner sc = new Scanner(fileRead);

            LocalDate curnt= LocalDate.now();
            String str = String.valueOf(curnt);
            String[] curntD= str.split("-");
            int date2 = Integer.parseInt(curntD[2]);

            if (sc1.hasNextLine()){
                String p1 = sc1.nextLine();
                String[] arr = p1.split("-");
                int date= Integer.parseInt(arr[2]);
                if (date==30 || date==31 && date2==1){

                    JOptionPane.showMessageDialog(frm,"Congratulation, you earn 10 points");

                    int p = sc.nextInt();
                    int q = p+10;
                    System.out.println(q);

                    FileWriter wrt = new FileWriter("score.txt");
                    wrt.write(String.valueOf(q));
                    wrt.close();

                    FileWriter writ = new FileWriter("datafile.txt");
                    writ.write(String.valueOf(LocalDate.now()));
                    writ.close();
                }

                else if (date2-date>=1|| date-date2>=1){
                    JOptionPane.showMessageDialog(frm,"Congratulation, you earn 10 points");

                    int p =sc.nextInt();
                    int q = p+10;
                    System.out.println(q);

                    FileWriter wrt = new FileWriter("score.txt");
                    wrt.write(String.valueOf(q));
                    wrt.close();

                    FileWriter writ = new FileWriter("datafile.txt");
                    writ.write(String.valueOf(LocalDate.now()));
                    writ.close();
                }

                else {
                    JOptionPane.showMessageDialog(frm,"Congratulation, you done enough");
                }
            }
            else {

                FileWriter writ = new FileWriter("datafile.txt");
                writ.write(String.valueOf(LocalDate.now()));
                writ.close();

                int p = sc.nextInt();
                int q = p+10;

                FileWriter wrt = new FileWriter("score.txt");
                wrt.write(String.valueOf(q));
                wrt.close();
            }
        }
    }
    public void itemStateChanged(ItemEvent ie) {
    }

    public long convertTime() {
        ttime2 = Long.parseLong(ttime);
        long converted = (ttime2 * 60000) + 1000;
        return converted;
    }
}
