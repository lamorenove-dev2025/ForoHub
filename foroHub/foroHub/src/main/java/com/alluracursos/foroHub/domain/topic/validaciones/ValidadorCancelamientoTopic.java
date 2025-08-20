package com.alluracursos.foroHub.domain.topic.validaciones;

import com.alluracursos.foroHub.domain.ValidationException;
import com.alluracursos.foroHub.domain.topic.TopicCancelamientoDTO;
import com.alluracursos.foroHub.domain.topic.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("ValidadorDeTopicCancelamiento")
public class ValidadorCancelamientoTopic implements ValidadorCancelamientoDeTopic{
    @Autowired
    private TopicRepository topicRepository;

    @Override
    public void validar(TopicCancelamientoDTO datos) {
        if (!topicRepository.existsById(datos.id())) {
            throw new ValidationException("El tópico con ID " + datos.id() + " no fue encontrado");
        }
    }
}
