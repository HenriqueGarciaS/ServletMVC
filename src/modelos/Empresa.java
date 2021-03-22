package modelos;

import java.util.Date;

public class Empresa {

	private int id;
	private String nome;
	private Date dataAbertura;
		
	public Empresa(String nome, Date dataAbertura) {
		this.nome = nome;
		this.dataAbertura = dataAbertura;
	}
		
	public int getId() {
		return this.id;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public Date getDataAbertura() {
		return this.dataAbertura;
	}
	
	public void setDataAbertura(Date data) {
		this.dataAbertura = data;
		
	}
	
	public void diminuiId() {
		this.id--;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
