package br.com.fiap.ms_produto.dto;

public record ProdutoResponseDTO(
        Long id,
        String nome,
        String descricao,
        Double valor
) {


    public static ProdutoResponseDTO createMock(){
        return new ProdutoResponseDTO(1l, "Smart TV", "Smart TV LG LED 29 Polegadas", 2990.0);
    }
}
