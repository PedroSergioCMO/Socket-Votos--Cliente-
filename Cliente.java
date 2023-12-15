import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Cliente {
    public static void main(String[] args) {
        System.out.println("Estabelecendo conexao");
        try {
            Socket socket = new Socket("10.1.1.60", 5555);
            System.out.println("Conexao boa");

            ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream input = new ObjectInputStream(socket.getInputStream());

            String candidato = input.readUTF();
            String votoSTR = JOptionPane.showInputDialog(null, candidato);
            
            output.writeInt(Integer.parseInt(votoSTR));
            output.flush();

            int qtdvotocad1 = input.readInt();
            int qtdvotocad2 = input.readInt();

            System.out.println(qtdvotocad1);
            System.out.println(qtdvotocad2);
            JOptionPane.showMessageDialog(null, "Votos Candidato 1: " + qtdvotocad1);
            JOptionPane.showMessageDialog(null, "Votos Candidato 2: " +qtdvotocad2);
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("erro cliente" + e);
        }
    }
}
