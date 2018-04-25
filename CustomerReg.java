import java.util.Scanner;

public class CustomerReg {

	public void registrarCliente(Scanner sc) {
		Customer newCustomer = new Customer();
		
		System.out.println("CPF: ");
		String id = sc.next();
		
		System.out.println("Nome do cliente: ");
		String name = sc.next();
		
		System.out.println("Cliente registrado.");
		
		newCustomer.setId(id);
		newCustomer.setName(name);
		
		RegCSV writer1 = new RegCSV();
		writer1.writeCustomer(newCustomer);
	}

}
