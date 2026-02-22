package model;

import java.util.ArrayList;
import java.util.List;

public class DadosDaCompraDao {

	public List<DadosDaCompra> dados(int id, String checkin, String checkout, String cancelamento, String state,
			String city, Float price, String dataInicio, String dataFinal, String total, String nome, String cpf,
			String cart, String dataValid, String cDSeguran, String pix, String email) {

		List<DadosDaCompra> listCompras = new ArrayList();
		DadosDaCompra compra = new DadosDaCompra();

		compra.setId(id);
		compra.setCheckin(checkin);
		compra.setCheckout(checkout);
		compra.setCancelamento(cancelamento);
		compra.setState(state);
		compra.setCity(city);
		compra.setPrice(price);
		compra.setDataInicio(dataInicio);
		compra.setDataFinal(dataFinal);
		compra.setTotal(total);
		compra.setNome(nome);
		compra.setCpf(cpf);
		compra.setCart(cart);
		compra.setDataValid(dataValid);
		compra.setcDSeguran(cDSeguran);
		compra.setPagamentoPix(pix);
		compra.setEmail(email);

		listCompras.add(compra);

		return listCompras;
	}

}
