//package com.senai.aplication;
//
//import com.senai.model.Empresa;
//import com.senai.interfaces.InterfaceUsuario;
//import com.senai.model.Produtos;
//
//import javax.swing.*;
//import java.util.ArrayList;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.util.List;
//import java.util.Scanner;
//
//public class Backup {
//    public static void main(String[] args) {
//        Scanner kb = new Scanner(System.in);
//        List<Produtos> ListaDeProdutos = new ArrayList<>();
//        List<Empresa> ListaDeEmpresas = new ArrayList<>();
//        InterfaceUsuario interfaceUsuario = new InterfaceUsuario(ListaDeProdutos,ListaDeEmpresas);
//
//        JFrame frame = new JFrame("Gestão de Estoque");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(600, 500);
//
//
//        JPanel menuPanel = new JPanel();
//        menuPanel.setLayout(new GridLayout(5,1));
//
//
//
//        JButton cadastreUserCompanyEmployeeButton = new JButton("Cadastre-se");
//        cadastreUserCompanyEmployeeButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                interfaceUsuario.cadastreUserCompanyEmployee();
//            }
//        });
//
//        JButton cadastrarProdutoButton = new JButton("Cadastrar Produto");
//        cadastrarProdutoButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                interfaceUsuario.cadastrarProduto();
//            }
//        });
//
//        JButton calcVMDButton = new JButton("Calcular VMD");
//        calcVMDButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                interfaceUsuario.calcVMD();
//            }
//        });
//
//        JButton verificarEstoqueButton = new JButton("Verificar Estoque");
//        verificarEstoqueButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                interfaceUsuario.verificarEstoque();
//            }
//        });
//
//
//        JButton listaProdutosButton = new JButton("Lista de Produtos");
//        listaProdutosButton.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//
//
//                interfaceUsuario.listagem();
//            }
//
//        });
//
//
//
//
//        menuPanel.add(cadastreUserCompanyEmployeeButton);
//        menuPanel.add(cadastrarProdutoButton);
//        menuPanel.add(calcVMDButton);
//        menuPanel.add(verificarEstoqueButton);
//        menuPanel.add(listaProdutosButton);
//
//        frame.add(menuPanel);
//        frame.setVisible(true);
//
//    }
//}
//
