package one.digitalinnovation.gof.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.Endereco;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;
import one.digitalinnovation.gof.service.ViaCepService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	// Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired 
	private ClienteRepository clienteRepository;

	@Autowired 
	private EnderecoRepository enderecoRepository;

	@Autowired 
	private ViaCepService viaCepService;

	// Strategy: Implementar os métodos definidos na interface.
	// Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

	@Override
	public Iterable<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		return clienteRepository.findById(id).orElse(null);
	}

	@Override
	public void inserir(Cliente cliente) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = findEnderecoByCep(cep);
		// Inserir Cliente, vinculando o Endereco (novo ou existente).
		cliente.setEndereco(endereco);
		clienteRepository.save(cliente);
	}

	private Endereco findEnderecoByCep(String cep) {
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		return enderecoRepository.findById(cep).orElseGet(() -> {
			// Caso não exista, integrar com o ViaCEP e persistir o retorno.
			Endereco novoEndereco = viaCepService.consultarCep(cep);
			if (novoEndereco.getCep() == null) throw new RuntimeException("CEP inválido.");
			enderecoRepository.save(novoEndereco);
			return novoEndereco;
		});
	}

	@Override
	public Cliente atualizar(Long id, Cliente cliente) {
		// Buscar Cliente por ID, caso exista:
		String cep = cliente.getEndereco().getCep();
		Cliente clienteAtualizar = clienteRepository.findById(id).orElse(cliente);
		clienteAtualizar.setNome(cliente.getNome());
		// Verificar se o Endereco do Cliente já existe (pelo CEP).
		Endereco endereco = findEnderecoByCep(cep);
		// Alterar Cliente, vinculando o Endereco (novo ou existente).
		clienteAtualizar.setEndereco(endereco);
		return clienteRepository.save(clienteAtualizar);
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

}
