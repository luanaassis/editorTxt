import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class Arquivo {
    JTextArea areaTexto;
    JFileChooser chooser;

    public Arquivo(){
        areaTexto = new JTextArea();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Text files", "txt"); // filtro para arquivos txt
        chooser = new JFileChooser("c:");
        chooser.setFileFilter(filtro);
    }

    public JTextArea getAreaTexto() {
        return areaTexto;
    }

    public void novoArquivo () { // Novo arquivo
        areaTexto.setText("");
    }

    public void salvarArquivo (JFrame tela){ // Salvar arquivo
        int resposta = chooser.showSaveDialog(null);
        if (resposta == JFileChooser.APPROVE_OPTION) {
            File arquivo = new File(chooser.getSelectedFile().getAbsolutePath());
            try {
                FileWriter escreveArquivo = new FileWriter(arquivo, false);
                BufferedWriter writerLines = new BufferedWriter(escreveArquivo);
                writerLines.write(areaTexto.getText());
                writerLines.flush();
                writerLines.close();
            } catch (Exception evt) {
                JOptionPane.showMessageDialog(tela, evt.getMessage());
            }
        }
    }

    public void abrirArquivo(JFrame tela){ // Abrir arquivo
        int resposta = chooser.showOpenDialog(null);
        if (resposta == JFileChooser.APPROVE_OPTION) {
            File arquivo = new File(chooser.getSelectedFile().getAbsolutePath());
            try {
                String linha;
                FileReader lerArquivo = new FileReader(arquivo);
                BufferedReader lerLinhas = new BufferedReader(lerArquivo);
                String texto = lerLinhas.readLine();

                while ((linha = lerLinhas.readLine()) != null) {
                    texto = texto + ("\n") + linha;
                }

                areaTexto.setText(texto);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(tela, ex.getMessage());
            }
        }
    }

    public void fecharTela (JFrame tela){ //fechar tela
        tela.dispose();
    }
}
