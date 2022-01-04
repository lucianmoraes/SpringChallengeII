package com.br.meli.springchallenge.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {
    private long id;
    private List<Produto> produtos;
    private BigDecimal total;

    public void calculaTotal(){
        BigDecimal tempTotal = BigDecimal.ZERO; // -> valor inicial zero
        for(Produto p: this.getProdutos()){
            BigDecimal qtd = new BigDecimal(p.getQuantity());
            BigDecimal currentValue = p.getPrice();

            currentValue = currentValue.multiply(qtd);
            tempTotal = tempTotal.add(currentValue);

        }
        this.setTotal(tempTotal);
    }
}
