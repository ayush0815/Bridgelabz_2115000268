import java.util.Random;
public class OTPGEN {
    public static void main(String[] args) {
        int[] otps = new int[10];
        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateSixDigitOTP();
        }
        for (int otp : otps) {
            System.out.println(otp);
        }
        boolean areUnique = areOTPsUnique(otps);
        System.out.println("Are OTPs unique? " + areUnique);
    }
    public static int generateSixDigitOTP() {
        Random random = new Random();
        return 100000 + random.nextInt(900000);
    }
    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
