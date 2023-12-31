package com.example.utils.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class ApiResponseEntity extends ResponseEntity<Map<String, Object>> {

    static int SUCCESS_STATUS = 200;

    public ApiResponseEntity(HttpStatus status) {
        super(status);
    }

    public ApiResponseEntity(Map<String, Object> body, HttpStatus status) {
        super(body, status);
    }


    public static Builder builder() {
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
