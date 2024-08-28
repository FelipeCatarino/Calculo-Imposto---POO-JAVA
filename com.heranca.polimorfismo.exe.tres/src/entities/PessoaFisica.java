package entities;

public class PessoaFisica extends Pessoas{
	
	private Double gastosSaude;

	public PessoaFisica(String nome, Double rendaAnual, Double gastosSaude) {
		super(nome, rendaAnual);
		this.gastosSaude = gastosSaude;
	}

	public Double getGastosSaude() {
		return gastosSaude;
	}

	public void setGastosSaude(Double gastosSaude) {
		this.gastosSaude = gastosSaude;
	}
	
	@Override
	public double TotalImposto() {
		double value;
		double desconto = gastosSaude * 0.50;
		
		if (getRendaAnual() < 2000.00) {
			value = getRendaAnual() * 0.15 - desconto; 
			return value;
		}else {
			value = getRendaAnual() * 0.25 - desconto;
		}
		return value;
	}
	
}
