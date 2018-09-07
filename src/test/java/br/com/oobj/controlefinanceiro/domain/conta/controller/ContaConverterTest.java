package br.com.oobj.controlefinanceiro.domain.conta.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.oobj.controlefinanceiro.ControleFinanceiroTestContext;
import br.com.oobj.controlefinanceiro.domain.conta.model.Conta;
import br.com.oobj.controlefinanceiro.domain.usuario.model.Usuario;

/**
 * Testes unitários da classe {@link ContaConverter}.
 * 
 * @author Danilo Guimarães
 *
 */
@SpringBootTest
@ContextConfiguration(classes = { ControleFinanceiroTestContext.class })
@RunWith(SpringRunner.class)
public class ContaConverterTest {
	
	private static final Long CONTA_ID = 1L;
	private static final String CONTA_NOME = "Conta 2";
	private static final BigDecimal CONTA_SALDO_INICIAL = new BigDecimal("15.99");
	private static final Usuario CONTA_USUARIO = new Usuario();

	@Autowired
	private ContaConverter sut;
	
	@BeforeClass
	public static void init() {
		CONTA_USUARIO.setLogin("daniloguimaraes");
	}
	
	@Test
	public void testContaConverterNaoPodeSerNulo() {
		assertThat(sut).isNotNull();
	}
	
	@Test
	public void testConvertToEntity() {
		ContaDTO dto = buildDTO();
		Conta entity = sut.convertToEntity(dto);
		
		assertThat(entity.getId()).isEqualTo(CONTA_ID);
		assertThat(entity.getNome()).isEqualTo(CONTA_NOME);
		assertThat(entity.getSaldoInicial()).isEqualTo(CONTA_SALDO_INICIAL);
		assertThat(entity.getUsuario().getLogin()).isEqualTo(CONTA_USUARIO.getLogin());
	}
	
	@Test
	public void testConvertToDTO() {
		Conta entity = buildEntity();
		ContaDTO dto = sut.convertToDTO(entity);
		
		assertThat(dto.getId()).isEqualTo(CONTA_ID);
		assertThat(dto.getNome()).isEqualTo(CONTA_NOME);
		assertThat(dto.getUsuario()).isEqualTo(CONTA_USUARIO.getLogin());		
	}
	
	@Rule
	public ExpectedException illegalArgumentEx = ExpectedException.none();
	
	@Test
	public void testConvertToEntityAoPassarDTONuloDeveLancarIllegalArgumentException() {
		illegalArgumentEx.expect(IllegalArgumentException.class);
		illegalArgumentEx.expectMessage("O DTO nao pode ser nulo");
		
		sut.convertToEntity(null);
	}
	
	@Test
	public void testConvertToDTOAoPassarEntidadeNulaDeveLancarIllegalArgumentException() {
		illegalArgumentEx.expect(IllegalArgumentException.class);
		illegalArgumentEx.expectMessage("A entidade nao pode ser nula");
		
		sut.convertToDTO(null);
	}
	
	private ContaDTO buildDTO() {
		ContaDTO contaDTO = new ContaDTO();
		
		contaDTO.setId(CONTA_ID);
		contaDTO.setNome(CONTA_NOME);
		contaDTO.setUsuario(CONTA_USUARIO.getLogin());
		contaDTO.setSaldoInicial(CONTA_SALDO_INICIAL);
		
		return contaDTO;
	}
	
	private Conta buildEntity() {
		Conta conta = new Conta();
		
		conta.setId(CONTA_ID);
		conta.setNome(CONTA_NOME);
		conta.setUsuario(CONTA_USUARIO);
		conta.setSaldoInicial(CONTA_SALDO_INICIAL);
		
		return conta;
	}
}
