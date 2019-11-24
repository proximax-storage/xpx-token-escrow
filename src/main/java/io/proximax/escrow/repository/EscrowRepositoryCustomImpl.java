package io.proximax.escrow.repository;

import io.proximax.escrow.document.Escrow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class EscrowRepositoryCustomImpl implements EscrowRepositoryCustom {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public long findMaxId() {
        Query query = new Query();
        query.with(new Sort(Sort.Direction.DESC, "id"));
        query.limit(1);
        Escrow r = mongoTemplate.findOne(query, Escrow.class);
        if (r == null) {
            return 0L;
        }
        return r.getId();
    }

    @Override
    public void save(Escrow row) {
        mongoTemplate.save(row);
    }

    public boolean monitor() {
        try {
            System.out.println("Monitor wallets");                    
//            Query query = new Query();
//            Date yesterday = DateUtils.addDays(new Date(), -1);
//            System.out.println("Yesterday: " + yesterday);
//            query.addCriteria(Criteria.where("status").is(CONSTS.STATUS_WAITING_PAY).andOperator(Criteria.where("registration.registerDate").lt(yesterday)));
//            List<License> lics = mongoTemplate.find(query, License.class);
//            if (lics != null && lics.size() > 0) {
//                for (License lic : lics) {
//                    lic.setStatus(CONSTS.STATUS_REGISTER_VOID);
//                    mongoTemplate.save(lic);
//                }
//                //mongoTemplate.save(lics);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return true;

    }

}
