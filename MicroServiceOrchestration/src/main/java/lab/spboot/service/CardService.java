package lab.spboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import lab.spboot.model.Card;

@Service
public class CardService implements ICardService {

	
	Map map = new HashMap();
	
	@Override
	public void saveCardInfo(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public Card getCardInfo(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
