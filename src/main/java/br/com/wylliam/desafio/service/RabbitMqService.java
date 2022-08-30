package br.com.wylliam.desafio.service;

import br.com.wylliam.desafio.domain.entity.entity.Pauta;

public interface RabbitMqService {

    void enviarParcial(String nomeFila, String mensagem);

    void enviarTotal(String nomeFila, String mensagem);
}
