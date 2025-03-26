package br.com.fiap.checkpoint1.service;
 
import br.com.fiap.checkpoint1.model.Pedido;
import br.com.fiap.checkpoint1.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;
import java.util.Optional;
 
@Service
public class PedidoService {
 
    @Autowired
    private PedidoRepository pedidoRepository;
 
    public List<Pedido> listarPedidos() {
        return pedidoRepository.findAll();
    }
 
    public Optional<Pedido> buscarPedidoPorId(Long id) {
        return pedidoRepository.findById(id);
    }
 
    public Pedido criarPedido(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }
 
    public Pedido atualizarPedido(Long id, Pedido pedidoAtualizado) {
        return pedidoRepository.findById(id)
                .map(p -> {
                    p.setClienteNome(pedidoAtualizado.getClienteNome());
                    p.setValorTotal(pedidoAtualizado.getValorTotal());
                    return pedidoRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
    }
 
    public void deletarPedido(Long id) {
        pedidoRepository.deleteById(id);
    }
}
 