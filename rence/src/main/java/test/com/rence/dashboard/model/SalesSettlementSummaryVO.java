/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.io.Serializable;

public class SalesSettlementSummaryVO implements Serializable {
	private String sales_no;
	private int sales_income;
	private int sales_total;
	private int sales_cancel;
	
	public SalesSettlementSummaryVO() {}

	public SalesSettlementSummaryVO(String sales_no, int sales_income, int sales_total, int sales_cancel) {
		super();
		this.sales_no = sales_no;
		this.sales_income = sales_income;
		this.sales_total = sales_total;
		this.sales_cancel = sales_cancel;
	}

	public String getSales_no() {
		return sales_no;
	}

	public void setSales_no(String sales_no) {
		this.sales_no = sales_no;
	}

	public int getSales_income() {
		return sales_income;
	}

	public void setSales_income(int sales_income) {
		this.sales_income = sales_income;
	}

	public int getSales_total() {
		return sales_total;
	}

	public void setSales_total(int sales_total) {
		this.sales_total = sales_total;
	}

	public int getSales_cancel() {
		return sales_cancel;
	}

	public void setSales_cancel(int sales_cancel) {
		this.sales_cancel = sales_cancel;
	}

	@Override
	public String toString() {
		return "SalesSettlementSummaryVO [sales_no=" + sales_no + ", sales_income=" + sales_income + ", sales_total="
				+ sales_total + ", sales_cancel=" + sales_cancel + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + sales_cancel;
		result = prime * result + sales_income;
		result = prime * result + ((sales_no == null) ? 0 : sales_no.hashCode());
		result = prime * result + sales_total;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalesSettlementSummaryVO other = (SalesSettlementSummaryVO) obj;
		if (sales_cancel != other.sales_cancel)
			return false;
		if (sales_income != other.sales_income)
			return false;
		if (sales_no == null) {
			if (other.sales_no != null)
				return false;
		} else if (!sales_no.equals(other.sales_no))
			return false;
		if (sales_total != other.sales_total)
			return false;
		return true;
	}


	
}
