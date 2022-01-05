package com.br.meli.springchallenge.service.teste;

import com.br.meli.springchallenge.Controller.PedidoController;
import com.br.meli.springchallenge.Controller.ProdutoController;
import com.br.meli.springchallenge.Entity.Produto;
import com.br.meli.springchallenge.Service.ProdutoService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
//@WebMvcTest(controllers = ProdutoController.class)
//@ActiveProfiles("test")
@AutoConfigureMockMvc
public class ProdutosControllerTeste {

    @Autowired
    private MockMvc mockMvc;


    /*
    @BeforeEach
    void setUp() {
        this.produtosMockados.add(new Produto(1L, "Camiseta", "Roupa","Nike", new BigDecimal(49.99), 12, true, "****"));
        this.produtosMockados.add(new Produto(2L, "Martelo", "Ferramenta","Ching Ling", new BigDecimal(14.99), 2, false, "**"));
        this.produtosMockados.add(new Produto(3L, "Cadeira", "Moveis","Decorate", new BigDecimal(79.99), 21, true, "*****"));
        this.produtosMockados.add(new Produto(4L, "WebCam", "Cameras","LogiTech", new BigDecimal(359.99), 6, true, "*****"));
    }
     */

    @Test
    public void retornaTodosProdutos() throws Exception {
        List<Produto> produtosMockados = new ArrayList<>(); // ## erro aqui ##
        produtosMockados.add(new Produto(1L, "Serra de Bancada", "Ferramentas","FORTGPRO", new BigDecimal(1800.0), 5, true, "****"));
        MvcResult mvcResult = this.mockMvc.perform(
                MockMvcRequestBuilders.get("http://localhost:8080/api/v1/articles?productId=1")
        ).andReturn();

        String resultadoEsperado = mvcResult.getResponse().getContentAsString();
        //String mock = new Gson().toJson(produtosMockados);
        System.out.println("FROM REQ: " + resultadoEsperado);
        System.out.println("MOCK: " + produtosMockados.toString());

        ObjectMapper mapper = new ObjectMapper();
        assertThat(resultadoEsperado).isEqualToIgnoringWhitespace(mapper.writeValueAsString(produtosMockados));


    }

}


/*
// Given
    String name = RandomStringUtils.randomAlphabetic( 8 );
    HttpUriRequest request = new HttpGet( "https://api.github.com/users/%22 + name );

    // When
    HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

    // Then
    assertThat(
      httpResponse.getStatusLine().getStatusCode(),
      equalTo(HttpStatus.SC_NOT_FOUND));
 */
