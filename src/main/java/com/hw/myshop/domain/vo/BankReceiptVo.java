package com.hw.myshop.domain.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * 通过ins-framework-mybatis工具自动生成，请勿手工修改。表bank_receipt的PO对象<br/>
 * 对应表名：bank_receipt
 *
 */
@Data
public class BankReceiptVo implements Serializable {
	private static final long serialVersionUID = 1L;
	/** 对应字段：id */
	private Long id;
	/** 对应字段：money_invest_id */
	private Long moneyInvestId;
	/** 对应字段：bank */
	private String bank;
	/** 对应字段：name */
	private String name;
	/** 对应字段：card_num */
	private String cardNum;
	/** 对应字段：invest_money */
	private BigDecimal investMoney;
	/** 对应字段：mark */
	private String mark;
	/** 对应字段：bank_transfer_time */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date bankTransferTime;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	/** 对应字段：create_time */
	private Date createTime;
	/** 对应字段：create_user_id */
	private Long createUserId;
	/** 对应字段：update_time */
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	@JSONField(format="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	/** 对应字段：update_user_id */
	private Long updateUserId;
	/** 对应字段：book_day */
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@JSONField(format="yyyy-MM-dd")
	private Date bookDay;
	/** 对应字段：currency */
	private String currency;
	/** 对应字段：banktime 备注：交易时间*/
	private String banktime;
	/** 对应字段：bank_transfer_date 备注：交易日期*/
	private String bankTransferDate;
	/** 对应字段：loco 备注：交易地点*/
	private String loco;
	/** 对应字段：project_id 备注：项目ID*/
	private String projectId;
	
	private int index;
}
