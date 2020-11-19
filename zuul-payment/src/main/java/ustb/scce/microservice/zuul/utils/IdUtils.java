package ustb.scce.microservice.zuul.utils;

import lombok.experimental.UtilityClass;

import java.util.UUID;

@UtilityClass
public class IdUtils {

    public String getUUId() {
        return UUID.randomUUID().toString();
    }

}
