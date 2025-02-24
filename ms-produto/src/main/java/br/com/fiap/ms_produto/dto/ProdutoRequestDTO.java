package br.com.fiap.ms_produto.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProdutoRequestDTO(
       @NotBlank(message = "Campo requerido!")
       @Size(min = 3, max = 100, message = "O nome dever ter de 3 a 100 caracteres")
       String nome,

        @NotBlank(message = "Campo requerido!")
        @Size(min = 10, message = "A descrição deve ter mais de 10 caracteres")
        String descricao,

        @NotNull(message = "Campo requerido!")
        @Positive(message = "O preço dever ser um valor positivo")
        Double valor) {

}
