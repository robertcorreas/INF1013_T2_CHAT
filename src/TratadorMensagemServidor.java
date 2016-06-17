import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class TratadorMensagemServidor implements Runnable {
	private Socket cliente;

	public TratadorMensagemServidor() {

	}

	@Override
	public void run() {
		Scanner in_serv;
		try {
			in_serv = new Scanner(cliente.getInputStream());
			while (in_serv.hasNextLine()) {
				System.out.println(in_serv.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void setSocket(Socket socket) {
		this.cliente = socket;

	}
}
