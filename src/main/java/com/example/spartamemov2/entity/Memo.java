package com.example.spartamemov2.entity;

import com.example.spartamemov2.dto.MemoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class Memo {

    @Setter
    private Long id;
    private String title;
    private String contents;

    public Memo(String title, String content){
        this.title = title;
        this.contents = content;
    }

    public void updateMemo(MemoRequestDto dto) {
        this.title = dto.getTitle();
        this.contents = dto.getContents();
    }

}
