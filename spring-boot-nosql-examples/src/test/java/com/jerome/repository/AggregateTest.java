package com.jerome.repository;

/**
 * @author suzhida
 * @since 2017/9/26 16:26
 */
public class AggregateTest {

    /*
    db.collection_xx.aggregate(
        {
            "$match": {
            "barId": ObjectId("5809913a711a65aeafafd076")
        }
        },
        {
            "$group": {
            "_id": {
                "barId": "$barId",
                "sex": "$sex"
            },
            "cnt": {
                "$sum": 1
            }
        }
        }
    )
    */
    public void sampleAggregate() {
        /*
        Criteria criteria = Criteria.where("barId").is(barId);
        if (roleType == RoleType.BLACK) {
            criteria = criteria.and("isBlack").is(Boolean.valueOf(true));
        } else if (roleType == RoleType.MANAGER) {
            criteria = criteria.and("isManager").is(Boolean.valueOf(true));
        }

        TypedAggregation<MerchantWechatBarUser> agg = newAggregation(MerchantWechatBarUser.class,
                Aggregation.match(criteria),
                Aggregation.group("barId", "sex").count().as("cnt"));

        AggregationResults<BarUserCountAgg> results =
                mongoTemplate.aggregate(agg, "collection_xx", BarUserCountAgg.class);
        List<BarUserCountAgg> mappedResult = results.getMappedResults();
        */
        /*
        BarUserCountAgg
        private ObjectId barId;
        private Long cnt;
        private String sex;
        */

    }

}
