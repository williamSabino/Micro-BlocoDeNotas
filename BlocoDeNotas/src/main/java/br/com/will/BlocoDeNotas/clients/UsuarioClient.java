package br.com.will.BlocoDeNotas.clients;


import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("Usuario-ms")
public interface UsuarioClient {

    @RequestMapping(method = RequestMethod.PUT, value = "/usuarios/qtdeNotas/{id}")
    void alterarQtdeId(@PathVariable Long id);
}
