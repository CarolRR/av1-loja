import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Scanner;

public class Menu {
	
	private ProductsReg pr = new ProductsReg();
	private CustomerReg cl = new CustomerReg();
	private Venda venda = new Venda();

	public void displayMenu() {
		
		System.out.println("Bem-vindo!");
		Scanner sc = new Scanner(System.in);
		
		boolean continueLoop = true;

		while (continueLoop) {
			System.out.println("");
			System.out.println("Por favor selecione a opção desejada: ");
			System.out.println("  1) Registrar produto");
			System.out.println("  2) Registrar cliente");
			System.out.println("  3) Realizar compra");
			System.out.println("  4) Saída");
			
			try {
				String in  = sc.next();
				int selecione = Integer.parseInt(in);
				if (selecione == 1) {
					pr.registrarProduto(sc);
				}
				else if (selecione == 2) {
					cl.registrarCliente(sc);
				}
				else if (selecione == 3) {
					venda.sale(sc);
				}
				else if (selecione == 4) {
					continueLoop = false;
				}
				else {
					System.out.println("Opção inválida.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Opção inválida.");
			}
		}
	}		
	
	
	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		menu.displayMenu();

	}

}
