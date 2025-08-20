package com.alluracursos.foroHub.domain.answer;

public record AnswerDetailsDTO(
        Long id,
        String mensaje,
        String autor,
        String topico
) {
    public AnswerDetailsDTO(Answer answer) {
        this(
                answer.getId(),
                answer.getMessage(),
                answer.getAuthor().getName(),
                answer.getTopic().getTitle()
        );
    }
}

