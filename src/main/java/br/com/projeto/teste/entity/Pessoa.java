package br.com.projeto.teste.entity;

public class Pessoa {
	private String nome, cargo;
	private int idade;
	private int id = 0;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Id: " + this.id + " | Nome: " + this.nome + " | Idade: " + this.idade + " | Cargo: " + this.cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return this.id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null) return false;
	    if (!(obj instanceof Pessoa))
	        return false;
	    if (obj == this)
	        return true;
	    return this.getId() == ((Pessoa) obj).getId();
	}
}
