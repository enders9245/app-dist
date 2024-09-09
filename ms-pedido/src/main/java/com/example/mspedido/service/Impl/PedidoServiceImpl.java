package com.example.mspedido.service.Impl;

import com.example.mspedido.dto.ClienteDto;
import com.example.mspedido.dto.ProductoDto;
import com.example.mspedido.entity.Pedido;
import com.example.mspedido.entity.PedidoDetalle;
import com.example.mspedido.feign.CatalogoFeign;
import com.example.mspedido.feign.ClienteFeign;
import com.example.mspedido.feign.ProductoFeign;
import com.example.mspedido.repository.PedidoRepository;
import com.example.mspedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private ClienteFeign clienteFeign;
    @Autowired
    private CatalogoFeign catalogoFeign;
    @Autowired
    private ProductoFeign productoFeign;

    @Override
    public List<Pedido> lista() {
        return pedidoRepository.findAll();
    }

    @Override
    public Pedido guardar(Pedido pedido) {


        return pedidoRepository.save(pedido);
    }

    @Override
    public Optional<Pedido> listarPorid(Integer id) {
        Optional<Pedido> pedido = pedidoRepository.findById(id);
        ClienteDto clienteDto = clienteFeign.buscarPorId(pedido.get().getClienteId()).getBody();
        List<PedidoDetalle> pedidoDetalles = pedido.get().getDetalle().stream().map(pedidoDetalle -> {
            ProductoDto productoDto = productoFeign.listarProductoPorId(pedidoDetalle.getProductoId()).getBody();
            pedidoDetalle.setProductoDto(productoDto);
            return pedidoDetalle;
        }).collect(Collectors.toList());
        pedido.get().setDetalle(pedidoDetalles);
        pedido.get().setClienteDto(clienteDto);
        return pedido;
        /*
        List<PedidoDetalle> pedidoDetalles = pedido.get().getDetalle().stream().map(pedidoDetalle -> {
            pedidoDetalle.setProductoDto(catalogoFeign.listaPorld(pedidoDetalle.getProductoId()).getBody());
            return pedidoDetalle;
        }).toList();

        pedido.get().setClienteDto(clienteDto);
        pedido.get().setDetalle(pedidoDetalles);
        return pedidoRepository.findById(id);
        */
    }

    @Override
    public Pedido actualizar(Pedido pedido) {
        return pedidoRepository.save(pedido);
    }

    @Override
    public void eliminar(Integer id) {
        pedidoRepository.deleteById(id);
    }
}
