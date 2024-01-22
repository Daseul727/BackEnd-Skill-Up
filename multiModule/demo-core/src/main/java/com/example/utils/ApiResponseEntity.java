package com.example.utils;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ApiResponseEntity extends ResponseEntity<Map<String, Object>> {

    static int SUCCESS_STATUS = 200;

    public ApiResponseEntity(HttpStatus status) {
        super(status);
    }

    public ApiResponseEntity(Map<String, Object> body, HttpStatus status) {
        super(body, status);
    }

    public ApiResponseEntity(MultiValueMap<String, String> headers, HttpStatus status) {
        super(headers, status);
    }

    public ApiResponseEntity(Map<String, Object> body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

    public static Builder data() {
        return new Builder();
    }


    public static class Builder {
        private Map<String, Object> map = new LinkedHashMap<>();
        private HttpStatus status;

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public Builder put(String key, Object value) {
            this.map.put(key, value);
            return this;
        }

        public Builder map(Map<String, Object> map) {
            this.map = map;
            return this;
        }

        public Builder list(Object list) {
            this.map.put("list", list);
            return this;
        }

        public ResponseEntity<Map<String, Object>> ok() {
            map.put("status",SUCCESS_STATUS);
            return ResponseEntity.ok(map);
        }

        public ResponseEntity<Map<String, Object>> error() {
            if (this.status == null) {
                status = HttpStatus.BAD_REQUEST;
            }
            return ResponseEntity.status(status).body(map);
        }
    }
}
