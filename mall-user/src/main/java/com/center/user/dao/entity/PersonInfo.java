package com.center.user.dao.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author human
 * @since 2019-08-22
 */
@TableName("person_info")
public class PersonInfo extends Model<PersonInfo> {

    private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Integer id;

	/**
	 * 订单ID
	 */
	@TableField(value="order_id")
	private String orderId;

	/**
	 * 保单ID
	 */
	@TableField(value="policy_id")
	private String policyId;

	/**
	 * 被保人ID，受益人专属，表示当前受益人属于哪个被保人
	 */
	@TableField(value="insured_id")
	private Integer insuredId;

	/**
	 * 
	 */
	@TableField(value="policy_no")
	private String policyNo;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 邮箱地址
	 */
	private String email;

	/**
	 * 证件类型 默认：身份证
	 */
	@TableField(value="card_type")
	private String cardType;

	/**
	 * 证件编号
	 */
	@TableField(value="card_no")
	private String cardNo;

	/**
	 * 出生日期
	 */
	private Date birthday;

	/**
	 * 手机号
	 */
	private String mobile;

	/**
	 * 地址
	 */
	private String address;

	/**
	 * 邮编
	 */
	@TableField(value="zip_code")
	private String zipCode;

	/**
	 * 性别  1:男  2:女
	 */
	private String sex;

	/**
	 * 人员类型 1: 投保人  2：被保人
	 */
	@TableField(value="person_type")
	private String personType;

	/**
	 * 与投保人关系
	 */
	@TableField(value="relation_ship")
	private String relationShip;

	/**
	 * 证件有效期   默认0 非长期 有效
	 */
	private String validity;

	/**
	 * 是否指定受益人(被保人)   1：法定受益人 2 指定受益人         
	 */
	@TableField(value="benefit_mark")
	private String benefitMark;

	/**
	 * 1:生存受益人;2:身故受益人;3:投保受益人  默认："1"
	 */
	@TableField(value="benifit_type")
	private String benifitType;

	/**
	 * 受益人比例
	 */
	@TableField(value="benifit_rate")
	private String benifitRate;

	/**
	 * 受益人顺序
	 */
	@TableField(value="benifit_sort")
	private Integer benifitSort;

	/**
	 * 公司联系人姓名
	 */
	@TableField(value="contacts_name")
	private String contactsName;

	/**
	 * 公司联系人 证件类型
	 */
	@TableField(value="contacts_card_type")
	private String contactsCardType;

	/**
	 * 公司联系人证件号
	 */
	@TableField(value="contacts_card_no")
	private String contactsCardNo;

	/**
	 * 有无社保 N:否;W:与该项无关;Y:是
	 */
	@TableField(value="social_security")
	private String socialSecurity;

	/**
	 * 职业
	 */
	private String industry;

	/**
	 * 删除标记  0：未删除  1：已删除
	 */
	@TableField(value="del_flag")
	private String delFlag;

	/**
	 * 创建时间
	 */
	@TableField(value="create_date")
	private Date createDate;

	/**
	 * 操作时间
	 */
	@TableField(value="oper_date")
	private Date operDate;

	/**
	 * 身高
	 */
	private Double height;

	/**
	 * 体重
	 */
	private Double weight;

	/**
	 * 行业类别，太保单位客户专属字段
	 */
	@TableField(value="industry_type")
	private String industryType;

	/**
	 * 行业细分 太保单位客户必填
	 */
	@TableField(value="industry_classification")
	private String industryClassification;

	/**
	 * 区县代码 太保单位客户专属
	 */
	@TableField(value="area_code")
	private String areaCode;

	/**
	 * 团单时,每个被保人的编号
	 */
	@TableField(value="insured_num")
	private String insuredNum;



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPolicyId() {
		return policyId;
	}

	public void setPolicyId(String policyId) {
		this.policyId = policyId;
	}

	public Integer getInsuredId() {
		return insuredId;
	}

	public void setInsuredId(Integer insuredId) {
		this.insuredId = insuredId;
	}

	public String getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPersonType() {
		return personType;
	}

	public void setPersonType(String personType) {
		this.personType = personType;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getBenefitMark() {
		return benefitMark;
	}

	public void setBenefitMark(String benefitMark) {
		this.benefitMark = benefitMark;
	}

	public String getBenifitType() {
		return benifitType;
	}

	public void setBenifitType(String benifitType) {
		this.benifitType = benifitType;
	}

	public String getBenifitRate() {
		return benifitRate;
	}

	public void setBenifitRate(String benifitRate) {
		this.benifitRate = benifitRate;
	}

	public Integer getBenifitSort() {
		return benifitSort;
	}

	public void setBenifitSort(Integer benifitSort) {
		this.benifitSort = benifitSort;
	}

	public String getContactsName() {
		return contactsName;
	}

	public void setContactsName(String contactsName) {
		this.contactsName = contactsName;
	}

	public String getContactsCardType() {
		return contactsCardType;
	}

	public void setContactsCardType(String contactsCardType) {
		this.contactsCardType = contactsCardType;
	}

	public String getContactsCardNo() {
		return contactsCardNo;
	}

	public void setContactsCardNo(String contactsCardNo) {
		this.contactsCardNo = contactsCardNo;
	}

	public String getSocialSecurity() {
		return socialSecurity;
	}

	public void setSocialSecurity(String socialSecurity) {
		this.socialSecurity = socialSecurity;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getOperDate() {
		return operDate;
	}

	public void setOperDate(Date operDate) {
		this.operDate = operDate;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public String getIndustryType() {
		return industryType;
	}

	public void setIndustryType(String industryType) {
		this.industryType = industryType;
	}

	public String getIndustryClassification() {
		return industryClassification;
	}

	public void setIndustryClassification(String industryClassification) {
		this.industryClassification = industryClassification;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public String getInsuredNum() {
		return insuredNum;
	}

	public void setInsuredNum(String insuredNum) {
		this.insuredNum = insuredNum;
	}

	@Override
	protected Serializable pkVal() {
		return null;
	}
}
