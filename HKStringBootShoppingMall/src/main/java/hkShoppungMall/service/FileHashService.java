package hkShoppungMall.service;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

public class FileHashService {
	// Hex Encoding 처리
	private static String hexEncode(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
		}
		return sb.toString();
	}

	// 파일 해쉬 얻기
	public static String[] makeFileHashes(String filename) throws Exception {
		InputStream fis = new FileInputStream(filename);

		byte[] buffer = new byte[1024];
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
		MessageDigest sha2 = MessageDigest.getInstance("SHA-256");
		int numRead = -1;

		do {
			numRead = fis.read(buffer);
			if (numRead > 0) {
				md5.update(buffer, 0, numRead);
				sha1.update(buffer, 0, numRead);
				sha2.update(buffer, 0, numRead);
			}
		} while (numRead != -1);

		fis.close();
		
		return new String[] {
				hexEncode(md5.digest()),
				hexEncode(sha1.digest()),
				hexEncode(sha2.digest())
		};
	}
}