package cesur.examen.domain.car;

import cesur.examen.common.DAO;
import cesur.examen.common.HibernateUtil;
import lombok.extern.java.Log;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:Naomi Camuña González
 * Fecha:11-12-2023
 */

@Log
public class CarDAO implements DAO<Car> {
    @Override
    public Car save(Car car) {

        /* Implement method here */
        try (Session s = HibernateUtil.getSessionFactory().openSession()) {
            Transaction t = s.beginTransaction();
            s.persist(car);
            t.commit();
            return car;
        }
    }

    @Override
    public Car update(Car car) {
        return null;
    }

    @Override
    public boolean remove(Car car) {
        return false;
    }

    @Override
    public Car get(Long id) {
        return null;
    }

    @Override
    public List<Car> getAll() {
        return null;
    }

    public List<Car> getAllByManufacturer(String manufacturer){
        var out = new ArrayList<Car>();


        /* Implement method here */
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "FROM Car WHERE manufacturer = :manufacturer";
            Query<Car> query = session.createQuery(hql, Car.class);
            query.setParameter("manufacturer", manufacturer);

            out = (ArrayList<Car>) query.getResultList();
        } catch (Exception e) {
            System.err.println("Error al obtener autos por fabricante: " + e.getMessage());
            throw new RuntimeException("Error al obtener autos por fabricante", e);
        }
        return out;
    }



}
