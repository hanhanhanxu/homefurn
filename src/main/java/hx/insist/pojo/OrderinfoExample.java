package hx.insist.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderinfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderinfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andOfidIsNull() {
            addCriterion("OFID is null");
            return (Criteria) this;
        }

        public Criteria andOfidIsNotNull() {
            addCriterion("OFID is not null");
            return (Criteria) this;
        }

        public Criteria andOfidEqualTo(String value) {
            addCriterion("OFID =", value, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidNotEqualTo(String value) {
            addCriterion("OFID <>", value, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidGreaterThan(String value) {
            addCriterion("OFID >", value, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidGreaterThanOrEqualTo(String value) {
            addCriterion("OFID >=", value, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidLessThan(String value) {
            addCriterion("OFID <", value, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidLessThanOrEqualTo(String value) {
            addCriterion("OFID <=", value, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidLike(String value) {
            addCriterion("OFID like", value, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidNotLike(String value) {
            addCriterion("OFID not like", value, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidIn(List<String> values) {
            addCriterion("OFID in", values, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidNotIn(List<String> values) {
            addCriterion("OFID not in", values, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidBetween(String value1, String value2) {
            addCriterion("OFID between", value1, value2, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfidNotBetween(String value1, String value2) {
            addCriterion("OFID not between", value1, value2, "ofid");
            return (Criteria) this;
        }

        public Criteria andOfserialIsNull() {
            addCriterion("OFSERIAL is null");
            return (Criteria) this;
        }

        public Criteria andOfserialIsNotNull() {
            addCriterion("OFSERIAL is not null");
            return (Criteria) this;
        }

        public Criteria andOfserialEqualTo(String value) {
            addCriterion("OFSERIAL =", value, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialNotEqualTo(String value) {
            addCriterion("OFSERIAL <>", value, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialGreaterThan(String value) {
            addCriterion("OFSERIAL >", value, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialGreaterThanOrEqualTo(String value) {
            addCriterion("OFSERIAL >=", value, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialLessThan(String value) {
            addCriterion("OFSERIAL <", value, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialLessThanOrEqualTo(String value) {
            addCriterion("OFSERIAL <=", value, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialLike(String value) {
            addCriterion("OFSERIAL like", value, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialNotLike(String value) {
            addCriterion("OFSERIAL not like", value, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialIn(List<String> values) {
            addCriterion("OFSERIAL in", values, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialNotIn(List<String> values) {
            addCriterion("OFSERIAL not in", values, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialBetween(String value1, String value2) {
            addCriterion("OFSERIAL between", value1, value2, "ofserial");
            return (Criteria) this;
        }

        public Criteria andOfserialNotBetween(String value1, String value2) {
            addCriterion("OFSERIAL not between", value1, value2, "ofserial");
            return (Criteria) this;
        }

        public Criteria andUidIsNull() {
            addCriterion("UID is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("UID is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("UID =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("UID <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("UID >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("UID >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("UID <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("UID <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("UID like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("UID not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("UID in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("UID not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("UID between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("UID not between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andRidIsNull() {
            addCriterion("RID is null");
            return (Criteria) this;
        }

        public Criteria andRidIsNotNull() {
            addCriterion("RID is not null");
            return (Criteria) this;
        }

        public Criteria andRidEqualTo(String value) {
            addCriterion("RID =", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotEqualTo(String value) {
            addCriterion("RID <>", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThan(String value) {
            addCriterion("RID >", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidGreaterThanOrEqualTo(String value) {
            addCriterion("RID >=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThan(String value) {
            addCriterion("RID <", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLessThanOrEqualTo(String value) {
            addCriterion("RID <=", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidLike(String value) {
            addCriterion("RID like", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotLike(String value) {
            addCriterion("RID not like", value, "rid");
            return (Criteria) this;
        }

        public Criteria andRidIn(List<String> values) {
            addCriterion("RID in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotIn(List<String> values) {
            addCriterion("RID not in", values, "rid");
            return (Criteria) this;
        }

        public Criteria andRidBetween(String value1, String value2) {
            addCriterion("RID between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRidNotBetween(String value1, String value2) {
            addCriterion("RID not between", value1, value2, "rid");
            return (Criteria) this;
        }

        public Criteria andRnameIsNull() {
            addCriterion("RNAME is null");
            return (Criteria) this;
        }

        public Criteria andRnameIsNotNull() {
            addCriterion("RNAME is not null");
            return (Criteria) this;
        }

        public Criteria andRnameEqualTo(String value) {
            addCriterion("RNAME =", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotEqualTo(String value) {
            addCriterion("RNAME <>", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThan(String value) {
            addCriterion("RNAME >", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameGreaterThanOrEqualTo(String value) {
            addCriterion("RNAME >=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThan(String value) {
            addCriterion("RNAME <", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLessThanOrEqualTo(String value) {
            addCriterion("RNAME <=", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameLike(String value) {
            addCriterion("RNAME like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotLike(String value) {
            addCriterion("RNAME not like", value, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameIn(List<String> values) {
            addCriterion("RNAME in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotIn(List<String> values) {
            addCriterion("RNAME not in", values, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameBetween(String value1, String value2) {
            addCriterion("RNAME between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRnameNotBetween(String value1, String value2) {
            addCriterion("RNAME not between", value1, value2, "rname");
            return (Criteria) this;
        }

        public Criteria andRtelIsNull() {
            addCriterion("RTEL is null");
            return (Criteria) this;
        }

        public Criteria andRtelIsNotNull() {
            addCriterion("RTEL is not null");
            return (Criteria) this;
        }

        public Criteria andRtelEqualTo(String value) {
            addCriterion("RTEL =", value, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelNotEqualTo(String value) {
            addCriterion("RTEL <>", value, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelGreaterThan(String value) {
            addCriterion("RTEL >", value, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelGreaterThanOrEqualTo(String value) {
            addCriterion("RTEL >=", value, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelLessThan(String value) {
            addCriterion("RTEL <", value, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelLessThanOrEqualTo(String value) {
            addCriterion("RTEL <=", value, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelLike(String value) {
            addCriterion("RTEL like", value, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelNotLike(String value) {
            addCriterion("RTEL not like", value, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelIn(List<String> values) {
            addCriterion("RTEL in", values, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelNotIn(List<String> values) {
            addCriterion("RTEL not in", values, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelBetween(String value1, String value2) {
            addCriterion("RTEL between", value1, value2, "rtel");
            return (Criteria) this;
        }

        public Criteria andRtelNotBetween(String value1, String value2) {
            addCriterion("RTEL not between", value1, value2, "rtel");
            return (Criteria) this;
        }

        public Criteria andOfaddressIsNull() {
            addCriterion("OFADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andOfaddressIsNotNull() {
            addCriterion("OFADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andOfaddressEqualTo(String value) {
            addCriterion("OFADDRESS =", value, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressNotEqualTo(String value) {
            addCriterion("OFADDRESS <>", value, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressGreaterThan(String value) {
            addCriterion("OFADDRESS >", value, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressGreaterThanOrEqualTo(String value) {
            addCriterion("OFADDRESS >=", value, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressLessThan(String value) {
            addCriterion("OFADDRESS <", value, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressLessThanOrEqualTo(String value) {
            addCriterion("OFADDRESS <=", value, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressLike(String value) {
            addCriterion("OFADDRESS like", value, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressNotLike(String value) {
            addCriterion("OFADDRESS not like", value, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressIn(List<String> values) {
            addCriterion("OFADDRESS in", values, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressNotIn(List<String> values) {
            addCriterion("OFADDRESS not in", values, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressBetween(String value1, String value2) {
            addCriterion("OFADDRESS between", value1, value2, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfaddressNotBetween(String value1, String value2) {
            addCriterion("OFADDRESS not between", value1, value2, "ofaddress");
            return (Criteria) this;
        }

        public Criteria andOfpriceIsNull() {
            addCriterion("OFPRICE is null");
            return (Criteria) this;
        }

        public Criteria andOfpriceIsNotNull() {
            addCriterion("OFPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andOfpriceEqualTo(BigDecimal value) {
            addCriterion("OFPRICE =", value, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceNotEqualTo(BigDecimal value) {
            addCriterion("OFPRICE <>", value, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceGreaterThan(BigDecimal value) {
            addCriterion("OFPRICE >", value, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("OFPRICE >=", value, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceLessThan(BigDecimal value) {
            addCriterion("OFPRICE <", value, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("OFPRICE <=", value, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceIn(List<BigDecimal> values) {
            addCriterion("OFPRICE in", values, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceNotIn(List<BigDecimal> values) {
            addCriterion("OFPRICE not in", values, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OFPRICE between", value1, value2, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOfpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("OFPRICE not between", value1, value2, "ofprice");
            return (Criteria) this;
        }

        public Criteria andOftimeIsNull() {
            addCriterion("OFTIME is null");
            return (Criteria) this;
        }

        public Criteria andOftimeIsNotNull() {
            addCriterion("OFTIME is not null");
            return (Criteria) this;
        }

        public Criteria andOftimeEqualTo(Date value) {
            addCriterion("OFTIME =", value, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeNotEqualTo(Date value) {
            addCriterion("OFTIME <>", value, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeGreaterThan(Date value) {
            addCriterion("OFTIME >", value, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeGreaterThanOrEqualTo(Date value) {
            addCriterion("OFTIME >=", value, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeLessThan(Date value) {
            addCriterion("OFTIME <", value, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeLessThanOrEqualTo(Date value) {
            addCriterion("OFTIME <=", value, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeIn(List<Date> values) {
            addCriterion("OFTIME in", values, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeNotIn(List<Date> values) {
            addCriterion("OFTIME not in", values, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeBetween(Date value1, Date value2) {
            addCriterion("OFTIME between", value1, value2, "oftime");
            return (Criteria) this;
        }

        public Criteria andOftimeNotBetween(Date value1, Date value2) {
            addCriterion("OFTIME not between", value1, value2, "oftime");
            return (Criteria) this;
        }

        public Criteria andOfstateIsNull() {
            addCriterion("OFSTATE is null");
            return (Criteria) this;
        }

        public Criteria andOfstateIsNotNull() {
            addCriterion("OFSTATE is not null");
            return (Criteria) this;
        }

        public Criteria andOfstateEqualTo(String value) {
            addCriterion("OFSTATE =", value, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateNotEqualTo(String value) {
            addCriterion("OFSTATE <>", value, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateGreaterThan(String value) {
            addCriterion("OFSTATE >", value, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateGreaterThanOrEqualTo(String value) {
            addCriterion("OFSTATE >=", value, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateLessThan(String value) {
            addCriterion("OFSTATE <", value, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateLessThanOrEqualTo(String value) {
            addCriterion("OFSTATE <=", value, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateLike(String value) {
            addCriterion("OFSTATE like", value, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateNotLike(String value) {
            addCriterion("OFSTATE not like", value, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateIn(List<String> values) {
            addCriterion("OFSTATE in", values, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateNotIn(List<String> values) {
            addCriterion("OFSTATE not in", values, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateBetween(String value1, String value2) {
            addCriterion("OFSTATE between", value1, value2, "ofstate");
            return (Criteria) this;
        }

        public Criteria andOfstateNotBetween(String value1, String value2) {
            addCriterion("OFSTATE not between", value1, value2, "ofstate");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}