package com.warm.common.shiro;

import com.warm.common.constant.CommonConstant;
import com.warm.common.constant.SecurityConstants;
import com.warm.common.util.Digests;
import com.warm.common.util.EncodeUtil;
import com.warm.system.entity.User;
import org.apache.shiro.crypto.RandomNumberGenerator;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;


public class HashPassword {
    private static final int INTERATIONS = 1024;
    /**
     * 指定随机盐的字符位数
     */
    private static final int SALT_SIZE = 8;
    //private static final String ALGORITHM = "SHA-1";

    public String salt;
    public String password;

    public static void main(String[] args) {
        HashPassword pwd = HashPassword.encryptPassword("123456");
        System.out.println("pwd: " + pwd.password + ",salt:" + pwd.salt);
        System.out.println(validatePasswordSha1("1234567", "e9a3256814c24482b1ed1ee83985e3d44be207ac", "05469a922d427c9f"));
        //SimpleHash sh2 = new SimpleHash("SHA-1", "123456", "05469a922d427c9f", 1024);// 第四个参数 "1"的意思是循环加密多少次
        System.out.println(new SimpleHash("SHA-1", "123456", SecurityConstants.SALT, 1024).toString());
    }

    public static void encryptPassword(User user) {
        RandomNumberGenerator randomNumberGenerator = new SecureRandomNumberGenerator();
        // 随机字符串作为salt因子，实际参与运算的salt我们还引入其它干扰因子
        user.setSalt(randomNumberGenerator.nextBytes().toHex());
        SimpleHash hashPassword = new SimpleHash("SHA-1", user.getPassword(), SecurityConstants.SALT,
                1024);
        user.setPassword(hashPassword.toString());
    }

    public static void test1() {

        // 假设是用户输入的密码
        String password = "123456";
        // 加入的盐(百度百科有)
        String salt = "jack";

        // 这是最原始的MD5加密 (可在网上破解)
        Md5Hash originalMd5 = new Md5Hash(password);
        System.out.println(originalMd5.toString());// 输出加密后的密码

        // 这种也是原始md5加密(可在网上破解)
        SimpleHash originalMd52 = new SimpleHash("MD5", password);// 构造函数中的 "MD5"的意思是进行md5加密,大小写无关
        System.out.println(originalMd52.toString());

        // sha-1 原始加密方法(可在网上破解)
        SimpleHash originalSha1 = new SimpleHash("SHA-1", password);//
        System.out.println(originalSha1.toString());

        // 要加大破解难度，这时候加个'盐'来加密是爽歪歪的

        // 第1种MD5加盐加密操作
        Md5Hash newPassword = new Md5Hash(password, salt, 1);// 第三个参数 "1"的意思是循环加密多少次
        System.out.println(newPassword.toString());

        // 第2种MD5加盐加密操作
        SimpleHash sh = new SimpleHash("MD5", password, salt, 1);// 第四个参数 "1"的意思是循环加密多少次
        System.out.println(sh.toString());

        // 第2种SHA-1加盐加密操作
        SimpleHash sh2 = new SimpleHash("SHA-1", password, salt, 1);// 第四个参数 "1"的意思是循环加密多少次
        System.out.println(sh2.toString());
    }

    public static HashPassword encryptPassword(String plainPassword) {
        HashPassword result = new HashPassword();
        byte[] salt = Digests.generateSalt(SALT_SIZE);
        result.salt = EncodeUtil.encodeHex(salt);

        byte[] hashPassword = Digests.sha1(plainPassword.getBytes(), salt, INTERATIONS);
        result.password = EncodeUtil.encodeHex(hashPassword);
        return result;
    }


    /**
     * 验证输入密码和后台密码是否匹配
     *
     * @param inputPlainPassword 明文密码
     * @param dbCipherPassword   密文密码
     * @param salt               盐值
     * @return 密码是否匹配
     * @author 柏耀明
     * @since 2017年12月23日
     */
    public static boolean validatePasswordSha1(String inputPlainPassword, String dbCipherPassword, String salt) {
        byte[] hashPassword = Digests.sha1(inputPlainPassword.getBytes(), EncodeUtil.decodeHex(salt), INTERATIONS);
        String inputCipherPassword = EncodeUtil.encodeHex(hashPassword);
        return dbCipherPassword.equals(inputCipherPassword);
    }

    /**
     * 验证输入密码和后台密码是否匹配
     *
     * @param inputPlainPassword 明文密码
     * @param dbCipherPassword   密文密码
     * @return 密码是否匹配
     * @author 柏耀明
     * @since 2017年12月23日
     */
    public static boolean validatePasswordSha1(String inputPlainPassword, String dbCipherPassword) {
        String salt = EncodeUtil.encodeHex(Digests.generateSalt(SALT_SIZE));
        byte[] hashPassword = Digests.sha1(inputPlainPassword.getBytes(), EncodeUtil.decodeHex(salt), INTERATIONS);
        String inputCipherPassword = EncodeUtil.encodeHex(hashPassword);
        return dbCipherPassword.equals(inputCipherPassword);
    }

}
