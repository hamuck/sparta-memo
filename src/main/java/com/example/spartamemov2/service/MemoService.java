package com.example.spartamemov2.service;

import com.example.spartamemov2.dto.MemoRequestDto;
import com.example.spartamemov2.dto.MemoResponseDto;

import java.util.List;

public interface MemoService {
    MemoResponseDto saveMemo(MemoRequestDto memoRequestDto);
    List<MemoResponseDto> findAllMemos();
    MemoResponseDto findMemoById(Long id);
    MemoResponseDto updateMemo(Long id, String title, String contents);
    MemoResponseDto updateTitle(Long id, String title, String contents);
    void deleteMemo(Long id);
}
