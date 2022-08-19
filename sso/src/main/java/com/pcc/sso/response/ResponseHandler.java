package com.pcc.sso.response;

import com.pcc.sso.user.SsoUser;

public class ResponseHandler {
    public SsoUserResponse SaveComplete(SsoUser user){
        ResponseData rData = new ResponseData();
        rData.setUserId(user.getUserId());
        rData.setTokenId(user.getTokenId());

        SsoUserResponse response = new SsoUserResponse();
        response.setResponseCode("I07000");
        response.setResponseMessage("ทำรายการเรียบร้อย");
        response.setResponseData(rData);

        return response;
    }
}
