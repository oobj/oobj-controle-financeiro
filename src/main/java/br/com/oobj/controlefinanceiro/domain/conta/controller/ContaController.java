package br.com.oobj.controlefinanceiro.domain.conta.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.oobj.controlefinanceiro.domain.conta.model.Conta;
import io.swagger.annotations.Api;

/**
 * Controlador REST para {@link Conta}.
 * 
 * @author Danilo Guimarães
 *
 */
@RestController
@RequestMapping("/api/conta")
@Api(tags = "Conta")
public class ContaController {

}
