package hx.insist.pojo;

import java.util.ArrayList;
import java.util.List;

public class AdminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AdminExample() {
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

        public Criteria andAidIsNull() {
            addCriterion("aid is null");
            return (Criteria) this;
        }

        public Criteria andAidIsNotNull() {
            addCriterion("aid is not null");
            return (Criteria) this;
        }

        public Criteria andAidEqualTo(String value) {
            addCriterion("aid =", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotEqualTo(String value) {
            addCriterion("aid <>", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThan(String value) {
            addCriterion("aid >", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidGreaterThanOrEqualTo(String value) {
            addCriterion("aid >=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThan(String value) {
            addCriterion("aid <", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLessThanOrEqualTo(String value) {
            addCriterion("aid <=", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidLike(String value) {
            addCriterion("aid like", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotLike(String value) {
            addCriterion("aid not like", value, "aid");
            return (Criteria) this;
        }

        public Criteria andAidIn(List<String> values) {
            addCriterion("aid in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotIn(List<String> values) {
            addCriterion("aid not in", values, "aid");
            return (Criteria) this;
        }

        public Criteria andAidBetween(String value1, String value2) {
            addCriterion("aid between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAidNotBetween(String value1, String value2) {
            addCriterion("aid not between", value1, value2, "aid");
            return (Criteria) this;
        }

        public Criteria andAusernameIsNull() {
            addCriterion("ausername is null");
            return (Criteria) this;
        }

        public Criteria andAusernameIsNotNull() {
            addCriterion("ausername is not null");
            return (Criteria) this;
        }

        public Criteria andAusernameEqualTo(String value) {
            addCriterion("ausername =", value, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameNotEqualTo(String value) {
            addCriterion("ausername <>", value, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameGreaterThan(String value) {
            addCriterion("ausername >", value, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameGreaterThanOrEqualTo(String value) {
            addCriterion("ausername >=", value, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameLessThan(String value) {
            addCriterion("ausername <", value, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameLessThanOrEqualTo(String value) {
            addCriterion("ausername <=", value, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameLike(String value) {
            addCriterion("ausername like", value, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameNotLike(String value) {
            addCriterion("ausername not like", value, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameIn(List<String> values) {
            addCriterion("ausername in", values, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameNotIn(List<String> values) {
            addCriterion("ausername not in", values, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameBetween(String value1, String value2) {
            addCriterion("ausername between", value1, value2, "ausername");
            return (Criteria) this;
        }

        public Criteria andAusernameNotBetween(String value1, String value2) {
            addCriterion("ausername not between", value1, value2, "ausername");
            return (Criteria) this;
        }

        public Criteria andApasswordIsNull() {
            addCriterion("apassword is null");
            return (Criteria) this;
        }

        public Criteria andApasswordIsNotNull() {
            addCriterion("apassword is not null");
            return (Criteria) this;
        }

        public Criteria andApasswordEqualTo(String value) {
            addCriterion("apassword =", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordNotEqualTo(String value) {
            addCriterion("apassword <>", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordGreaterThan(String value) {
            addCriterion("apassword >", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordGreaterThanOrEqualTo(String value) {
            addCriterion("apassword >=", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordLessThan(String value) {
            addCriterion("apassword <", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordLessThanOrEqualTo(String value) {
            addCriterion("apassword <=", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordLike(String value) {
            addCriterion("apassword like", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordNotLike(String value) {
            addCriterion("apassword not like", value, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordIn(List<String> values) {
            addCriterion("apassword in", values, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordNotIn(List<String> values) {
            addCriterion("apassword not in", values, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordBetween(String value1, String value2) {
            addCriterion("apassword between", value1, value2, "apassword");
            return (Criteria) this;
        }

        public Criteria andApasswordNotBetween(String value1, String value2) {
            addCriterion("apassword not between", value1, value2, "apassword");
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