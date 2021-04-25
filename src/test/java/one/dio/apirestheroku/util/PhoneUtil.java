package one.dio.apirestheroku.util;

import one.dio.apirestheroku.dto.request.PhoneDTO;
import one.dio.apirestheroku.model.Phone;
import one.dio.apirestheroku.type.PhoneType;

public class PhoneUtil {

    private static final String DDD = "11";
    private static final String PHONE_NUMBER = "999999999";
    private static final PhoneType PHONE_TYPE = PhoneType.MOBILE;
    private static final long PHONE_ID = 1L;

    public static PhoneDTO createFakeDTO(){
            return new PhoneDTO
                    .Builder()
                    .id(PHONE_ID)
                    .ddd(DDD)
                    .type(PHONE_TYPE)
                    .build();
        }
    public static Phone createFakeEntity(){
        return new Phone
                .Builder()
                .id(PHONE_ID)
                .ddd(DDD)
                .type(PHONE_TYPE)
                .build();
    }
}
