package com.example.spartamemov2.controller;


import com.example.spartamemov2.dto.MemoRequestDto;
import com.example.spartamemov2.dto.MemoResponseDto;
import com.example.spartamemov2.entity.Memo;
import com.example.spartamemov2.service.MemoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/memos")
public class MemoController {

    private final MemoService memoService;

    public MemoController(MemoService memoService) {
        this.memoService = memoService;
    }

    @PostMapping
    public ResponseEntity<MemoResponseDto> createMemo(
            @RequestBody MemoRequestDto dto
    ){
        return new ResponseEntity<>(memoService.saveMemo(dto), HttpStatus.CREATED);
    }
    @GetMapping
    public List<MemoResponseDto> findAllMemos(){
        return memoService.findAllMemos();
    }

}