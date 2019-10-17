package hx.insist.pojo;

import java.util.ArrayList;
import java.util.List;

public class FittingStockExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FittingStockExample() {
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

        public Criteria andFsidIsNull() {
            addCriterion("FSID is null");
            return (Criteria) this;
        }

        public Criteria andFsidIsNotNull() {
            addCriterion("FSID is not null");
            return (Criteria) this;
        }

        public Criteria andFsidEqualTo(String value) {
            addCriterion("FSID =", value, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidNotEqualTo(String value) {
            addCriterion("FSID <>", value, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidGreaterThan(String value) {
            addCriterion("FSID >", value, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidGreaterThanOrEqualTo(String value) {
            addCriterion("FSID >=", value, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidLessThan(String value) {
            addCriterion("FSID <", value, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidLessThanOrEqualTo(String value) {
            addCriterion("FSID <=", value, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidLike(String value) {
            addCriterion("FSID like", value, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidNotLike(String value) {
            addCriterion("FSID not like", value, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidIn(List<String> values) {
            addCriterion("FSID in", values, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidNotIn(List<String> values) {
            addCriterion("FSID not in", values, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidBetween(String value1, String value2) {
            addCriterion("FSID between", value1, value2, "fsid");
            return (Criteria) this;
        }

        public Criteria andFsidNotBetween(String value1, String value2) {
            addCriterion("FSID not between", value1, value2, "fsid");
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

        public Criteria andFsnumIsNull() {
            addCriterion("FSNUM is null");
            return (Criteria) this;
        }

        public Criteria andFsnumIsNotNull() {
            addCriterion("FSNUM is not null");
            return (Criteria) this;
        }

        public Criteria andFsnumEqualTo(Integer value) {
            addCriterion("FSNUM =", value, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumNotEqualTo(Integer value) {
            addCriterion("FSNUM <>", value, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumGreaterThan(Integer value) {
            addCriterion("FSNUM >", value, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumGreaterThanOrEqualTo(Integer value) {
            addCriterion("FSNUM >=", value, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumLessThan(Integer value) {
            addCriterion("FSNUM <", value, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumLessThanOrEqualTo(Integer value) {
            addCriterion("FSNUM <=", value, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumIn(List<Integer> values) {
            addCriterion("FSNUM in", values, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumNotIn(List<Integer> values) {
            addCriterion("FSNUM not in", values, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumBetween(Integer value1, Integer value2) {
            addCriterion("FSNUM between", value1, value2, "fsnum");
            return (Criteria) this;
        }

        public Criteria andFsnumNotBetween(Integer value1, Integer value2) {
            addCriterion("FSNUM not between", value1, value2, "fsnum");
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