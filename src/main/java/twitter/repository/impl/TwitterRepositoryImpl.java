package twitter.repository.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import twitter.model.TwitterMessage;
import twitter.repository.TwitterRepository;

import java.util.Date;
import java.util.List;

/**
 * Created by Rafal on 2017-08-31.
 */
public class TwitterRepositoryImpl implements TwitterRepository {


        private SessionFactory sessionFactory;


        public TwitterRepositoryImpl() {
            initRepo();
        }

        private void initRepo() {
            Configuration config = new Configuration().configure();
            config.addAnnotatedClass(TwitterMessage.class);
            ServiceRegistry service = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
            sessionFactory = config.buildSessionFactory(service);
            //test();
        }

        private void test() {
            Session session = sessionFactory.openSession();
            TwitterMessage m = new TwitterMessage("First twitter", new Date(2017,6,3),"Alex Kwachu ");
            session.beginTransaction();
            session.save(m);
            session.getTransaction().commit();
        }

        public List<TwitterMessage> getAllTwitts() {
            Session session = sessionFactory.openSession();
            List<TwitterMessage> twitters = session.createQuery("from TwitterMessage").list();
            return twitters;
        }

        public TwitterMessage persistTwitterMessage(TwitterMessage twitterMessage) {
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            session.save(twitterMessage);
            session.getTransaction().commit();
            return twitterMessage;
        }
        
        @Override
        public TwitterMessage getTweet(long id) {
        // TODO Auto-generated method stub
        	Session session = sessionFactory.openSession();
        /*	TwitterMessage twitterMessage = (TwitterMessage)session.
        			load(TwitterMessage.class, id);*/
        	TwitterMessage twitterMessage = (TwitterMessage)session.get(TwitterMessage.class, id);
        	return twitterMessage;
        }
    }



