package com.nequi.franchises.controller;

import com.nequi.franchises.controller.dto.BranchDto;
import com.nequi.franchises.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/branch")
public class BranchController {

    private final BranchService branchService;

    public BranchController(BranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping("/all")
    Flux<BranchDto> getBranches() {
        return branchService.getBranches();
    }

    @GetMapping("/{branchId}")
    Mono<BranchDto> getBranch(@PathVariable("branchId") Long id) {
        return branchService.getBranch(id);
    }

    @PostMapping("/create")
    Mono<BranchDto> createBranch(@RequestBody BranchDto branchDto) {
        return branchService.createBranch(branchDto);
    }

    @PutMapping("/update/{branchId}")
    Mono<BranchDto> updateBranch(@PathVariable("branchId") Long id, @RequestBody BranchDto branchDto) {
        return branchService.updateBranch(id, branchDto);
    }

    @DeleteMapping("/delete/{branchId}")
    Mono<Void> deleteBranch(@PathVariable("branchId") Long id) {
        return branchService.deleteBranch(id);
    }
}
