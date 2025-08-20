package com.alluracursos.foroHub.domain.answer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface AnswerRepository extends JpaRepository<Answer, Long> {

    List<Answer> findByTopicId(Long topicoId);

    List<Answer> findByAuthorId(Long autorId);

    List<Answer> findByTopicIdOrderByCreationDateDesc(Long topicoId);
}

