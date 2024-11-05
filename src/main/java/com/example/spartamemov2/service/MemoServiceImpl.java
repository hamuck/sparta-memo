package com.example.spartamemov2.service;

import com.example.spartamemov2.dto.MemoRequestDto;
import com.example.spartamemov2.dto.MemoResponseDto;
import com.example.spartamemov2.entity.Memo;
import com.example.spartamemov2.repository.MemoRespository;
import org.springframework.boot.task.ThreadPoolTaskExecutorBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class MemoServiceImpl implements MemoService{
    private final MemoRespository memoRespository;
    private final ThreadPoolTaskExecutorBuilder threadPoolTaskExecutorBuilder;

    public MemoServiceImpl(MemoRespository memoRespository, ThreadPoolTaskExecutorBuilder threadPoolTaskExecutorBuilder) {
        this.memoRespository = memoRespository;
        this.threadPoolTaskExecutorBuilder = threadPoolTaskExecutorBuilder;
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

    @Override
    public MemoResponseDto findMemoById(Long id) {
        // 식별자의 Memo가 없다면?
        Memo memo = memoRespository.findMemoById(id);

        // NPE 방지
        if (memo == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exist id = " + id);
        }

        return new MemoResponseDto(memo);
    }

    public MemoResponseDto updateMemo(Long id, String title, String contents){
        Memo memo = memoRespository.findMemoById(id);

        if (memo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Dose not exist id = " + id);
        }
        if ( title == null || contents == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The title and content are required values.");
        }
        memo.update(title, contents);
        return new MemoResponseDto(memo);
    }

    public MemoResponseDto updateTitle(Long id, String title, String contents){
        Memo memo = memoRespository.findMemoById(id);

        if (memo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id = " + id);
        }
        if (title == null || contents != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"The title and content are required values.");
        }
        memo.updateTitle(title);
        return new MemoResponseDto(memo);
    }

    public void deleteMemo(Long id){
        Memo memo = memoRespository.findMemoById(id);
        if (memo == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Does not exist id = " + id);
        }
        memoRespository.deleteMemo(id);
    }

}
