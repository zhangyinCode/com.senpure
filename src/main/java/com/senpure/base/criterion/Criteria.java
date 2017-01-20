package com.senpure.base.criterion;


import com.senpure.AppConstant;
import com.senpure.base.util.StringUtil;
import com.senpure.base.util.TimeCalculator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;


public class Criteria implements Serializable {

	public static int ALL_OPOTION_INT=-1;
	public static String ALL_OPOTION_STRING="-1";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected Logger log;

	public Criteria() {
		super();
		log = LogManager.getLogger(getClass());

	}

	public static int ORDER_ONOE = 0;
	public static int ORDER_DESC = 1;
	public static int ORDER_ASC = 2;
	private String orderField;
	private  int  orderType=0;

	private int firstResult = 0, maxResults = 15;
	private Date stime, etime, sdate, edate;
	private boolean excel;
	@Pattern(regexp = "\\s*$|\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}", message = "{time.format.error}")
	private String startTime, endTime;
	@Pattern(regexp = "\\s*$|\\d{4}-\\d{2}-\\d{2}", message = "{date.format.error}")
	private String startDate, endDate;

	public int getFirstResult() {
		return firstResult < 0 ? 0 : firstResult;
	}

	public void setFirstResult(int firstResult) {
		this.firstResult = firstResult;
	}

	public int getMaxResults() {
		return maxResults > 100 ? 100 : maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		if (startTime != null) {
			startTime = startTime.trim();
		}
		this.startTime = startTime;

		if (StringUtil.isExist(startTime)) {
			try {

				stime = AppConstant.DFS.parse(startTime);
			} catch (ParseException e) {
				log.error("转换开始时间出错", e);
			}
		} else {
			stime = null;
		}
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		if (endTime != null) {
			endTime = endTime.trim();
		}
		this.endTime = endTime;
		if (StringUtil.isExist(endTime)) {
			try {
				etime = AppConstant.DFS.parse(endTime);
			} catch (ParseException e) {
				log.error("转换时间出错", e);
			}
		} else {
			etime = null;
		}
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {

		if (startDate != null) {
			startDate = startDate.trim();
		}
		this.startDate = startDate;
		if (StringUtil.isExist(startDate)) {
			try {
				sdate = AppConstant.DFD.parse(startDate);
			} catch (ParseException e) {
				log.error("转换时间出错", e);
			}
		} else {
			sdate = null;
		}
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		if (endDate != null) {
			endDate = endDate.trim();
		}
		this.endDate = endDate;
		if (StringUtil.isExist(endDate)) {
			try {
				edate = AppConstant.DFD.parse(endDate);
				TimeCalculator.toDayEnd(edate);

			} catch (ParseException e) {
				log.error("转换时间出错", e);
			}
		} else {
			edate = null;
		}
	}

	public Date getStime() {

		return stime;
	}

	public long getStimeLong() {
		return stime == null ? 0 : stime.getTime();
	}

	public long getEtimeLong() {
		return etime == null ? 0 : etime.getTime();
	}

	public long getSdateLong() {
		return sdate == null ? 0 : sdate.getTime();
	}

	public long getEdateLong() {
		return edate == null ? 0 : edate.getTime();
	}

	public Date getEtime() {

		return etime;
	}

	public Date getSdate() {

		return sdate;
	}

	public Date getEdate() {

		return edate;
	}

	public boolean isExcel() {
		return excel;
	}

	public void setExcel(boolean excel) {
		this.excel = excel;
	}

	public void ready()
	{
		
		firstResult=0;
		excel=false;
		
	}
	
	public String getOrderField() {
		return orderField;
	}

	public void setOrderField(String orderField) {
		this.orderField = orderField;
	}

	public int getOrderType() {
		return orderType;
	}

	public void setOrderType(int orderType) {
		this.orderType = orderType;
	}

	@Override
	public String toString() {
		return "Criteria [firstResult=" + firstResult + ", maxResults=" + maxResults + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", startDate=" + startDate + ", endDate=" + endDate + "]";
	}

}
