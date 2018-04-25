
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Sale {
	
	private String cashierName;
	private ArrayList saleProducts;
	private Customer customerSale;
	private Calendar saleDateTime;
	private String formaDePagamento;
	
	public Sale() {
		saleDateTime = Calendar.getInstance(); 
		saleProducts = new ArrayList();
		formaDePagamento = "";
	}
	
	public String printDateTime() { 
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss"); 
		return dateFormat.format(saleDateTime.getTime()); 
	}
	


	public String getCashierName() {
		return cashierName;
	}

	public void setCashierName(String cashierName) {
		this.cashierName = cashierName;
	}

	public Customer getCustomerSale() {
		return customerSale;
	}

	public void setCustomerSale(Customer customerSale) {
		this.customerSale = customerSale;
	}

	public ArrayList getSaleProducts() {
		return saleProducts;
	}

	public void setSaleProducts(ArrayList saleProducts) {
		this.saleProducts = saleProducts;
	}
	
	public void addSaleProduct(Products product) {
		this.saleProducts.add(product);
	}

	public String getFormaDePagamento() {
		return formaDePagamento;
	}

	public void setFormaDePagamento(String formaDePagamento) {
		this.formaDePagamento = formaDePagamento;
	}
}			
