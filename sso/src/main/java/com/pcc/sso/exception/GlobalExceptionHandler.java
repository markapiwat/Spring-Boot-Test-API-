package com.pcc.sso.exception;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

 import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.pcc.sso.response.ResponseData;
import com.pcc.sso.response.SsoUserResponse;
import com.pcc.sso.user.SsoUser;


@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(DataAccessException.class)
        public ResponseEntity<SsoUserResponse> addException(DataAccessException ex, SsoUser users) {
            SsoUserResponse resp = new SsoUserResponse();
            ResponseData respData = new ResponseData();
            respData.setUserId(users.getUserId());
            respData.setTokenId(users.getTokenId());
            resp.setResponseCode("E000001");
            resp.setResponseMessage("ไม่สามารถบันทึกข้อมูลลงฐานข้อมูลได้");
            resp.setResponseData(respData);

            return new ResponseEntity<>(resp, HttpStatus.NOT_ACCEPTABLE);
        }

        @ExceptionHandler(CannotCreateTransactionException.class)
        public ResponseEntity<SsoUserResponse> dbNotFoundException(CannotCreateTransactionException ex, SsoUser users) {
            SsoUserResponse resp = new SsoUserResponse();
            ResponseData respData = new ResponseData();
            respData.setUserId(users.getUserId());
            respData.setTokenId(users.getTokenId());
            resp.setResponseCode("E000001");
            resp.setResponseMessage("ไม่พบฐานข้อมูล");
            resp.setResponseData(respData);

            return new ResponseEntity<>(resp, HttpStatus.INTERNAL_SERVER_ERROR);
        }


}