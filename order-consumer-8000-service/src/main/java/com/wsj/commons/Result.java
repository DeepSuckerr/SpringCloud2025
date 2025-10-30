package com.wsj.commons;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain=true)
public class Result {

    private String message;

    private Integer code;

    private Object data;


    public Result(Integer code, Object data) {
        this.code = code;
        this.data = data;
    }

    public Result(String message, Object code) {
        this.message = message;
        this.data = data;
    }


}
