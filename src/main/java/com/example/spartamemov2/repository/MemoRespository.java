package com.example.spartamemov2.repository;

import com.example.spartamemov2.dto.MemoResponseDto;
import com.example.spartamemov2.entity.Memo;

import java.util.List;

public interface MemoRespository {
    Memo saveMemo(Memo memo);
    List<MemoResponseDto> findAllMemos();
}
