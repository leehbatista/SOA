package br.com.fiap.checkpoint1.model;
 
import java.time.LocalDate;
 
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
 
@Entity
@Data
public class Pedido {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
 
    @NotBlank(message = "O nome do cliente é obrigatório")
    private String clienteNome;
 
    private LocalDate dataPedido = LocalDate.now();
 
    @Min(value = 0, message = "O valor total do pedido não pode ser negativo")
    private double valorTotal;
}
 