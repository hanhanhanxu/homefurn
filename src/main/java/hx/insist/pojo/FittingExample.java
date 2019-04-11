package hx.insist.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class FittingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FittingExample() {
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

        public Criteria andFidIsNull() {
            addCriterion("fid is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("fid is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(String value) {
            addCriterion("fid =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(String value) {
            addCriterion("fid <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(String value) {
            addCriterion("fid >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(String value) {
            addCriterion("fid >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(String value) {
            addCriterion("fid <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(String value) {
            addCriterion("fid <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLike(String value) {
            addCriterion("fid like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotLike(String value) {
            addCriterion("fid not like", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<String> values) {
            addCriterion("fid in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<String> values) {
            addCriterion("fid not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(String value1, String value2) {
            addCriterion("fid between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(String value1, String value2) {
            addCriterion("fid not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("fname is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("fname is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("fname =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("fname <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("fname >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("fname >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("fname <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("fname <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("fname like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("fname not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("fname in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("fname not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("fname between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("fname not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNull() {
            addCriterion("ftype is null");
            return (Criteria) this;
        }

        public Criteria andFtypeIsNotNull() {
            addCriterion("ftype is not null");
            return (Criteria) this;
        }

        public Criteria andFtypeEqualTo(String value) {
            addCriterion("ftype =", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotEqualTo(String value) {
            addCriterion("ftype <>", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThan(String value) {
            addCriterion("ftype >", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeGreaterThanOrEqualTo(String value) {
            addCriterion("ftype >=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThan(String value) {
            addCriterion("ftype <", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLessThanOrEqualTo(String value) {
            addCriterion("ftype <=", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeLike(String value) {
            addCriterion("ftype like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotLike(String value) {
            addCriterion("ftype not like", value, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeIn(List<String> values) {
            addCriterion("ftype in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotIn(List<String> values) {
            addCriterion("ftype not in", values, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeBetween(String value1, String value2) {
            addCriterion("ftype between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFtypeNotBetween(String value1, String value2) {
            addCriterion("ftype not between", value1, value2, "ftype");
            return (Criteria) this;
        }

        public Criteria andFstyleIsNull() {
            addCriterion("fstyle is null");
            return (Criteria) this;
        }

        public Criteria andFstyleIsNotNull() {
            addCriterion("fstyle is not null");
            return (Criteria) this;
        }

        public Criteria andFstyleEqualTo(String value) {
            addCriterion("fstyle =", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleNotEqualTo(String value) {
            addCriterion("fstyle <>", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleGreaterThan(String value) {
            addCriterion("fstyle >", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleGreaterThanOrEqualTo(String value) {
            addCriterion("fstyle >=", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleLessThan(String value) {
            addCriterion("fstyle <", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleLessThanOrEqualTo(String value) {
            addCriterion("fstyle <=", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleLike(String value) {
            addCriterion("fstyle like", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleNotLike(String value) {
            addCriterion("fstyle not like", value, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleIn(List<String> values) {
            addCriterion("fstyle in", values, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleNotIn(List<String> values) {
            addCriterion("fstyle not in", values, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleBetween(String value1, String value2) {
            addCriterion("fstyle between", value1, value2, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFstyleNotBetween(String value1, String value2) {
            addCriterion("fstyle not between", value1, value2, "fstyle");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNull() {
            addCriterion("fprice is null");
            return (Criteria) this;
        }

        public Criteria andFpriceIsNotNull() {
            addCriterion("fprice is not null");
            return (Criteria) this;
        }

        public Criteria andFpriceEqualTo(BigDecimal value) {
            addCriterion("fprice =", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotEqualTo(BigDecimal value) {
            addCriterion("fprice <>", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThan(BigDecimal value) {
            addCriterion("fprice >", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("fprice >=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThan(BigDecimal value) {
            addCriterion("fprice <", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("fprice <=", value, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceIn(List<BigDecimal> values) {
            addCriterion("fprice in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotIn(List<BigDecimal> values) {
            addCriterion("fprice not in", values, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fprice between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFpriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("fprice not between", value1, value2, "fprice");
            return (Criteria) this;
        }

        public Criteria andFimgIsNull() {
            addCriterion("fimg is null");
            return (Criteria) this;
        }

        public Criteria andFimgIsNotNull() {
            addCriterion("fimg is not null");
            return (Criteria) this;
        }

        public Criteria andFimgEqualTo(String value) {
            addCriterion("fimg =", value, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgNotEqualTo(String value) {
            addCriterion("fimg <>", value, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgGreaterThan(String value) {
            addCriterion("fimg >", value, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgGreaterThanOrEqualTo(String value) {
            addCriterion("fimg >=", value, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgLessThan(String value) {
            addCriterion("fimg <", value, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgLessThanOrEqualTo(String value) {
            addCriterion("fimg <=", value, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgLike(String value) {
            addCriterion("fimg like", value, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgNotLike(String value) {
            addCriterion("fimg not like", value, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgIn(List<String> values) {
            addCriterion("fimg in", values, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgNotIn(List<String> values) {
            addCriterion("fimg not in", values, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgBetween(String value1, String value2) {
            addCriterion("fimg between", value1, value2, "fimg");
            return (Criteria) this;
        }

        public Criteria andFimgNotBetween(String value1, String value2) {
            addCriterion("fimg not between", value1, value2, "fimg");
            return (Criteria) this;
        }

        public Criteria andFintroIsNull() {
            addCriterion("fintro is null");
            return (Criteria) this;
        }

        public Criteria andFintroIsNotNull() {
            addCriterion("fintro is not null");
            return (Criteria) this;
        }

        public Criteria andFintroEqualTo(String value) {
            addCriterion("fintro =", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroNotEqualTo(String value) {
            addCriterion("fintro <>", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroGreaterThan(String value) {
            addCriterion("fintro >", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroGreaterThanOrEqualTo(String value) {
            addCriterion("fintro >=", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroLessThan(String value) {
            addCriterion("fintro <", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroLessThanOrEqualTo(String value) {
            addCriterion("fintro <=", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroLike(String value) {
            addCriterion("fintro like", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroNotLike(String value) {
            addCriterion("fintro not like", value, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroIn(List<String> values) {
            addCriterion("fintro in", values, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroNotIn(List<String> values) {
            addCriterion("fintro not in", values, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroBetween(String value1, String value2) {
            addCriterion("fintro between", value1, value2, "fintro");
            return (Criteria) this;
        }

        public Criteria andFintroNotBetween(String value1, String value2) {
            addCriterion("fintro not between", value1, value2, "fintro");
            return (Criteria) this;
        }

        public Criteria andFsvolumeIsNull() {
            addCriterion("fsvolume is null");
            return (Criteria) this;
        }

        public Criteria andFsvolumeIsNotNull() {
            addCriterion("fsvolume is not null");
            return (Criteria) this;
        }

        public Criteria andFsvolumeEqualTo(Integer value) {
            addCriterion("fsvolume =", value, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeNotEqualTo(Integer value) {
            addCriterion("fsvolume <>", value, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeGreaterThan(Integer value) {
            addCriterion("fsvolume >", value, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsvolume >=", value, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeLessThan(Integer value) {
            addCriterion("fsvolume <", value, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeLessThanOrEqualTo(Integer value) {
            addCriterion("fsvolume <=", value, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeIn(List<Integer> values) {
            addCriterion("fsvolume in", values, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeNotIn(List<Integer> values) {
            addCriterion("fsvolume not in", values, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeBetween(Integer value1, Integer value2) {
            addCriterion("fsvolume between", value1, value2, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsvolumeNotBetween(Integer value1, Integer value2) {
            addCriterion("fsvolume not between", value1, value2, "fsvolume");
            return (Criteria) this;
        }

        public Criteria andFsignIsNull() {
            addCriterion("fsign is null");
            return (Criteria) this;
        }

        public Criteria andFsignIsNotNull() {
            addCriterion("fsign is not null");
            return (Criteria) this;
        }

        public Criteria andFsignEqualTo(Integer value) {
            addCriterion("fsign =", value, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignNotEqualTo(Integer value) {
            addCriterion("fsign <>", value, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignGreaterThan(Integer value) {
            addCriterion("fsign >", value, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignGreaterThanOrEqualTo(Integer value) {
            addCriterion("fsign >=", value, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignLessThan(Integer value) {
            addCriterion("fsign <", value, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignLessThanOrEqualTo(Integer value) {
            addCriterion("fsign <=", value, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignIn(List<Integer> values) {
            addCriterion("fsign in", values, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignNotIn(List<Integer> values) {
            addCriterion("fsign not in", values, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignBetween(Integer value1, Integer value2) {
            addCriterion("fsign between", value1, value2, "fsign");
            return (Criteria) this;
        }

        public Criteria andFsignNotBetween(Integer value1, Integer value2) {
            addCriterion("fsign not between", value1, value2, "fsign");
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