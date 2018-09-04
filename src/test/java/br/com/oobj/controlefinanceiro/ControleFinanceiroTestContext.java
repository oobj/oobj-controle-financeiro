package br.com.oobj.controlefinanceiro;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@ActiveProfiles("test")
@TestConfiguration
@TestPropertySource(locations = "classpath:application-test.properties")
public class ControleFinanceiroTestContext {

}
