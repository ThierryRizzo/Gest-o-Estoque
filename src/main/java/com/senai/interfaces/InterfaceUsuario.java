package com.senai.interfaces;

import com.senai.model.Cliente;
import com.senai.model.Empresa;
import com.senai.model.Funcionario;
import com.senai.model.Produtos;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InterfaceUsuario {

    public List<Produtos> listaDeProdutos;
    public List<Empresa> listaDeEmpresas;

    public InterfaceUsuario(List<Produtos> ListaDeProdutos, List<Empresa> ListaDeEmpresas) {
        this.listaDeProdutos = ListaDeProdutos;
        this.listaDeEmpresas = ListaDeEmpresas;
    }

    public InterfaceUsuario(List<Empresa> ListaDeEmpresas) {
        this.listaDeEmpresas = ListaDeEmpresas;
    }

    public void verificarEstoque() {
        if (listaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JComboBox<String> produtosComboBox = new JComboBox<>();
            for (Produtos products : listaDeProdutos) {
                produtosComboBox.addItem(products.getNome());
            }
            int result = JOptionPane.showConfirmDialog(null, produtosComboBox,
                    "Selecione um produto: ",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                int indiceProdutoSelecionado = produtosComboBox.getSelectedIndex();
                Produtos produtoSelecionado = listaDeProdutos.get(indiceProdutoSelecionado);
                if (produtoSelecionado.getVendaMedia() == 0) {
                    JOptionPane.showMessageDialog(null, "Calcule a venda média diária deste produto " +
                                    "primeiro!",
                            "ERROR", JOptionPane.ERROR_MESSAGE);
                } else {

                    produtoSelecionado.calcEstoqueMin();
                    produtoSelecionado.calcEstoqueMax();
                    produtoSelecionado.decisao((int) produtoSelecionado.getEstoqueMin(),
                            (int) produtoSelecionado.getEstoqueMax(),
                            (int) produtoSelecionado.getEstoqueAtual());
                    JOptionPane.showMessageDialog(null, "Produto: " +
                            produtoSelecionado.getNome() + "\nEstoque Atual: " + produtoSelecionado.getEstoqueAtual() +
                            "\nEstoque Mínimo: " + produtoSelecionado.getEstoqueMin() + "\nEstoque " +
                            "Máximo: " + produtoSelecionado.getEstoqueMax() + "\nTomada de decisão: " + produtoSelecionado.getMensagemCompra());
                }
            }

        }
    }

    public void cadastrarProduto() {
        Produtos produto = new Produtos();


        String nomeProduto =  JOptionPane.showInputDialog("Informe o nome do produto:");
        produto.setNome(nomeProduto);

        int estoqueAtual = Integer.parseInt(JOptionPane.showInputDialog("Informe o estoque " +
                "atual do produto "
                + produto.getNome() + ":"));
        produto.setEstoqueAtual(estoqueAtual);

        int tempoRepo = Integer.parseInt(JOptionPane.showInputDialog("Informe o tempo de " +
                "reposição do produto "
                + produto.getNome() + " em dias:"));
        produto.setTempoRepo(tempoRepo);

        int loteRepo = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade no " +
                "lote de reposição do produto "
                + produto.getNome()));
        produto.setLoteRepo(loteRepo);

        double precoProduto = Double.parseDouble(JOptionPane.showInputDialog("Informe o preço do " +
                "produto: " + produto.getNome()));
        produto.setPreco(precoProduto);

        String produtoReview;
        produtoReview =
                ("Produto: " + produto.getNome() + " \n" + "Preço: R$" + produto.getPreco() +
                        " \n" + "Estoque Atual: " + produto.getEstoqueAtual() + ".un" + " \n" +
                        "Lote " +
                        "de Reposição: "
                        + produto.getLoteRepo() + ".un" + " \n" + "Tempo de Reposição: " + produto.getTempoRepo() + " Dias");

        JOptionPane.showMessageDialog(null, "" + produtoReview,
                "Review", JOptionPane.INFORMATION_MESSAGE);


        JOptionPane.showMessageDialog(null,
                "Produto Cadastrado com sucesso!");
        listaDeProdutos.add(produto);
    }

    public void calcVMD() {

        if (listaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            JComboBox<String> produtosComboBox = new JComboBox<>();
            for (Produtos product : listaDeProdutos) {
                produtosComboBox.addItem(product.getNome());
            }

            int result = JOptionPane.showConfirmDialog(null, produtosComboBox,
                    "Selecione um produto: ",
                    JOptionPane.OK_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                int indiceProdutoSelecionado = produtosComboBox.getSelectedIndex();
                Produtos produtoSelecionado = listaDeProdutos.get(indiceProdutoSelecionado);

                for (int i = 0; i < 3; i++) {
                    int mes123 = Integer.parseInt(JOptionPane.showInputDialog(null,
                            "Unidades vendidas de " + produtoSelecionado.getNome() +
                                    " no " + (i + 1) + "º mês:", "vendas no mês",
                            JOptionPane.INFORMATION_MESSAGE));
                    produtoSelecionado.setMeses(i, mes123);
                }
                produtoSelecionado.calcVendaMedia();
                JOptionPane.showMessageDialog(null,
                        "Venda média diária: \n" + produtoSelecionado.getVendaMedia());

            }
        }
    }

    public void listagem() {
        if (listaDeProdutos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum produto cadastrado!",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            String produtosCadastrados = "Produtos cadastrados:\n";
            for (Produtos prod : listaDeProdutos) {
                produtosCadastrados += "\nNome: " + prod.getNome() + "\nEstoque Atual: " +
                        prod.getEstoqueAtual() + "\nPreço: R$" + prod.getPreco();
            }
            JOptionPane.showMessageDialog(null, produtosCadastrados,
                    "Lista de Produtos", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void cadastreUserCompanyEmployee() {
        int opt;

        Object[] option = {"Cliente", "Funcionário", "Empresa"};
        opt = JOptionPane.showOptionDialog(null, "Escolha uma opção",
                "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE,
                null, option, null);

        if (opt == 0) {
            Cliente cliente = new Cliente();
            String nome = JOptionPane.showInputDialog(null,
                    "Informe o seu nome:", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
            cliente.setNome(nome);

            String sobrenome = JOptionPane.showInputDialog(null,
                    "Informe o seu " +
                            "Sobrenome:", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
            cliente.setSobrenome(sobrenome);

            String endereco = JOptionPane.showInputDialog(null,
                    "Informe o seu " +
                            "Endereço:", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
            cliente.setEndereco(endereco);

            long cpf = Long.parseLong(JOptionPane.showInputDialog(null,
                    "Informe o seu CPF:", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE));
            cliente.setCpf(cpf);

            String userReview;
            userReview = ("Nome: " + cliente.getNome() + " \n" + "Sobrenome: " +
                    cliente.getSobrenome() + " \n" +
                    "Cpf: " + cliente.getCpf() + "\n" + "Endereço: " + cliente.getEndereco());
            JOptionPane.showMessageDialog(null, "" + userReview,
                    "Review", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                    "Usuário Cadastrado com sucesso!");
        } else if (opt == 1) {
            if (listaDeEmpresas.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nenhuma Empresa cadastrada!",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {

                Funcionario funcionario = new Funcionario();
                String nome = JOptionPane.showInputDialog(null,
                        "Informe o seu nome:", "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
                funcionario.setNome(nome);

                String sobrenome = JOptionPane.showInputDialog(null,
                        "Informe o seu " +
                                "Sobrenome:", "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE);
                funcionario.setSobrenome(sobrenome);

                long cpf = Long.parseLong(JOptionPane.showInputDialog(null,
                        "Informe o seu CPF:", "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE));
                funcionario.setCpf(cpf);

                long nit = Long.parseLong(JOptionPane.showInputDialog(null,
                        "Informe o seu NIT:", "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE));
                funcionario.setNit(nit);

                long telefone = Long.parseLong(JOptionPane.showInputDialog(null,
                        "Informe o seu Telefone:", "Cadastro",
                        JOptionPane.INFORMATION_MESSAGE));
                funcionario.setTelefone(telefone);

                JComboBox<String> empresasComboBox = new JComboBox<>();
                for (Empresa empresa : listaDeEmpresas) {
                    empresasComboBox.addItem(empresa.getNome());
                }

                int resultado = JOptionPane.showConfirmDialog(null, empresasComboBox,
                        "Selecione a empresa em que o funcionário trabalha:",
                        JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
                if (resultado == JOptionPane.OK_OPTION) {
                    int indiceEmpresaSelecionada = empresasComboBox.getSelectedIndex();

                    Empresa empresaSelecionada = listaDeEmpresas.get(indiceEmpresaSelecionada);
                    funcionario.setEmpresa(empresaSelecionada);


                    String userReview;
                    userReview = ("Nome: " + funcionario.getNome() + " \n" + "Sobrenome: " +
                            funcionario.getSobrenome() + " \n" +
                            "Cpf: " + funcionario.getCpf() + "\n" + "NIT: " + funcionario.getNit() + "\n" +
                            "Empresa: " + funcionario.getEmpresa());
                    JOptionPane.showMessageDialog(null, "" + userReview,
                            "Review", JOptionPane.INFORMATION_MESSAGE);

                    JOptionPane.showMessageDialog(null,
                            "Funcionário Cadastrado com sucesso!");

                }
            }
        } else if (opt == 2) {

            Empresa empresa = new Empresa();
            String nome = JOptionPane.showInputDialog(null,
                    "Informe o nome da Empresa:", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
            empresa.setNome(nome);

            String endereco = JOptionPane.showInputDialog(null,
                    "Informe o Endereço:", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE);
            empresa.setEndereco(endereco);

            long cnpj = Long.parseLong(JOptionPane.showInputDialog(null,
                    "Informe o CNPJ: ", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE));
            empresa.setCnpj(cnpj);

            long telefone = Long.parseLong(JOptionPane.showInputDialog(null,
                    "Informe o Telefone: ", "Cadastro",
                    JOptionPane.INFORMATION_MESSAGE));
            empresa.setTelefone(telefone);

            String userReview;
            userReview = ("Nome: " + empresa.getNome() + " \n" + "CNPJ: " + empresa.getCnpj() +
                    "\n" + "Endereço:" + empresa.getEndereco() + "\n" + "Telefone:" + empresa.getTelefone());
            JOptionPane.showMessageDialog(null, "" + userReview,
                    "Review", JOptionPane.INFORMATION_MESSAGE);

            JOptionPane.showMessageDialog(null,
                    "Empresa Cadastrada com sucesso!");
            listaDeEmpresas.add(empresa);

        }

    }

    public void comprar(){

        DefaultListModel<String> listModel = new DefaultListModel<>();
        JList<String> productList = new JList<>(listModel);

        JPanel panel = new JPanel(new BorderLayout());


        JFrame frame = new JFrame("Lista de Produtos");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.add(panel);
        frame.setVisible(true);

        for (Produtos produto : listaDeProdutos) {
            listModel.addElement(produto.getNome() + " - R$" + produto.getPreco());
        }

        JButton calculateButton = new JButton("Calcular Total");
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                List<String> selectedProducts = productList.getSelectedValuesList();
                double totalValue = 0.0;
                for (String selectedProduct : selectedProducts) {
                    String[] parts = selectedProduct.split(" - R\\$");
                    if (parts.length == 2) {
                        totalValue += Double.parseDouble(parts[1]);
                    }
                }
                JOptionPane.showMessageDialog(null, "Valor Total: R$" + totalValue);
            }

        });
        panel.add(new JScrollPane(productList), BorderLayout.CENTER);
        panel.add(calculateButton, BorderLayout.SOUTH);


    }
}


