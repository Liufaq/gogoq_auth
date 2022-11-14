package com.gogoq.system.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data//getset方法
@AllArgsConstructor//有参构造方法
@NoArgsConstructor//无参构造方法
public class GogoqException extends RuntimeException {
    private Integer code;
    private String msg;
}
