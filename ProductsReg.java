import java.util.Scanner;

public class ProductsReg {

	public void registrarProduto(Scanner sc) {

		Products newProduct = new Products();

		System.out.println("Nome do produto: ");
		String name = sc.next();

		System.out.println("Valor unidade: R$ ");
		Float value = sc.nextFloat();

		System.out.println("Código do produto: ");
		String code = sc.next();

		newProduct.setCode(code);
		newProduct.setProductName(name);
		newProduct.setUnitValue(value);

		RegCSV writer = new RegCSV();
		writer.writeProducts(newProduct);
		
		System.out.println("Produto registrado.");
	}
}
