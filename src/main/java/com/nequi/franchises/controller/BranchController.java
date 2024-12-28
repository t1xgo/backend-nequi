package com.nequi.franchises.controller;

import com.nequi.franchises.controller.dto.BranchDto;
import com.nequi.franchises.service.BranchService;
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

    @PostMapping("/create/{franchiseId}")
    Mono<BranchDto> createBranch(@RequestBody BranchDto branchDto, @PathVariable("franchiseId") Long franchiseId) {
        return branchService.createBranch(branchDto, franchiseId);
    }

    @PutMapping("/update/{branchId}/{franchiseId}")
    Mono<BranchDto> updateBranch(@PathVariable("branchId") Long id, @RequestBody BranchDto branchDto, @PathVariable("franchiseId") Long franchiseId) {
        return branchService.updateBranch(id, branchDto, franchiseId);
    }

    @DeleteMapping("/delete/{branchId}")
    Mono<Void> deleteBranch(@PathVariable("branchId") Long id) {
        return branchService.deleteBranch(id);
    }
}
