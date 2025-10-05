package com.example.FeedbackFy.controller;

import com.example.FeedbackFy.dto.*;
import com.example.FeedbackFy.service.FeedbackService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @GetMapping("/feedback")
    public ResponseEntity<List<FeedbackResponse>> listarTodos(){
        return ResponseEntity.ok(feedbackService.ListarFeedback());
    }

    @GetMapping("/feedback/{feedbackId}")
    public ResponseEntity<FeedbackResponse> listarPorFeedbackId(@PathVariable Integer feedbackId){
        return ResponseEntity.ok(feedbackService.ListarPorFeedbackId(feedbackId));
    }

    @GetMapping("/stats")
    public ResponseEntity<FeedbackStatsResponse>ListarFeedbackStats(){
        return ResponseEntity.ok(feedbackService.ListarFeedbackStats());
    }

    @PostMapping("/feedback")
    public ResponseEntity<FeedbackResponse> criarFeedback(@RequestBody FeedbackRequest feedbackRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(feedbackService.CriarFeedback(feedbackRequest));
    }

    @PutMapping("/feedback/{feedbackId}")
    public ResponseEntity<FeedbackUpdateResponse> atualizarPorFeedbackId(@PathVariable Integer feedbackId, @RequestBody FeedbackUpdateRequest feedbackUpdateRequest){
        try{
            FeedbackUpdateResponse feedbackAtualizado = this.feedbackService.AtualizarFeedback(feedbackId,feedbackUpdateRequest);
            return ResponseEntity.ok(feedbackAtualizado);
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/feedback/{feedbackId}")
    public ResponseEntity<Void> deletarPorFeedbackId(@PathVariable Integer feedbackId){
        try {
            this.feedbackService.ExcluirFeedback(feedbackId);
            return ResponseEntity.noContent().build();
        }catch (EntityNotFoundException e){
            return ResponseEntity.notFound().build();
        }
    }
}
