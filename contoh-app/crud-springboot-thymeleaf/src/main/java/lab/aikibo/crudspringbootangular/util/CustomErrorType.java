package lab.aikibo.crudspringbootangular.util;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
public class CustomErrorType {

    @Getter @Setter @NonNull
    private String errorMessage;

}
