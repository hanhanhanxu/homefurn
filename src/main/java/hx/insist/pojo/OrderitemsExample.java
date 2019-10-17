package hx.insist.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class OrderitemsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderitemsExample() {
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

        public Criteria andOsidIsNull() {
            addCriterion("OSID is null");
            return (Criteria) this;
        }

        public Criteria andOsidIsNotNull() {
            addCriterion("OSID is not null");
            return (Criteria) this;
        }

        public Criteria andOsidEqualTo(String value) {
            addCriterion("OSID =", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotEqualTo(String value) {
            addCriterion("OSID <>", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidGreaterThan(String value) {
            addCriterion("OSID >", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidGreaterThanOrEqualTo(String value) {
            addCriterion("OSID >=", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidLessThan(String value) {
            addCriterion("OSID <", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidLessThanOrEqualTo(String value) {
            addCriterion("OSID <=", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidLike(String value) {
            addCriterion("OSID like", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotLike(String value) {
            addCriterion("OSID not like", value, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidIn(List<String> values) {
            addCriterion("OSID in", values, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotIn(List<String> values) {
            addCriterion("OSID not in", values, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidBetween(String value1, String value2) {
            addCriterion("OSID between", value1, value2, "osid");
            return (Criteria) this;
        }

        public Criteria andOsidNotBetween(String value1, String value2) {
            addCriterion("OSID not between", value1, value2, "osid");
            return (Criteria) this;
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

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(String value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(String value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(String value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(String value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(String value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(String value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLike(String value) {
            addCriterion("FID like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotLike(String value) {
            addCriterion("FID not like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<String> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<String> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(String value1, String value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(String value1, String value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("FNAME is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("FNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("FNAME =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("FNAME <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("FNAME >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("FNAME >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("FNAME <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("FNAME <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("FNAME like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("FNAME not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("FNAME in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("FNAME not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("FNAME between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("FNAME not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNull() {
            addCriterion("FPRICE is null");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNotNull() {
            addCriterion("FPRICE is not null");
            return (Criteria) this;
        }

        public Criteria andFpriceEqualTo(BigDecimal value) {
            addCriterion("FPRICE =", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotEqualTo(BigDecimal value) {
            addCriterion("FPRICE <>", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThan(BigDecimal value) {
            addCriterion("FPRICE >", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FPRICE >=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThan(BigDecimal value) {
            addCriterion("FPRICE <", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FPRICE <=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceIn(List<BigDecimal> values) {
            addCriterion("FPRICE in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotIn(List<BigDecimal> values) {
            addCriterion("FPRICE not in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FPRICE between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FPRICE not between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFnumIsNull() {
            addCriterion("FNUM is null");
            return (Criteria) this;
        }

        public Criteria andFnumIsNotNull() {
            addCriterion("FNUM is not null");
            return (Criteria) this;
        }

        public Criteria andFnumEqualTo(Integer value) {
            addCriterion("FNUM =", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumNotEqualTo(Integer value) {
            addCriterion("FNUM <>", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumGreaterThan(Integer value) {
            addCriterion("FNUM >", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("FNUM >=", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumLessThan(Integer value) {
            addCriterion("FNUM <", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumLessThanOrEqualTo(Integer value) {
            addCriterion("FNUM <=", value, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumIn(List<Integer> values) {
            addCriterion("FNUM in", values, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumNotIn(List<Integer> values) {
            addCriterion("FNUM not in", values, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumBetween(Integer value1, Integer value2) {
            addCriterion("FNUM between", value1, value2, "fnum");
            return (Criteria) this;
        }

        public Criteria andFnumNotBetween(Integer value1, Integer value2) {
            addCriterion("FNUM not between", value1, value2, "fnum");
            return (Criteria) this;
        }

        public Criteria andFpayIsNull() {
            addCriterion("FPAY is null");
            return (Criteria) this;
        }

        public Criteria andFpayIsNotNull() {
            addCriterion("FPAY is not null");
            return (Criteria) this;
        }

        public Criteria andFpayEqualTo(BigDecimal value) {
            addCriterion("FPAY =", value, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayNotEqualTo(BigDecimal value) {
            addCriterion("FPAY <>", value, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayGreaterThan(BigDecimal value) {
            addCriterion("FPAY >", value, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("FPAY >=", value, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayLessThan(BigDecimal value) {
            addCriterion("FPAY <", value, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayLessThanOrEqualTo(BigDecimal value) {
            addCriterion("FPAY <=", value, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayIn(List<BigDecimal> values) {
            addCriterion("FPAY in", values, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayNotIn(List<BigDecimal> values) {
            addCriterion("FPAY not in", values, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FPAY between", value1, value2, "fpay");
            return (Criteria) this;
        }

        public Criteria andFpayNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("FPAY not between", value1, value2, "fpay");
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