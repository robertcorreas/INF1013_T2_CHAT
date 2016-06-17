import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket cli = new Socket("139.82.3.74", 5500);
		System.out.println("O cliente se conectou ao servidor!");
		
		TratadorMensagemServidor tratador = new TratadorMensagemServidor();
		tratador.setSocket(cli);
		
		Thread t = new Thread(tratador);
		t.start();
		
		Scanner teclado = new Scanner(System.in);
		PrintStream saida = new PrintStream(cli.getOutputStream());
		String msg = teclado.nextLine();
		while (msg.compareTo("###") != 0) {
			saida.println(msg);
			msg = teclado.nextLine();
		}
		saida.close();
		teclado.close();
		cli.close();
		System.out.println("O cliente terminou de executar!");

	}

}
