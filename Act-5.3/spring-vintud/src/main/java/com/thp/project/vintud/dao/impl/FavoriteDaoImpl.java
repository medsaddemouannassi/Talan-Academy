package com.thp.project.vintud.dao.impl;

import com.thp.project.vintud.configuration.VintudConfiguration;
import com.thp.project.vintud.dao.FavoriteDao;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.Favorite;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FavoriteDaoImpl implements FavoriteDao {
    @Autowired
    VintudFactory vintudFactory;

    // Create favorite announcement
    @Override
    public void createFavorite(int announcementId, int userId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        Date date = new Date(System.currentTimeMillis());
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
        Favorite favorite = applicationContext.getBean(Favorite.class);
        AnnouncementImpl announcement = applicationContext.getBean(AnnouncementImpl.class);
        announcement.setAnnouncement_id(announcementId);
        favorite.setAnnouncement_id(announcement);
        UserImpl user = applicationContext.getBean(UserImpl.class);
        user.setUser_id(userId);
        favorite.setUser(user);
        favorite.setDateAddFav(date);
        try {
            transaction.begin();
            entityManager.persist(favorite);
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    // Delete favorite announcement
    @Override
    public void deleteFavorite(int announcementId, int userId) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            String query = "FROM Favorite FAV WHERE FAV.announcement_id = :idAnn AND FAV.user = :idUser";
            TypedQuery<Favorite> tq = entityManager.createQuery(query, Favorite.class);
            ApplicationContext applicationContext = new AnnotationConfigApplicationContext(VintudConfiguration.class);
            AnnouncementImpl announcement = applicationContext.getBean(AnnouncementImpl.class);
            announcement.setAnnouncement_id(announcementId);
            UserImpl user = applicationContext.getBean(UserImpl.class);
            user.setUser_id(userId);
            tq.setParameter("idAnn", announcement);
            tq.setParameter("idUser", user);
            try {
                Favorite favorite = tq.getSingleResult();
                entityManager.remove(favorite);
            } catch (Exception e) {
                e.printStackTrace();
            }
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    // Search favorite announcement
    @Override
    public Favorite searchFavorite(AnnouncementImpl announcement) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT id FROM announcement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, announcement.getAnnouncement_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "SELECT * FROM favorites WHERE announcement_id = ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
                    preparedStatement1.setInt(1, resultSet.getInt("id"));
                    resultSet = preparedStatement1.executeQuery();
                    if (resultSet.next()) {
                        Favorite favorite = new Favorite();
                        favorite.setFavorite_id(resultSet.getInt("id"));
                        // favorite.setAnnouncement_id(resultSet.getInt("announcement_id"));
//                        favorite.setUser_id(resultSet.getInt("user_id"));
                        favorite.setDateAddFav(resultSet.getDate("date_add_favorite"));
                        System.out.println(favorite);
                        return favorite;
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    // Update favorite announcement
    @Override
    public void updateFavorite(Favorite favorite) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "SELECT id FROM favorites WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, favorite.getFavorite_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                query = "UPDATE favorites SET announcement_id = ?, user_id = ? WHERE id= ?";
                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
//                    preparedStatement1.setInt(1, favorite.getAnnouncement_id());
//                    preparedStatement1.setInt(2, favorite.getUser_id());
                    preparedStatement1.setInt(3, resultSet.getInt("id"));
                    preparedStatement1.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Display favorite announcements by user
    @Override
    public List<AnnouncementImpl> disFavByUser(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            List<Favorite> favorite_announcements = entityManager.find(UserImpl.class, id).getFavorite_announcements();
            List<AnnouncementImpl> announcements = entityManager.createQuery("from AnnouncementImpl", AnnouncementImpl.class).getResultList();
            List<AnnouncementImpl> favAnn = new ArrayList<>();
            for (int i = 0; i < announcements.size(); i++) {
                for (int j = 0; j < favorite_announcements.size(); j++) {
                    if (announcements.get(i).getAnnouncement_id() == favorite_announcements.get(j).getAnnouncement_id().getAnnouncement_id()) {
                        favAnn.add(announcements.get(i));
                    }
                }
            }

            transaction.commit();
            announcements.forEach(System.out::println);
            return favAnn;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }
}
