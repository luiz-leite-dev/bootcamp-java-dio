package one.digitalinnovation.gof.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinnovation.gof.model.Cliente;
import one.digitalinnovation.gof.model.ClienteRepository;
import one.digitalinnovation.gof.model.EnderecoRepository;
import one.digitalinnovation.gof.service.ClienteService;

/**
 * Implementação da <b>Strategy</b> {@link ClienteService}, a qual pode ser
 * injetada pelo Spring (via {@link Autowired}). Com isso, como essa classe é um
 * {@link Service}, ela será tratada como um <b>Singleton</b>.
 * 
 * @author falvojr
 */
@Service
public class ClienteServiceImpl implements ClienteService {

	// TODO Singleton: Injetar os componentes do Spring com @Autowired.
	@Autowired 
	private ClienteRepository clienteRepository;

	@Autowired 
	private EnderecoRepository enderecoRepository;

	// TODO Strategy: Implementar os métodos definidos na interface.
	// TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

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
		// FIXME Verificar se o Endereco do Cliente já existe (pelo CEP).
		enderecoRepository.save(cliente.getEndereco());
		// FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno.
		// FIXME Inserir Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// FIXME Buscar Cliente por ID, caso exista:
		// FIXME Verificar se o Endereco do Cliente já existe (pelo CEP).
		// FIXME Caso não exista, integrar com o ViaCEP e persistir o retorno.
		// FIXME Alterar Cliente, vinculando o Endereco (novo ou existente).
		clienteRepository.save(cliente);
	}

	@Override
	public void deletar(Long id) {
		clienteRepository.deleteById(id);
	}

}
