package com.senai.aplication;

import com.senai.interfaces.InterfaceUsuario;
import com.senai.model.Empresa;
import com.senai.model.Produtos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Programa extends JFrame {

    private InterfaceUsuario interfaceUsuario;


    public static void main(String[] args) {
        List<Produtos> listaDeProdutos = new ArrayList<>();
        List<Empresa> listaDeEmpresas = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(listaDeProdutos, listaDeEmpresas);

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Programa telaPrincipal = new Programa(interfaceUsuario);
                telaPrincipal.setVisible(true);
            }
        });
    }


    public Programa(InterfaceUsuario interfaceUsuario) {

        this.interfaceUsuario = interfaceUsuario;

        JButton btnEmpresa = new JButton("Empresa");
        btnEmpresa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaginaEmpresa paginaEmpresa = new PaginaEmpresa(interfaceUsuario);
                paginaEmpresa.mostrar();
            }
        });

        JButton btnCliente = new JButton("Cliente");
        btnCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                PaginaCliente paginaCliente = new PaginaCliente(interfaceUsuario);
                paginaCliente.mostrar();
            }
        });

        


        getContentPane().setLayout(new GridLayout(2, 1));
        getContentPane().add(btnEmpresa);
        getContentPane().add(btnCliente);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);
    }


}






