package com.emrebulak.error;

import com.emrebulak.assist.FrontEnd;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = FrontEnd.URL)
public class CustomErrorHandleWebRequest implements ErrorController {

    private ApiResult apiResult;
    private String path;
    private String message;
    private int status;
    private Map<String, String> validationErrors;


    private final ErrorAttributes errorAttributes;

    @RequestMapping("/error")
    public ApiResult springMyHandleErrorMethod(WebRequest webRequest) {

        Map<String, Object> attributes = errorAttributes.getErrorAttributes(
                webRequest,
                ErrorAttributeOptions.of(
                        ErrorAttributeOptions.Include.MESSAGE,
                        ErrorAttributeOptions.Include.BINDING_ERRORS
                )
        );

        status = (int) attributes.get("status");
        message = (String) attributes.get("message");
        path = (String) attributes.get("path");
        apiResult = new ApiResult(path, message, status);

        if (attributes.containsKey("errors")) {
            List<FieldError> fieldErrorList = (List<FieldError>) attributes.get("errors");
            validationErrors = new HashMap<>();

            for (FieldError temp : fieldErrorList) {
                validationErrors.put(temp.getField(), temp.getDefaultMessage());
            }
            apiResult.setValidationErrors(validationErrors);

        }
        return apiResult;
    }

}
