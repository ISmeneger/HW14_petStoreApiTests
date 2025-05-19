package constants;

import models.Store;
import models.User;

public class CommonConstants {
    public static final String BASE_URL = "https://petstore.swagger.io";

    public static final User DEFAULT_USER = new User(0, "string", "string","string","string","string","string", 0);

    public static final User expectedUser = new User(9223372036854767000L, "string", "string","string","string","string","string", 0);

    public static final User UPDATE_USER = new User(1, "string2", "string2","string2","string2","string2","string2", 1);

    public static final Store DEFAULT_STORE = new Store(0, 0, 0,"2025-05-18T22:49:47.993Z", "placed", true);
}
