package model;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.text.Normalizer;
import java.text.Normalizer.Form;

public class QrCode {

	private static String emv(String id, String value) {
		return id + String.format("%02d", value.length()) + value;
	}

	public String gerarPayload(String chave, String nome, String cidade, String txid, String valor) {
		String var10000 = emv("00", "BR.GOV.BCB.PIX");
		String merchantAccount = var10000 + emv("01", chave) + emv("02", "PAGAMENTO");
		var10000 = emv("00", "01");
		String payloadSemCRC = var10000 + emv("26", merchantAccount) + emv("52", "0000") + emv("53", "986")
				+ emv("54", valor) + emv("58", "BR") + emv("59", normalizar(nome, 25))
				+ emv("60", normalizar(cidade, 15)) + emv("62", emv("05", normalizar(txid, 25))) + "6304";
		return payloadSemCRC + CRC16(payloadSemCRC);
	}

	private static String normalizar(String texto, int max) {
		String n = Normalizer.normalize(texto, Form.NFD).replaceAll("[^\\p{ASCII}]", "").replaceAll("[^A-Za-z0-9 ]", "")
				.trim().toUpperCase();
		return n.length() > max ? n.substring(0, max) : n;
	}

	private static String CRC16(String payload) {
		int crc = 65535;
		int polynomial = 4129;
		byte[] bytes = payload.getBytes(StandardCharsets.UTF_8);
		byte[] var7 = bytes;
		int var6 = bytes.length;

		for (int var5 = 0; var5 < var6; ++var5) {
			byte b = var7[var5];
			crc ^= b << 8;

			for (int i = 0; i < 8; ++i) {
				if ((crc & '耀') != 0) {
					crc = crc << 1 ^ polynomial;
				} else {
					crc <<= 1;
				}

				crc &= 65535;
			}
		}

		return String.format("%04X", crc);
	}

	public void gerarQRCode(String texto, String caminhoArquivo, int largura, int altura)
			throws IOException, WriterException {
		try {
			QRCodeWriter qrCodeWriter = new QRCodeWriter();
			BitMatrix bitMatrix = qrCodeWriter.encode(texto, BarcodeFormat.QR_CODE, largura, altura);
			Path caminho = FileSystems.getDefault().getPath(caminhoArquivo);
			MatrixToImageWriter.writeToPath(bitMatrix, "PNG", caminho);
			System.out.println("QrCode gerado com success!!" + String.valueOf(caminho));
		} catch (WriterException var8) {
			System.err.println("Erro ao gerar QR Code: " + var8.getMessage());
		}

	}
}
