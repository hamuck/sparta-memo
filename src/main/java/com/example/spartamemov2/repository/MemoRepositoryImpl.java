package com.example.spartamemov2.repository;

import com.example.spartamemov2.dto.MemoResponseDto;
import com.example.spartamemov2.entity.Memo;
import com.example.spartamemov2.service.MemoServiceImpl;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoRepositoryImpl implements MemoRespository{
    private final Map<Long, Memo> memoList = new HashMap<>();

    public Memo saveMemo(Memo memo){
        Long memoId = memoList.isEmpty() ? 1 : Collections.max(memoList.keySet()) + 1;
        memo.setId(memoId);
        memoList.put(memoId, memo);

        return memo;
    }

    public List<MemoResponseDto> findAllMemos(){
        List<MemoResponseDto> allMemos = new ArrayList<>();
        for (Memo memo : memoList.values()){
            MemoResponseDto dto = new MemoResponseDto(memo);
            allMemos.add(dto);
        }
        return allMemos;
    }

    public Memo findMemoById(Long id){
        return memoList.get(id);
    }

    public void deleteMemo(Long id){
        memoList.remove(id);
    }
}
