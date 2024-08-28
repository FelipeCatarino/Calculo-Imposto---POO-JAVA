package entities;

public class PessoaJuridica extends Pessoas{
	
	private int numeroFuncionarios;

	public PessoaJuridica() {
		
	}
	
	public PessoaJuridica(String nome, Double rendaAnual, int numeroFuncionarios) {
		super(nome, rendaAnual);
		this.numeroFuncionarios = numeroFuncionarios;
	}

	public int getNumeroFuncionarios() {
		return numeroFuncionarios;
	}

	public void setNumeroFuncionarios(int numeroFuncionarios) {
		this.numeroFuncionarios = numeroFuncionarios;
	}
	
	@Override
	public final double TotalImposto() {
		double value = 0.0;
		
		if (numeroFuncionarios <= 10 ) {
			value = getRendaAnual() * 0.16; 
			return value;
		}else if(numeroFuncionarios > 10){
			value = getRendaAnual() * 0.14;
		}
		return value;
	}
	
}
