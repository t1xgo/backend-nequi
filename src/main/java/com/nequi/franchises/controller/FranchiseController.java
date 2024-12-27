package com.nequi.franchises.controller;

import com.nequi.franchises.controller.dto.FranchiseDto;
import com.nequi.franchises.service.FranchiseService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franchise")
public class FranchiseController {

    private final FranchiseService franchiseService;

    public FranchiseController(FranchiseService franchiseService) {
        this.franchiseService = franchiseService;
    }

    @GetMapping("/all")
    Flux<FranchiseDto> getFranchises() {
        return franchiseService.getFranchises();
    }

    @GetMapping("/{franchiseId}")
    Mono<FranchiseDto> getFranchise(@PathVariable("franchiseId") Long id) {
        return franchiseService.getFranchise(id);
    }

    @PostMapping("/create")
    Mono<FranchiseDto> createFranchise(@RequestBody FranchiseDto franchiseDto) {
        return franchiseService.createFranchise(franchiseDto);
    }

    @PutMapping("/update/{franchiseId}")
    Mono<FranchiseDto> updateFranchise(@PathVariable("franchiseId") Long id, @RequestBody FranchiseDto franchiseDto) {
        return franchiseService.updateFranchise(id, franchiseDto);
    }

    @DeleteMapping("/delete/{franchiseId}")
    Mono<Void> deleteFranchise(@PathVariable("franchiseId") Long id) {
        return franchiseService.deleteFranchise(id);
    }
}
