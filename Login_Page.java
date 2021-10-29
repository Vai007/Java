package com.company;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class frmm2 extends Frame{
    void frmm2(){
        setLayout(null);
        setVisible(true);
        setSize(500,600);
        setBackground(Color.lightGray);

        Label l1= new Label("First name:");
        l1.setFont(new Font("font",Font.BOLD,20));
        l1.setBounds(50,70,120,20);
        add(l1);

        Label l2 = new Label("Last name:");
        l2.setFont(new Font("font",Font.BOLD,20));
        l2.setBounds(50,120,120,20);
        add(l2);

        Label l3 = new Label("Password:");
        l3.setFont(new Font("font",Font.BOLD,20));
        l3.setBounds(53,170,120,20);
        add(l3);

        Label l4 = new Label("Re-Type password:");
        l4.setFont(new Font("font",Font.BOLD,20));
        l4.setBounds(50,220,190,20);
        add(l4);

        Label l5 = new Label("Address:");
        l5.setFont(new Font("font",Font.BOLD,20));
        l5.setBounds(50,320,120,20);
        add(l5);

        TextField f1 = new TextField();
        f1.setBounds(180,70,220,20);
        add(f1);

        TextField f2 = new TextField();
        f2.setBounds(180,120,220,20);
        add(f2);

        TextField f3 = new TextField();
        f3.setBounds(180,170,220,20);
        add(f3);

        TextField f4 = new TextField();
        f4.setBounds(180,245,220,20);
        add(f4);

        TextArea f5 = new TextArea();
        f5.setBounds(180,295,250,180);
        add(f5);

        Button btn = new Button("Sign-Up");
        btn.setBounds(220,510,80,40);
        btn.setBackground(Color.pink);
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    File file = new File("datafile.txt");
                    FileWriter wfile = new FileWriter(file,true);
                    if (file.createNewFile()){
                    }
                    else {
                        wfile.write("\nFirst name:"+f1.getText()+"\nLast name:"+f2.getText()+"\nPassword:"+f3.getText()+"\nAddress:"+f5.getText());
                        wfile.close();
                    }
                }
                catch (IOException ex){
                    System.out.println("error occured");
                }
            }
        });

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}

class frmm extends Frame{

    void frmm(){
        setLayout(null);
        setVisible(true);
        setSize(800,500);
        setTitle("Login Form");

        TextField user = new TextField("Username");
        user.setBackground(Color.WHITE);
        user.setBounds(300,180,200,30);
        add(user);

        TextField pass = new TextField("Password");
        pass.setBackground(Color.WHITE);
        pass.setBounds(300,220,200,30);
        add(pass);

        Button btn = new Button("LOGIN");
        btn.setBackground(Color.WHITE);
        btn.setBounds(250,300,80,40);
        add(btn);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a= user.getText();
                String b = pass.getText();
                try {
                    File file= new File("myfile.txt");
                    FileWriter obj2= new FileWriter(file,true);
                    if (file.createNewFile()){
                    }
                    else {
                        obj2.write("Username: "+a+"\nPassword: "+b+"\n");
                        obj2.close();
                    }
                }
                catch (IOException exp){
                    System.out.println("error found");
                }
            }
        });

        Button btn2 = new Button("Sign Up");
        btn2.setBackground(Color.WHITE);
        btn2.setBounds(450,300,80,40);
        add(btn2);
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    frmm2 o= new frmm2();
                    o.frmm2();
            }
        });

        Panel p3 = new Panel();
        p3.setBackground(Color.WHITE);
        p3.setBounds(350,50,100,100);
        add(p3);

        Panel p2 = new Panel();
        p2.setBounds(200,100,400,300);
        p2.setBackground(Color.LIGHT_GRAY);
        add(p2);

        Panel p1 = new Panel();
        p1.setBounds(0,20,800,200);
        p1.setBackground(Color.pink);
        add(p1);

        addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                dispose();
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });
    }
}

public class new1 {
    public static void main(String args[]) throws IOException {

        frmm obj= new frmm();
        obj.frmm();
    }
}