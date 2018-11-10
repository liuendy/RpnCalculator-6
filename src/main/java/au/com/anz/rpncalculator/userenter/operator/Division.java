package au.com.anz.rpncalculator.userenter.operator;

import java.math.BigDecimal;

import au.com.anz.rpncalculator.history.record.OperationRecord;
import au.com.anz.rpncalculator.storage.Storage;
import au.com.anz.rpncalculator.userenter.UserEntry;

public class Division extends BiOperator {

	@Override
	protected void performDetailOperation(Storage storage) {
		BigDecimal first = storage.popDigit();
		//Handle Divisor is ZERO
		if (BigDecimal.ZERO.equals(first)) {
			storage.pushDigit(first);
			System.err.println("Divisor cannot be ZERO!");
			return;
		}
		BigDecimal second = storage.popDigit();
		BigDecimal total = second.divide(first, UserEntry.DECIMAL_PLACES, BigDecimal.ROUND_DOWN);
		storage.pushDigit(total);
		OperationRecord record = this.getOperationRecord(first, second);
		storage.pushOperationRecord(record);
	}

}
