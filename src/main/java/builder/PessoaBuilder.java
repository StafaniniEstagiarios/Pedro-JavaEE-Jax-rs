package builder;

import br.com.projeto.teste.entity.Endereco;
import br.com.projeto.teste.entity.Pessoa;
import dto.PessoaDTO;

public class PessoaBuilder {
	public Pessoa builder(PessoaDTO pessoaDTO) {
		Pessoa pessoa = new Pessoa();
		pessoa.setId(pessoaDTO.getId());
		pessoa.setCargo(pessoaDTO.getCargo());
		pessoa.setNome(pessoaDTO.getNome());
		pessoa.setIdade(pessoa.getIdade());
		
		Endereco endereco = new Endereco();
		endereco.setBairro(pessoaDTO.getBairro());
		endereco.setCep(pessoaDTO.getCep());
		endereco.setComplemento(pessoaDTO.getComplemento());
		endereco.setNumero(pessoaDTO.getNumero());
		endereco.setRua(pessoaDTO.getRua());
		
		pessoa.setEndereco(endereco);
		
		return pessoa;
	}
}
