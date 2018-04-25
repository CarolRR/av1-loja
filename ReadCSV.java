import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class ReadCSV {

	public ArrayList readCSVProdutos() {
		File arquivoCSV = new File("ProdutosCSV.txt");

		try {
			Scanner sc = new Scanner(arquivoCSV);
			String linhas = new String();

			ArrayList productsList = new ArrayList();
			while (sc.hasNext()){
				Products meup = new Products();
				linhas = sc.nextLine();
				if(!linhas.contains(",")) continue;
				
				String[] valoresEntreVirgulas = linhas.split(",");
				String name = valoresEntreVirgulas[0];
				String code = valoresEntreVirgulas[1];
				float value = Float.parseFloat(valoresEntreVirgulas[2]) ;
				
//				System.out.println(linhas);
				meup.setCode(code);
				meup.setProductName(name);
				meup.setUnitValue(value);
				
				productsList.add(meup);
			}
//			System.out.println("size produtos=" + productsList.size());
			sc.close();
			return productsList;
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	public ArrayList readCSVSClientes() {
		File arquivoCSV1 = new File("ClientesCSV.txt");

		try {
			Scanner sc = new Scanner(arquivoCSV1);
			String linhas1 = new String();

			ArrayList customerList = new ArrayList();
			while (sc.hasNext()){
				Customer meuc = new Customer();
				linhas1 = sc.nextLine();
				if(!linhas1.contains(",")) continue;
				
				String[] valoresEntreVirgulas1 = linhas1.split(",");
				String id = valoresEntreVirgulas1[0];
				String name = valoresEntreVirgulas1[1];

//				System.out.println(linhas1);
				
				meuc.setId(id);
				meuc.setName(name);

				customerList.add(meuc);
			}
//			System.out.println("size clientes=" + customerList.size());
			sc.close();
			return customerList;
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
	}
}

