package br.com.wylliam.desafio.service.impl;

import br.com.wylliam.desafio.domain.entity.dto.AssociadoRequestDTO;
import br.com.wylliam.desafio.domain.entity.dto.AssociadoResponseDTO;
import br.com.wylliam.desafio.domain.entity.dto.StatusCpfDTO;
import br.com.wylliam.desafio.domain.entity.entity.Associado;
import br.com.wylliam.desafio.domain.entity.entity.Pauta;
import br.com.wylliam.desafio.domain.entity.enums.CpfValidateEnum;
import br.com.wylliam.desafio.exception.ExceptionDefault;
import br.com.wylliam.desafio.exception.RegraDeNegocioException;
import br.com.wylliam.desafio.repository.AssociadoRepository;
import br.com.wylliam.desafio.service.AssociadoService;
import br.com.wylliam.desafio.service.RabbitMqService;
import com.google.gson.Gson;
import org.apache.logging.log4j.util.Strings;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Optional;
import java.util.logging.Logger;

@Service
public class RabbitMqServiceImpl implements RabbitMqService {

    private Logger logger = Logger.getLogger(this.getClass().getName());

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Override
    public void enviarParcial(String nomeFila, String mensagem) {
        this.rabbitTemplate.convertAndSend(nomeFila, mensagem);
    }

    @Override
    public void enviarTotal(String nomeFila, String mensagem) {
        this.rabbitTemplate.convertAndSend(nomeFila, mensagem);
    }
}
