package com.example.sql_demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    private List<String> addMapValue(List<String> list, String newValue){
        list.add(newValue);
        return list;
    }

    // MethodArgumentNotValidException hataları yerine başka hatalarda metod halinde yazılabilir.
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseEntity<ApiError> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
        Map<String, List<String>> errorsMap = new HashMap<>();

        for (ObjectError objectError: ex.getBindingResult().getAllErrors()){
            String fieldName = ((FieldError)objectError).getField();
            if(errorsMap.containsKey(fieldName)){
                errorsMap.put(fieldName, addMapValue(errorsMap.get(fieldName), objectError.getDefaultMessage()));
            }else{
                errorsMap.put(fieldName, addMapValue(new ArrayList<>(), objectError.getDefaultMessage()));
            }
        }

        // Dönüş değerinde ok() yerine badRequest() de kullanılabilir ancak hata vermemesi için 200 ile döndürdün.
        return ResponseEntity.ok().body(createApiError(errorsMap));
        //return ResponseEntity.ok().body(createApiError("Hatalı istek gönderildi."));
    }

    // Generic olduğu için bunu değiştirmiyoruz. Şu anda üstteki metod bunu kullanıyor ve Map gönderiyor.
    // Eğer tek hatalı birşey olacaksa içine string değerde gönderilebilir (Üstteki metodun return değeri).
    private <T> ApiError<T> createApiError(T errors){
        ApiError<T> apiError = new ApiError<T>();
        apiError.setId(UUID.randomUUID().toString());
        apiError.setErrorTime(new Date());
        apiError.setErrors(errors);

        return apiError;
    }
}
