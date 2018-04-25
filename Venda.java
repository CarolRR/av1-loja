import java.util.ArrayList;
import java.util.Scanner;

public class Venda {

	public void sale(Scanner sc) {
		ReadCSV listaVenda = new ReadCSV();
		ArrayList listaClientes = listaVenda.readCSVSClientes();
		ArrayList listaProdutos = listaVenda.readCSVProdutos();
		
		if (listaClientes.size() == 0) {
			System.out.println("Sem clientes registrados, por favor adicione clientes antes.");
			return;
		}
		
		if (listaProdutos.size() == 0) {
			System.out.println("Sem produtos registrados, por favor adicione produtos antes.");
		}
		
		Sale dadosDeCompra = new Sale();
		
		System.out.println("Operador de caixa: ");
		String caixa = sc.next();
		dadosDeCompra.setCashierName(caixa);
		
		System.out.println("Selecione o cliente: ");
		for (int i = 0; i < listaClientes.size(); i++) {
			Customer c = (Customer)listaClientes.get(i);
			
			System.out.println("  " + (i+1) + ") Nome: " + c.getName());
		} 
		boolean clientesNaoValidos = true;
		while (clientesNaoValidos) {
			String clientesIn = sc.next();
			int clientesSelecione = Integer.parseInt(clientesIn);
			
			if (clientesSelecione >= 1 && clientesSelecione <= listaClientes.size()) {
				Customer clienteSelecione = (Customer)listaClientes.get(clientesSelecione - 1);
				dadosDeCompra.setCustomerSale(clienteSelecione);
				clientesNaoValidos = false;
			}
			else {
				System.out.println("Seleção de clientes inválida, por favor selecione novamente.");
			}
		}

		System.out.println("Selecione produtos, pressione n para finalizar seleção: ");	
		for (int i = 0; i < listaProdutos.size(); i++) {
			Products p = (Products)listaProdutos.get(i);
			System.out.println("  " + (i + 1) + ") Produto: " + p.getProductName() + "\t Valor: R$" + p.getUnitValue());
		}
		
		boolean adicionarProduto = true;
		while (adicionarProduto) {
			String in  = sc.next();
			if (in.equals("n")) {
				adicionarProduto = false;
			}
			else {
				int selecione = Integer.parseInt(in);
				if (selecione >= 1 && selecione <= listaProdutos.size()) {
					Products p = (Products)listaProdutos.get(selecione-1);
					System.out.print("Selecione a quantidade desejada: ");
					int qnt = sc.nextInt();
					int qntAtual = p.getSaleQnt();
					p.setSaleQnt(qntAtual + qnt);
					dadosDeCompra.addSaleProduct(p);
					System.out.println(qnt + "unidade(s) do produto " + p.getProductName() + " adicionada(s).");
					System.out.println("Selecione outro produto ou pressione n para finalizar a seleção de produtos: ");
				}
				else {
					System.out.println("Seleção de produto inválida.");
				}
			}
		}
		
		float valorTotal = 0;
		for (int i = 0; i < dadosDeCompra.getSaleProducts().size(); i++) {
			Products p = (Products)dadosDeCompra.getSaleProducts().get(i);
			valorTotal = valorTotal +  (p.getSaleQnt() * p.getUnitValue());
			}
		float valorRestante = valorTotal;
		System.out.println("Valor total: " + valorTotal);
		while (valorRestante > 0) {
			System.out.println("Selecione uma ou mais formas de pagamento: ");
			String formaDePagamento = sc.next();
			System.out.println("Valor a ser pago: ");
			float valorParcelado = sc.nextFloat();
			valorRestante = valorRestante - valorParcelado;
			if(valorRestante < 0) valorParcelado = valorParcelado + valorRestante;
			formaDePagamento = formaDePagamento + " - R$" + valorParcelado;
			String pagamentoAtual = dadosDeCompra.getFormaDePagamento();
			dadosDeCompra.setFormaDePagamento(pagamentoAtual + formaDePagamento + "\n");
			if (valorRestante > 0) {
				System.out.println("Selecione outra forma de pagamento, valor restante = R$" + valorRestante);
			}
		}
		
		System.out.println("=======Recibo=======");
		System.out.println(dadosDeCompra.printDateTime());
		System.out.println("Nome do cliente: " + dadosDeCompra.getCustomerSale().getName());
		System.out.println("Operador de caixa: " + dadosDeCompra.getCashierName());
		System.out.println("--Produtos--");
		for (int i = 0; i < dadosDeCompra.getSaleProducts().size(); i++) {
			Products p = (Products)dadosDeCompra.getSaleProducts().get(i);
			System.out.println(p.getSaleQnt() + "x " + p.getProductName() + "\t\t R$" + p.getUnitValue());
		}
		System.out.println("--------------------");
		System.out.println("Valor total: R$ " + valorTotal);
		System.out.println("--------------------");
		System.out.println("Forma(s) de pagamento: \n" + dadosDeCompra.getFormaDePagamento());
		System.out.println("====================");
	}
	
}
