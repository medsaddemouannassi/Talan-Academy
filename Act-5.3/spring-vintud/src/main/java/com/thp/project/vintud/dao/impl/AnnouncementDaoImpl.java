package com.thp.project.vintud.dao.impl;

import com.thp.project.vintud.Status;
import com.thp.project.vintud.dao.AnnouncementDao;
import com.thp.project.vintud.dao.factory.VintudFactory;
import com.thp.project.vintud.entity.impl.AnnouncementImpl;
import com.thp.project.vintud.entity.impl.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AnnouncementDaoImpl implements AnnouncementDao {
    @Autowired
    VintudFactory vintudFactory;

    // Display all announcements
    @Override
    public List<AnnouncementImpl> displayAnnouncements() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            List<AnnouncementImpl> announcements = entityManager.createQuery("from AnnouncementImpl", AnnouncementImpl.class).getResultList();
            transaction.commit();
            return announcements;
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    // Create announcement
    @Override
    public String createAnnouncement(AnnouncementImpl announcement) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(announcement);
            transaction.commit();
            return "Votre annonce a bien été enregistrée";
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    // Update announcement
    @Override
    public String updateAnnouncement(AnnouncementImpl announcement) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.merge(announcement);
            transaction.commit();
            return "Votre annonce a bien été modifiée";
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    // Delete announcement
    @Override
    public void deleteAnnouncement(AnnouncementImpl announcement) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.remove(entityManager.contains(announcement) ? announcement : entityManager.merge(announcement));
            transaction.commit();
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
    }

    // Search announcement by name, category and/or price
    @Override
    public AnnouncementImpl searchAnnouncement(String title, Integer category, Double price) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            CriteriaBuilder cb = entityManager.getCriteriaBuilder();
            CriteriaQuery<AnnouncementImpl> cq = cb.createQuery(AnnouncementImpl.class);

            Root<AnnouncementImpl> announcementRoot = cq.from(AnnouncementImpl.class);
            Predicate announcementPrice = cb.equal(announcementRoot.get("price"), price);
            Predicate announcementTitle = cb.like(announcementRoot.get("title"), "%" + title + "%");
            Predicate announcementCategory = cb.like(announcementRoot.get("category_id"), "%" + category + "%");
            cq.where(announcementPrice, announcementTitle, announcementCategory);

            TypedQuery<AnnouncementImpl> query = entityManager.createQuery(cq);
            transaction.commit();
            return query.getResultList().get(0);
        } finally {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            entityManager.close();
            entityManagerFactory.close();
        }
