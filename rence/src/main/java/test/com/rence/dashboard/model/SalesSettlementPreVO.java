/**
 * 
 * @author 최진실
 *
 */
package test.com.rence.dashboard.model;

import java.io.Serializable;

public class SalesSettlementPreVO implements Serializable {
	private String sales_no;
	private int sales_income;
	private int sales_total;
	private int sales_cancel;
	private int pre_sales_income;
	private int pre_sales_total;
	private int pre_sales_cancel;
	private int sales_gap;
	
	public SalesSettlementPreVO() {}

	public SalesSettlementPreVO(String sales_no, int sales_income, int sales_total, int sales_cancel,
			int pre_sales_income, int pre_sales_total, int pre_sales_cancel, int sales_gap) {
		super();
		this.sales_no = sales_no;
		this.sales_income = sales_income;
		this.sales_total = sales_total;
		this.sales_cancel = sales_cancel;
		this.pre_sales_income = pre_sales_income;
		this.pre_sales_total = pre_sales_total;
		this.pre_sales_cancel = pre_sales_cancel;
		this.sales_gap = sales_gap;
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

	public int getPre_sales_income() {
		return pre_sales_income;
	}

	public void setPre_sales_income(int pre_sales_income) {
		this.pre_sales_income = pre_sales_income;
	}

	public int getPre_sales_total() {
		return pre_sales_total;
	}

	public void setPre_sales_total(int pre_sales_total) {
		this.pre_sales_total = pre_sales_total;
	}

	public int getPre_sales_cancel() {
		return pre_sales_cancel;
	}

	public void setPre_sales_cancel(int pre_sales_cancel) {
		this.pre_sales_cancel = pre_sales_cancel;
	}

	public int getSales_gap() {
		return sales_gap;
	}

	public void setSales_gap(int sales_gap) {
		this.sales_gap = sales_gap;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + pre_sales_cancel;
		result = prime * result + pre_sales_income;
		result = prime * result + pre_sales_total;
		result = prime * result + sales_cancel;
		result = prime * result + sales_gap;
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
		SalesSettlementPreVO other = (SalesSettlementPreVO) obj;
		if (pre_sales_cancel != other.pre_sales_cancel)
			return false;
		if (pre_sales_income != other.pre_sales_income)
			return false;
		if (pre_sales_total != other.pre_sales_total)
			return false;
		if (sales_cancel != other.sales_cancel)
			return false;
		if (sales_gap != other.sales_gap)
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

	@Override
	public String toString() {
		return "SalesSettlementPreVO [sales_no=" + sales_no + ", sales_income=" + sales_income + ", sales_total="
				+ sales_total + ", sales_cancel=" + sales_cancel + ", pre_sales_income=" + pre_sales_income
				+ ", pre_sales_total=" + pre_sales_total + ", pre_sales_cancel=" + pre_sales_cancel + ", sales_gap="
				+ sales_gap + "]";
	}

	
	
}
