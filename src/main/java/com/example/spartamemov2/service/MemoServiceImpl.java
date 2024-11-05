package com.example.spartamemov2.service;

import com.example.spartamemov2.dto.MemoRequestDto;
import com.example.spartamemov2.dto.MemoResponseDto;
import com.example.spartamemov2.entity.Memo;
import com.example.spartamemov2.repository.MemoRespository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService{
    private final MemoRespository memoRespository;

    public MemoServiceImpl(MemoRespository memoRespository) {
        this.memoRespository = memoRespository;
    }

    public MemoResponseDto saveMemo(MemoRequestDto dto) {
        Memo memo = new Memo(dto.getTitle(),dto.getContents());
        Memo saveMemo = memoRespository.saveMemo(memo);
        return new MemoResponseDto(memo);
    }

    public List<MemoResponseDto> findAllMemos(){
        List<MemoResponseDto> allMemos = memoRespository.findAllMemos();
        return allMemos;
    }
}