//        String query = "SELECT * FROM announcement WHERE (title LIKE ? AND category_id = ? AND price = ?) OR (title LIKE ? AND category_id = ?) OR price = ?";
//        title = (title == null) ? "" : title;
//        category = (category == null) ? 0 : category;
//        price = (price == null) ? 0 : price;
//        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
//            preparedStatement.setString(1, "%" + title.toLowerCase() + "%");
//            preparedStatement.setInt(2, category);
//            preparedStatement.setDouble(3, price);
//            preparedStatement.setString(4, "%" + title.toLowerCase() + "%");
//            preparedStatement.setInt(5, category);
//            preparedStatement.setDouble(6, price);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            if (resultSet.next()) {
//                AnnouncementImpl announcement = new AnnouncementImpl();
//                announcement.setTitle(resultSet.getString("title").replaceAll("  ", ""));
//                announcement.setDescription(resultSet.getString("description").replaceAll("  ", ""));
////                announcement.setCategoryId(resultSet.getInt("category_id"));
//                announcement.setPrice(resultSet.getInt("price"));
//                announcement.setPhoto(resultSet.getBlob("picture"));
//                announcement.setPublication_date(resultSet.getDate("publication_date"));
//                Status status = resultSet.getString("status") == null ? null : Status.valueOf(resultSet.getString("status"));
//                announcement.setStatus(status);
//                announcement.setAvailable(resultSet.getBoolean("is_available"));
//                announcement.setView_number(resultSet.getInt("view_number"));
//                announcement.setLocalisation(resultSet.getString("localisation").replaceAll("  ", ""));
////                announcement.setUserId(resultSet.getInt("user_id"));
//                System.out.println(announcement);
//                return announcement;
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return null;
    }

    // Filter announcements by price
    @Override
    public List<AnnouncementImpl> filterAnnouncementByPrice(Double minPrice, Double maxPrice) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM announcement WHERE price >= ? AND price <= ? ORDER BY price";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2, maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnnouncementImpl> announcements = new ArrayList<>();
            while (resultSet.next()) {
                AnnouncementImpl announcement = new AnnouncementImpl();
                announcement.setTitle(resultSet.getString("title").replaceAll("  ", ""));
                announcement.setDescription(resultSet.getString("description").replaceAll("  ", ""));
//                announcement.setCategoryId(resultSet.getInt("category_id"));
                announcement.setPrice(resultSet.getInt("price"));
                announcement.setPhoto(resultSet.getBlob("picture"));
                announcement.setPublication_date(resultSet.getDate("publication_date"));
                Status status = resultSet.getString("status") == null ? null : Status.valueOf(resultSet.getString("status"));
                announcement.setStatus(status);
                announcement.setAvailable(resultSet.getBoolean("is_available"));
                announcement.setView_number(resultSet.getInt("view_number"));
                announcement.setLocalisation(resultSet.getString("localisation").replaceAll("  ", ""));
//                announcement.setUserId(resultSet.getInt("user_id"));
                announcements.add(announcement);
            }
            return announcements;
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

    // Filter announcements by localisation
    @Override
    public List<AnnouncementImpl> filterAnnouncementByLocalisation(String localisation) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return null;
        }
        String query = "SELECT * FROM announcement WHERE localisation LIKE ? ORDER BY price";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, "%" + localisation.toLowerCase() + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AnnouncementImpl> announcements = new ArrayList<>();
            while (resultSet.next()) {
                AnnouncementImpl announcement = new AnnouncementImpl();
                announcement.setTitle(resultSet.getString("title").replaceAll("  ", ""));
                announcement.setDescription(resultSet.getString("description").replaceAll("  ", ""));
//                announcement.setCategoryId(resultSet.getInt("category_id"));
                announcement.setPrice(resultSet.getInt("price"));
                announcement.setPhoto(resultSet.getBlob("picture"));
                announcement.setPublication_date(resultSet.getDate("publication_date"));
                Status status = resultSet.getString("status") == null ? null : Status.valueOf(resultSet.getString("status"));
                announcement.setStatus(status);
                announcement.setAvailable(resultSet.getBoolean("is_available"));
                announcement.setView_number(resultSet.getInt("view_number"));
                announcement.setLocalisation(resultSet.getString("localisation").replaceAll("  ", ""));
//                announcement.setUserId(resultSet.getInt("user_id"));
                announcements.add(announcement);
            }
            return announcements;
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

    // Send request to reserve article
    @Override
    public void SendReqReserveArticle(int id) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return;
        }
        String query = "UPDATE announcement SET status = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, Status.ARTICLE_REQUESTED, java.sql.Types.OTHER);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
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

    // Display view number
    @Override
    public int displayViewNumber(int id) {
        Connection connection = vintudFactory.getConnectionManager();
        if (connection == null) {
            return 0;
        }
        String query = "SELECT view_number FROM announcement WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int view_number = resultSet.getInt("view_number");
                return view_number;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    // Display posted announcements by user
    @Override
    public List<AnnouncementImpl> disAnnByUser(int id) {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("vintud");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    EntityTransaction transaction = entityManager.getTransaction();
    try {
        transaction.begin();
        List<AnnouncementImpl> announcements = entityManager.find(UserImpl.class, id).getPosted_announcements();
        transaction.commit();
        announcements.forEach(System.out::println);
        return announcements;
    } finally {
        if (transaction.isActive()) {
            transaction.rollback();
        }
        entityManager.close();
        entityManagerFactory.close();
    }



//    String query = "SELECT posted_announcements FROM users WHERE id = ?";
//        try(
//    PreparedStatement preparedStatement = connection.prepareStatement(query))
//
//    {
//        preparedStatement.setInt(1, id);
//        ResultSet resultSet = preparedStatement.executeQuery();
//        if (resultSet.next() && resultSet.getArray("posted_announcements") != null) {
//            Integer[] array = (Integer[]) resultSet.getArray("posted_announcements").getArray();
//            List<AnnouncementImpl> announcements = new ArrayList<>();
//            for (Integer elem : array) {
//                query = "SELECT * FROM announcement WHERE id = ?";
//                try (PreparedStatement preparedStatement1 = connection.prepareStatement(query)) {
//                    preparedStatement1.setInt(1, elem);
//                    resultSet = preparedStatement1.executeQuery();
//                    if (!resultSet.next()) {
//                        return null;
//                    } else {
//                        do {
//                            AnnouncementImpl announcement = new AnnouncementImpl();
//                            announcement.setAnnouncement_id(resultSet.getInt("id"));
//                            announcement.setTitle(resultSet.getString("title").replaceAll("  ", ""));
//                            announcement.setDescription(resultSet.getString("description").replaceAll("  ", ""));
////                                announcement.setCategoryId(resultSet.getInt("category_id"));
//                            announcement.setPrice(resultSet.getInt("price"));
//                            announcement.setPhoto(resultSet.getBlob("picture"));
//                            announcement.setPublication_date(resultSet.getDate("publication_date"));
//                            Status status = resultSet.getString("status") == null ? null : Status.valueOf(resultSet.getString("status"));
//                            announcement.setStatus(status);
//                            announcement.setAvailable(resultSet.getBoolean("is_available"));
//                            announcement.setView_number(resultSet.getInt("view_number"));
//                            announcement.setLocalisation(resultSet.getString("localisation").replaceAll("  ", ""));
////                                announcement.setUserId(resultSet.getInt("user_id"));
//                            announcements.add(announcement);
//                        } while (resultSet.next());
//                    }
//                }
//            }
//            return announcements;
//        }
//    } catch(
//    SQLException e)
//
//    {
//        e.printStackTrace();
//    }
//        return null;
}
}
