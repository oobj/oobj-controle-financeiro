package br.com.oobj.controlefinanceiro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

@SpringBootApplication
@RestController
@EnableJpaRepositories(basePackages = {"br.com.oobj.controlefinanceiro.repository.support", "br.com.oobj.controlefinanceiro.domain.*.repository"})
@EntityScan(basePackages = {"br.com.oobj.controlefinanceiro.model.support", "br.com.oobj.controlefinanceiro.domain.*.model"})
@ComponentScan(basePackages = "br.com.oobj.controlefinanceiro")
public class ControleFinanceiroApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControleFinanceiroApplication.class, args);
	}
	
	@RequestMapping(path = "/docs", method = RequestMethod.GET)
	public View docsRedirect() {
	      return new RedirectView("swagger-ui.html");
	}
	
}
