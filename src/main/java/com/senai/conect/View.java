package com.senai.conect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;

public class View extends JFrame {

    Banco banco = new Banco();
    private Connection con;

    private static final long seriaLVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    View frame = new View();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    public View() {
        addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowActivated(WindowEvent e) {
                //super.windowActivated(e);
                status();
            }
        });

        setTitle("view");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 360);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
    }

    private void status() {
        try {
            con = (Connection) banco.conectar();
            if (con == null) {
                System.out.println("Erro de conexão");

            } else {
                System.out.println("Banco de dados conectado");

            }
            con.close();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    }
}
