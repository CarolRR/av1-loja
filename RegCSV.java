import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileNotFoundException;

public class RegCSV {

	public void writeProducts (Products p) {
		try {
			
		   String filename = "ProdutosCSV.txt";

			BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true));
			
			writer.append(p.getProductName() + "," + p.getCode() + "," + p.getUnitValue());
			writer.newLine();
		    writer.close();
		}catch(Exception e) {

		}
	}
	
	public void writeCustomer (Customer c) {
		
		try {
		String filename1 = "ClientesCSV.txt";
		
		BufferedWriter writer1 = new BufferedWriter(new FileWriter(filename1, true));
		
		writer1.append(c.getId() + "," + c.getName());
		writer1.newLine();
		writer1.close();
		}catch(Exception e) {
			
		} 
	}

}

