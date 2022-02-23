import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu {
    JFrame frame;
    Arquivo arquivo;
    Documentacao documentacao;
    Sobre sobreA;

    public Menu() {
        frame = new JFrame("Editor de Texto");
        arquivo= new Arquivo();
        documentacao = new Documentacao();
        sobreA = new Sobre();

        JMenuBar menuBar = new JMenuBar();

        JMenu menuArquivo = new JMenu("Arquivo"); //Opções de interação com o arquivo txt
        JMenuItem criar = new JMenuItem("Criar");
        JMenuItem abrir = new JMenuItem("Abrir");
        JMenuItem salvar = new JMenuItem("Salvar");

        criar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arquivo.novoArquivo();
            }
        });
        abrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arquivo.abrirArquivo(frame);
            }
        });
        salvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arquivo.salvarArquivo(frame);
            }
        });

        menuArquivo.add(criar);
        menuArquivo.add(abrir);
        menuArquivo.add(salvar);

        JMenu menuAjuda = new JMenu("Ajuda"); //Opções do menu ajuda
        JMenuItem doc = new JMenuItem("Documentação");
        JMenuItem sobre = new JMenuItem("Sobre");

        doc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                documentacao.AbrirDocumentacao();
            }
        });
        sobre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sobreA.AbrirSobre();
            }
        });

        menuAjuda.add(doc);
        menuAjuda.add(sobre);

        JMenuItem fechar = new JMenuItem("Fechar"); //Fechar o programa
        fechar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                arquivo.fecharTela(frame);
            }
        });

        menuBar.add(menuArquivo);
        menuBar.add(menuAjuda);
        menuBar.add(fechar);

        frame.setJMenuBar(menuBar);
        frame.add(arquivo.getAreaTexto());
        frame.setSize(600, 600);
        frame.show();
    }

    public static void main (String args[]){ //main
        Menu e = new Menu();
    }

}