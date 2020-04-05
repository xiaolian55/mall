package com.nikki.mall.tiny.service;

import com.nikki.mall.tiny.common.api.CommonResult;

public interface UmsMemberService {
    /**
     * gen Verification code
     */
    CommonResult genAuthCode(String telehone);

    /**
     * verify if telephone matches the verification code
     */
    CommonResult verifyAuthCode(String telephone, String authCode);
}
