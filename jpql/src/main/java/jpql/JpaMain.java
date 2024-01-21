package jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamA");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member1");
            member.setAge(10);

            member.setTeam(team);

            em.persist(member);

            em.flush();
            em.clear();

//            String query = "select m from Member m join m.team t";
//            String query = "select m from Member m left join m.team t";
//            String query = "select m from Member m, Team t where m.username = t.name";
//            String query = "select m from Member m join m.team t on t.name = 'teamA'";
            String query = "select m from Member m left join Team t on m.username = t.name";
            List<Member> result = em.createQuery(query, Member.class)
                    .getResultList();


            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }

}
