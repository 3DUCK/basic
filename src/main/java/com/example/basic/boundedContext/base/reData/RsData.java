package com.example.basic.boundedContext.base.reData;


import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RsData {
    // rsData = boolean + 알파
    // 로그인 시도시 실패하는 경우는 다양할 것이다.
    // 왜 실패 했는지 알려주기 위해 사용
    // 성공 : S-1, S-2, S-3
    // 실패 : F-1, F-2, F-3

    private final String resultCode;
    private final String msg;
    private final Object data;

    // 메소드 오버로딩
    public static RsData of(String resultCode, String msg) {
        return of(resultCode, msg, null);
    }

    public static RsData of(String resultCode, String msg, Object data) {
        return new RsData(resultCode, msg, data);
    }

    // 로그인 성공 여부
    public boolean isSuccess() {
        return resultCode.startsWith("S-");
    }
}
