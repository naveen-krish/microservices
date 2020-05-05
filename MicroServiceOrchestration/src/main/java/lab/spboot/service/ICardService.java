package lab.spboot.service;

import lab.spboot.model.Card;

public interface ICardService {

	public void saveCardInfo(Card card);
	public Card getCardInfo(String id);
}
