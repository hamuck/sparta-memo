package com.example.spartamemov2.service;

import com.example.spartamemov2.dto.MemoRequestDto;
import com.example.spartamemov2.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {
    MemoResponseDto saveMemo(MemoRequestDto memoRequestDto);
    List<MemoResponseDto> findAllMemos();
}
