package com.senai.aplication;

import javax.swing.*;
import com.senai.interfaces.InterfaceUsuario;
import com.senai.model.Empresa;
import com.senai.model.Produtos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PaginaCliente extends JFrame {
    private InterfaceUsuario interfaceUsuario;

    public PaginaCliente(InterfaceUsuario interfaceUsuario) {
        this.interfaceUsuario = interfaceUsuario;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(600, 500);

        JPanel clientePanel = new JPanel();
        clientePanel.setLayout(new GridLayout(3, 1));

        JButton btnComprar = new JButton("Comprar");
        btnComprar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                interfaceUsuario.comprar();
            }
        });

        JButton btnVoltar = new JButton("Voltar");
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                Programa telaPrincipal = new Programa(interfaceUsuario);
                telaPrincipal.setVisible(true);
            }
        });

        clientePanel.add(btnComprar);
        clientePanel.add(btnVoltar);
        add(clientePanel);
    }
    public void mostrar() {
        setVisible(true);
    }

    public static void main(){
        List<Produtos> listaDeProdutos = new ArrayList<>();
        List<Empresa> listaDeEmpresas = new ArrayList<>();
        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(listaDeProdutos, listaDeEmpresas);

        PaginaCliente paginaCliente = new PaginaCliente(interfaceUsuario);
        paginaCliente.mostrar();

    }
}
