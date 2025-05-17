package TOTPapp;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class TOTPUtil {
    private static final long TIME_STEP = 30_000L; // 30 seconds
    private static final int CODE_DIGITS = 6;

    public static String generateTOTP(String base64Secret) {
        try {
            byte[] secretKey = Base64.getDecoder().decode(base64Secret.trim());
            long currentInterval = System.currentTimeMillis() / TIME_STEP;

            byte[] data = new byte[8];
            for (int i = 7; i >= 0; i--) {
                data[i] = (byte) (currentInterval & 0xFF);
                currentInterval >>= 8;
            }

            SecretKeySpec signKey = new SecretKeySpec(secretKey, "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signKey);
            byte[] hash = mac.doFinal(data);

            int offset = hash[hash.length - 1] & 0xF;
            int binary = ((hash[offset] & 0x7F) << 24)
                    | ((hash[offset + 1] & 0xFF) << 16)
                    | ((hash[offset + 2] & 0xFF) << 8)
                    | (hash[offset + 3] & 0xFF);

            int otp = binary % (int) Math.pow(10, CODE_DIGITS);
            return String.format("%0" + CODE_DIGITS + "d", otp);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
