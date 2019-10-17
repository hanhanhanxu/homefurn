package hx.insist.pojo;

import java.util.ArrayList;
import java.util.List;

public class LunboExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LunboExample() {
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

        public Criteria andLidIsNull() {
            addCriterion("LID is null");
            return (Criteria) this;
        }

        public Criteria andLidIsNotNull() {
            addCriterion("LID is not null");
            return (Criteria) this;
        }

        public Criteria andLidEqualTo(String value) {
            addCriterion("LID =", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotEqualTo(String value) {
            addCriterion("LID <>", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThan(String value) {
            addCriterion("LID >", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidGreaterThanOrEqualTo(String value) {
            addCriterion("LID >=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThan(String value) {
            addCriterion("LID <", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLessThanOrEqualTo(String value) {
            addCriterion("LID <=", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidLike(String value) {
            addCriterion("LID like", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotLike(String value) {
            addCriterion("LID not like", value, "lid");
            return (Criteria) this;
        }

        public Criteria andLidIn(List<String> values) {
            addCriterion("LID in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotIn(List<String> values) {
            addCriterion("LID not in", values, "lid");
            return (Criteria) this;
        }

        public Criteria andLidBetween(String value1, String value2) {
            addCriterion("LID between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLidNotBetween(String value1, String value2) {
            addCriterion("LID not between", value1, value2, "lid");
            return (Criteria) this;
        }

        public Criteria andLnumIsNull() {
            addCriterion("LNUM is null");
            return (Criteria) this;
        }

        public Criteria andLnumIsNotNull() {
            addCriterion("LNUM is not null");
            return (Criteria) this;
        }

        public Criteria andLnumEqualTo(Integer value) {
            addCriterion("LNUM =", value, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumNotEqualTo(Integer value) {
            addCriterion("LNUM <>", value, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumGreaterThan(Integer value) {
            addCriterion("LNUM >", value, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("LNUM >=", value, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumLessThan(Integer value) {
            addCriterion("LNUM <", value, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumLessThanOrEqualTo(Integer value) {
            addCriterion("LNUM <=", value, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumIn(List<Integer> values) {
            addCriterion("LNUM in", values, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumNotIn(List<Integer> values) {
            addCriterion("LNUM not in", values, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumBetween(Integer value1, Integer value2) {
            addCriterion("LNUM between", value1, value2, "lnum");
            return (Criteria) this;
        }

        public Criteria andLnumNotBetween(Integer value1, Integer value2) {
            addCriterion("LNUM not between", value1, value2, "lnum");
            return (Criteria) this;
        }

        public Criteria andLpicIsNull() {
            addCriterion("LPIC is null");
            return (Criteria) this;
        }

        public Criteria andLpicIsNotNull() {
            addCriterion("LPIC is not null");
            return (Criteria) this;
        }

        public Criteria andLpicEqualTo(String value) {
            addCriterion("LPIC =", value, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicNotEqualTo(String value) {
            addCriterion("LPIC <>", value, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicGreaterThan(String value) {
            addCriterion("LPIC >", value, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicGreaterThanOrEqualTo(String value) {
            addCriterion("LPIC >=", value, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicLessThan(String value) {
            addCriterion("LPIC <", value, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicLessThanOrEqualTo(String value) {
            addCriterion("LPIC <=", value, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicLike(String value) {
            addCriterion("LPIC like", value, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicNotLike(String value) {
            addCriterion("LPIC not like", value, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicIn(List<String> values) {
            addCriterion("LPIC in", values, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicNotIn(List<String> values) {
            addCriterion("LPIC not in", values, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicBetween(String value1, String value2) {
            addCriterion("LPIC between", value1, value2, "lpic");
            return (Criteria) this;
        }

        public Criteria andLpicNotBetween(String value1, String value2) {
            addCriterion("LPIC not between", value1, value2, "lpic");
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