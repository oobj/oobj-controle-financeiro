package br.com.oobj.controlefinanceiro.domain.lancamento.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.junit4.SpringRunner;

import com.google.common.collect.Lists;

import br.com.oobj.controlefinanceiro.ControleFinanceiroTestContext;
import br.com.oobj.controlefinanceiro.domain.lancamento.model.Lancamento;

@SpringBootTest
@ContextConfiguration(classes = { ControleFinanceiroTestContext.class })
@RunWith(SpringRunner.class)
@Sql(scripts = "/datasets/create-schema.sql")
@Sql(scripts = "/datasets/drop-schema.sql", executionPhase = ExecutionPhase.AFTER_TEST_METHOD)
public class LancamentoRepositoryTest {
	
	@Autowired
	private LancamentoRepository repository;
	
	@Autowired
	private DataSource dataSource;
	
	@Test
	public void testWhatever() throws Exception {
		Iterable<Lancamento> all = repository.findAll();
		
		List<Lancamento> l = Lists.newArrayList(all);
		
		assertThat(l.size()).isEqualTo(0);
	}
	

}
