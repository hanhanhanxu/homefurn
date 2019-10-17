package hx.insist.pojo;

import java.util.ArrayList;
import java.util.List;

public class AddressExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AddressExample() {
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

        public Criteria andUidIsNull() {
            addCriterion("uid is null");
            return (Criteria) this;
        }

        public Criteria andUidIsNotNull() {
            addCriterion("uid is not null");
            return (Criteria) this;
        }

        public Criteria andUidEqualTo(String value) {
            addCriterion("uid =", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotEqualTo(String value) {
            addCriterion("uid <>", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThan(String value) {
            addCriterion("uid >", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidGreaterThanOrEqualTo(String value) {
            addCriterion("uid >=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThan(String value) {
            addCriterion("uid <", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLessThanOrEqualTo(String value) {
            addCriterion("uid <=", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidLike(String value) {
            addCriterion("uid like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotLike(String value) {
            addCriterion("uid not like", value, "uid");
            return (Criteria) this;
        }

        public Criteria andUidIn(List<String> values) {
            addCriterion("uid in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotIn(List<String> values) {
            addCriterion("uid not in", values, "uid");
            return (Criteria) this;
        }

        public Criteria andUidBetween(String value1, String value2) {
            addCriterion("uid between", value1, value2, "uid");
            return (Criteria) this;
        }

        public Criteria andUidNotBetween(String value1, String value2) {
            addCriterion("uid not between", value1, value2, "uid");
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

        public Criteria andRproIsNull() {
            addCriterion("RPRO is null");
            return (Criteria) this;
        }

        public Criteria andRproIsNotNull() {
            addCriterion("RPRO is not null");
            return (Criteria) this;
        }

        public Criteria andRproEqualTo(String value) {
            addCriterion("RPRO =", value, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproNotEqualTo(String value) {
            addCriterion("RPRO <>", value, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproGreaterThan(String value) {
            addCriterion("RPRO >", value, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproGreaterThanOrEqualTo(String value) {
            addCriterion("RPRO >=", value, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproLessThan(String value) {
            addCriterion("RPRO <", value, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproLessThanOrEqualTo(String value) {
            addCriterion("RPRO <=", value, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproLike(String value) {
            addCriterion("RPRO like", value, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproNotLike(String value) {
            addCriterion("RPRO not like", value, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproIn(List<String> values) {
            addCriterion("RPRO in", values, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproNotIn(List<String> values) {
            addCriterion("RPRO not in", values, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproBetween(String value1, String value2) {
            addCriterion("RPRO between", value1, value2, "rpro");
            return (Criteria) this;
        }

        public Criteria andRproNotBetween(String value1, String value2) {
            addCriterion("RPRO not between", value1, value2, "rpro");
            return (Criteria) this;
        }

        public Criteria andRcityIsNull() {
            addCriterion("RCITY is null");
            return (Criteria) this;
        }

        public Criteria andRcityIsNotNull() {
            addCriterion("RCITY is not null");
            return (Criteria) this;
        }

        public Criteria andRcityEqualTo(String value) {
            addCriterion("RCITY =", value, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityNotEqualTo(String value) {
            addCriterion("RCITY <>", value, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityGreaterThan(String value) {
            addCriterion("RCITY >", value, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityGreaterThanOrEqualTo(String value) {
            addCriterion("RCITY >=", value, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityLessThan(String value) {
            addCriterion("RCITY <", value, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityLessThanOrEqualTo(String value) {
            addCriterion("RCITY <=", value, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityLike(String value) {
            addCriterion("RCITY like", value, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityNotLike(String value) {
            addCriterion("RCITY not like", value, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityIn(List<String> values) {
            addCriterion("RCITY in", values, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityNotIn(List<String> values) {
            addCriterion("RCITY not in", values, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityBetween(String value1, String value2) {
            addCriterion("RCITY between", value1, value2, "rcity");
            return (Criteria) this;
        }

        public Criteria andRcityNotBetween(String value1, String value2) {
            addCriterion("RCITY not between", value1, value2, "rcity");
            return (Criteria) this;
        }

        public Criteria andRareaIsNull() {
            addCriterion("RAREA is null");
            return (Criteria) this;
        }

        public Criteria andRareaIsNotNull() {
            addCriterion("RAREA is not null");
            return (Criteria) this;
        }

        public Criteria andRareaEqualTo(String value) {
            addCriterion("RAREA =", value, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaNotEqualTo(String value) {
            addCriterion("RAREA <>", value, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaGreaterThan(String value) {
            addCriterion("RAREA >", value, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaGreaterThanOrEqualTo(String value) {
            addCriterion("RAREA >=", value, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaLessThan(String value) {
            addCriterion("RAREA <", value, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaLessThanOrEqualTo(String value) {
            addCriterion("RAREA <=", value, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaLike(String value) {
            addCriterion("RAREA like", value, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaNotLike(String value) {
            addCriterion("RAREA not like", value, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaIn(List<String> values) {
            addCriterion("RAREA in", values, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaNotIn(List<String> values) {
            addCriterion("RAREA not in", values, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaBetween(String value1, String value2) {
            addCriterion("RAREA between", value1, value2, "rarea");
            return (Criteria) this;
        }

        public Criteria andRareaNotBetween(String value1, String value2) {
            addCriterion("RAREA not between", value1, value2, "rarea");
            return (Criteria) this;
        }

        public Criteria andRinfoIsNull() {
            addCriterion("RINFO is null");
            return (Criteria) this;
        }

        public Criteria andRinfoIsNotNull() {
            addCriterion("RINFO is not null");
            return (Criteria) this;
        }

        public Criteria andRinfoEqualTo(String value) {
            addCriterion("RINFO =", value, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoNotEqualTo(String value) {
            addCriterion("RINFO <>", value, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoGreaterThan(String value) {
            addCriterion("RINFO >", value, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoGreaterThanOrEqualTo(String value) {
            addCriterion("RINFO >=", value, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoLessThan(String value) {
            addCriterion("RINFO <", value, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoLessThanOrEqualTo(String value) {
            addCriterion("RINFO <=", value, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoLike(String value) {
            addCriterion("RINFO like", value, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoNotLike(String value) {
            addCriterion("RINFO not like", value, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoIn(List<String> values) {
            addCriterion("RINFO in", values, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoNotIn(List<String> values) {
            addCriterion("RINFO not in", values, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoBetween(String value1, String value2) {
            addCriterion("RINFO between", value1, value2, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRinfoNotBetween(String value1, String value2) {
            addCriterion("RINFO not between", value1, value2, "rinfo");
            return (Criteria) this;
        }

        public Criteria andRmoIsNull() {
            addCriterion("RMO is null");
            return (Criteria) this;
        }

        public Criteria andRmoIsNotNull() {
            addCriterion("RMO is not null");
            return (Criteria) this;
        }

        public Criteria andRmoEqualTo(Integer value) {
            addCriterion("RMO =", value, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoNotEqualTo(Integer value) {
            addCriterion("RMO <>", value, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoGreaterThan(Integer value) {
            addCriterion("RMO >", value, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoGreaterThanOrEqualTo(Integer value) {
            addCriterion("RMO >=", value, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoLessThan(Integer value) {
            addCriterion("RMO <", value, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoLessThanOrEqualTo(Integer value) {
            addCriterion("RMO <=", value, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoIn(List<Integer> values) {
            addCriterion("RMO in", values, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoNotIn(List<Integer> values) {
            addCriterion("RMO not in", values, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoBetween(Integer value1, Integer value2) {
            addCriterion("RMO between", value1, value2, "rmo");
            return (Criteria) this;
        }

        public Criteria andRmoNotBetween(Integer value1, Integer value2) {
            addCriterion("RMO not between", value1, value2, "rmo");
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