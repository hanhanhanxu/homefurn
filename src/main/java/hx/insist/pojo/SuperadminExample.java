package hx.insist.pojo;

import java.util.ArrayList;
import java.util.List;

public class SuperadminExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SuperadminExample() {
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

        public Criteria andSaidIsNull() {
            addCriterion("said is null");
            return (Criteria) this;
        }

        public Criteria andSaidIsNotNull() {
            addCriterion("said is not null");
            return (Criteria) this;
        }

        public Criteria andSaidEqualTo(String value) {
            addCriterion("said =", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotEqualTo(String value) {
            addCriterion("said <>", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidGreaterThan(String value) {
            addCriterion("said >", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidGreaterThanOrEqualTo(String value) {
            addCriterion("said >=", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLessThan(String value) {
            addCriterion("said <", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLessThanOrEqualTo(String value) {
            addCriterion("said <=", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidLike(String value) {
            addCriterion("said like", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotLike(String value) {
            addCriterion("said not like", value, "said");
            return (Criteria) this;
        }

        public Criteria andSaidIn(List<String> values) {
            addCriterion("said in", values, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotIn(List<String> values) {
            addCriterion("said not in", values, "said");
            return (Criteria) this;
        }

        public Criteria andSaidBetween(String value1, String value2) {
            addCriterion("said between", value1, value2, "said");
            return (Criteria) this;
        }

        public Criteria andSaidNotBetween(String value1, String value2) {
            addCriterion("said not between", value1, value2, "said");
            return (Criteria) this;
        }

        public Criteria andSanameIsNull() {
            addCriterion("saname is null");
            return (Criteria) this;
        }

        public Criteria andSanameIsNotNull() {
            addCriterion("saname is not null");
            return (Criteria) this;
        }

        public Criteria andSanameEqualTo(String value) {
            addCriterion("saname =", value, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameNotEqualTo(String value) {
            addCriterion("saname <>", value, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameGreaterThan(String value) {
            addCriterion("saname >", value, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameGreaterThanOrEqualTo(String value) {
            addCriterion("saname >=", value, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameLessThan(String value) {
            addCriterion("saname <", value, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameLessThanOrEqualTo(String value) {
            addCriterion("saname <=", value, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameLike(String value) {
            addCriterion("saname like", value, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameNotLike(String value) {
            addCriterion("saname not like", value, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameIn(List<String> values) {
            addCriterion("saname in", values, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameNotIn(List<String> values) {
            addCriterion("saname not in", values, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameBetween(String value1, String value2) {
            addCriterion("saname between", value1, value2, "saname");
            return (Criteria) this;
        }

        public Criteria andSanameNotBetween(String value1, String value2) {
            addCriterion("saname not between", value1, value2, "saname");
            return (Criteria) this;
        }

        public Criteria andSapassIsNull() {
            addCriterion("sapass is null");
            return (Criteria) this;
        }

        public Criteria andSapassIsNotNull() {
            addCriterion("sapass is not null");
            return (Criteria) this;
        }

        public Criteria andSapassEqualTo(String value) {
            addCriterion("sapass =", value, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassNotEqualTo(String value) {
            addCriterion("sapass <>", value, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassGreaterThan(String value) {
            addCriterion("sapass >", value, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassGreaterThanOrEqualTo(String value) {
            addCriterion("sapass >=", value, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassLessThan(String value) {
            addCriterion("sapass <", value, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassLessThanOrEqualTo(String value) {
            addCriterion("sapass <=", value, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassLike(String value) {
            addCriterion("sapass like", value, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassNotLike(String value) {
            addCriterion("sapass not like", value, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassIn(List<String> values) {
            addCriterion("sapass in", values, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassNotIn(List<String> values) {
            addCriterion("sapass not in", values, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassBetween(String value1, String value2) {
            addCriterion("sapass between", value1, value2, "sapass");
            return (Criteria) this;
        }

        public Criteria andSapassNotBetween(String value1, String value2) {
            addCriterion("sapass not between", value1, value2, "sapass");
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