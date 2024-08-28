package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.PessoaFisica;
import entities.PessoaJuridica;
import entities.Pessoas;

public class App {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Pessoas> lista = new ArrayList<>();
		
		System.out.print("Enter the number of tax payers");
		int qtd = sc.nextInt();
		 sc.nextLine();  // Consome a quebra de linha pendente
		
		for(int i = 0; i < qtd; i++) {
			
			System.out.println("Tax payer #" + (i + 1) + " data");
			
			System.out.print("Individual or Company (i/c)? ");
			char select = sc.nextLine().charAt(0);
			
			System.out.print("Name: ");
			String name = sc.nextLine();
		
			System.out.print("Anual income: ");
			double anualIncome = sc.nextDouble();

			if(select == 'i') {
				System.out.print("Health expeditures: ");
				double gastoSaude = sc.nextDouble();
				
				lista.add(new PessoaFisica(name, anualIncome, gastoSaude));
				
			}
			else if(select == 'c') {
				System.out.print("Number of employees: ");
				int numeroFuncionarios = sc.nextInt();
				
				lista.add(new PessoaJuridica(name, anualIncome, numeroFuncionarios));
			}
			 sc.nextLine();  // Consome a quebra de linha pendente
		
		}
		double soma = 0.0;
		System.out.println();
		System.out.println("TAXES PAID");
		for(Pessoas x : lista) {

			if(x instanceof PessoaFisica) {
				PessoaFisica pf = (PessoaFisica) x;
				System.out.printf("%s: $ %.2f \n" , x.getNome(), pf.TotalImposto());
				soma += pf.TotalImposto();
				
			}else if(x instanceof PessoaJuridica) {
				PessoaJuridica pj = (PessoaJuridica) x;
				System.out.printf("%s: $ %.2f \n" , x.getNome(), pj.TotalImposto());
				soma += pj.TotalImposto();
			}
		
		}
		System.out.println();
		System.out.printf("TOTAL TAXES: $ %.2f", soma);
		
		sc.close();
	}

}
