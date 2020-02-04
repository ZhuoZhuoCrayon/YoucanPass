package com.crayon.youcanpass.model;

import java.util.ArrayList;
import java.util.List;

public class SmsFreetimeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SmsFreetimeExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andWeekdayIsNull() {
            addCriterion("weekday is null");
            return (Criteria) this;
        }

        public Criteria andWeekdayIsNotNull() {
            addCriterion("weekday is not null");
            return (Criteria) this;
        }

        public Criteria andWeekdayEqualTo(Integer value) {
            addCriterion("weekday =", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotEqualTo(Integer value) {
            addCriterion("weekday <>", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayGreaterThan(Integer value) {
            addCriterion("weekday >", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayGreaterThanOrEqualTo(Integer value) {
            addCriterion("weekday >=", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLessThan(Integer value) {
            addCriterion("weekday <", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayLessThanOrEqualTo(Integer value) {
            addCriterion("weekday <=", value, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayIn(List<Integer> values) {
            addCriterion("weekday in", values, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotIn(List<Integer> values) {
            addCriterion("weekday not in", values, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayBetween(Integer value1, Integer value2) {
            addCriterion("weekday between", value1, value2, "weekday");
            return (Criteria) this;
        }

        public Criteria andWeekdayNotBetween(Integer value1, Integer value2) {
            addCriterion("weekday not between", value1, value2, "weekday");
            return (Criteria) this;
        }

        public Criteria andSectionBeginIsNull() {
            addCriterion("section_begin is null");
            return (Criteria) this;
        }

        public Criteria andSectionBeginIsNotNull() {
            addCriterion("section_begin is not null");
            return (Criteria) this;
        }

        public Criteria andSectionBeginEqualTo(Integer value) {
            addCriterion("section_begin =", value, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginNotEqualTo(Integer value) {
            addCriterion("section_begin <>", value, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginGreaterThan(Integer value) {
            addCriterion("section_begin >", value, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginGreaterThanOrEqualTo(Integer value) {
            addCriterion("section_begin >=", value, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginLessThan(Integer value) {
            addCriterion("section_begin <", value, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginLessThanOrEqualTo(Integer value) {
            addCriterion("section_begin <=", value, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginIn(List<Integer> values) {
            addCriterion("section_begin in", values, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginNotIn(List<Integer> values) {
            addCriterion("section_begin not in", values, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginBetween(Integer value1, Integer value2) {
            addCriterion("section_begin between", value1, value2, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionBeginNotBetween(Integer value1, Integer value2) {
            addCriterion("section_begin not between", value1, value2, "sectionBegin");
            return (Criteria) this;
        }

        public Criteria andSectionEndIsNull() {
            addCriterion("section_end is null");
            return (Criteria) this;
        }

        public Criteria andSectionEndIsNotNull() {
            addCriterion("section_end is not null");
            return (Criteria) this;
        }

        public Criteria andSectionEndEqualTo(Integer value) {
            addCriterion("section_end =", value, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndNotEqualTo(Integer value) {
            addCriterion("section_end <>", value, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndGreaterThan(Integer value) {
            addCriterion("section_end >", value, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndGreaterThanOrEqualTo(Integer value) {
            addCriterion("section_end >=", value, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndLessThan(Integer value) {
            addCriterion("section_end <", value, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndLessThanOrEqualTo(Integer value) {
            addCriterion("section_end <=", value, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndIn(List<Integer> values) {
            addCriterion("section_end in", values, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndNotIn(List<Integer> values) {
            addCriterion("section_end not in", values, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndBetween(Integer value1, Integer value2) {
            addCriterion("section_end between", value1, value2, "sectionEnd");
            return (Criteria) this;
        }

        public Criteria andSectionEndNotBetween(Integer value1, Integer value2) {
            addCriterion("section_end not between", value1, value2, "sectionEnd");
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