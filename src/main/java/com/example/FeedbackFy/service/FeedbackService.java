package com.example.FeedbackFy.service;

import com.example.FeedbackFy.dto.*;
import com.example.FeedbackFy.entity.Feedback;
import com.example.FeedbackFy.repository.FeedbackRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public List<FeedbackResponse> ListarFeedback() {
        List<Feedback> feedbacks = feedbackRepository.findAll();
        return feedbacks.stream()
                .map(FeedbackResponse::new)
                .collect(Collectors.toList());

    }

    public FeedbackResponse ListarPorFeedbackId(Integer feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElse(null);
        if (feedback == null) {
            return null;
        }else {
            return new FeedbackResponse(feedback);
        }
    }

    public FeedbackStatsResponse ListarFeedbackStats() {
        Integer total = feedbackRepository.countTotalFeedbacks();
        List<Object[]> results = feedbackRepository.countFeedbacksByType();

        Map<String, Integer> porTipo = new HashMap<>();
        for (Object[] result : results) {
            porTipo.put((String) result[0], ((Long) result[1]).intValue());
        }

        return new FeedbackStatsResponse(total, porTipo);
    }

    @Transactional
    public FeedbackResponse CriarFeedback(FeedbackRequest feedbackRequest) {

        Feedback feedback = new Feedback();
        feedback.setNomeDoUsuario(feedbackRequest.getNomeDoUsuario());
        feedback.setEmailDoUsuario(feedbackRequest.getEmailDoUsuario());
        feedback.setTipo(feedbackRequest.getTipo());
        feedback.setMensagem(feedbackRequest.getMensagem());
        feedback.setDataCriacao(feedbackRequest.getDataCriacao());

        Feedback feedbackSalvo = this.feedbackRepository.save(feedback);
        return new FeedbackResponse(feedbackSalvo);
    }

    @Transactional
    public FeedbackUpdateResponse AtualizarFeedback(Integer feedbackId, FeedbackUpdateRequest feedbackUpdateRequest) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElse(null);
        if (feedback == null) {
            return null;
        }else {
            feedback.setNomeDoUsuario(feedbackUpdateRequest.getNomeDoUsuario());
            feedback.setEmailDoUsuario(feedbackUpdateRequest.getEmailDoUsuario());
            feedback.setTipo(feedbackUpdateRequest.getTipo());
            feedback.setMensagem(feedbackUpdateRequest.getMensagem());
            feedback.setDataCriacao(feedbackUpdateRequest.getDataAlteracao());

            Feedback feedbackSalvo = this.feedbackRepository.save(feedback);
            return new FeedbackUpdateResponse(feedbackSalvo);
        }
    }

    @Transactional
    public void ExcluirFeedback(Integer feedbackId) {
        Feedback feedback = feedbackRepository.findById(feedbackId).orElse(null);
        feedbackRepository.deleteById(feedbackId);
        }
}

