package cesur.examen.domain.client;

import cesur.examen.common.HibernateUtil;
import cesur.examen.domain.car.Car;
import cesur.examen.domain.car.CarDAO;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * EXAMEN DE ACCESO A DATOS
 * Diciembre 2023
 *
 * Nombre del alumno:Naomi Camuña González
 * Fecha:11-12-2023
 */

public class ClientService {

    /**
     * Return a List of Client entities that have one or more cars of the given manufacturer.
     * If a client has more than one car of the manufacturer, it only appears once in
     * the list (similar to a Set). Tip: start querying to Car entities...
     *
     * @param manufacturer
     * @return the list of clients
     */
    public static List<Client> hasManufacturer(String manufacturer){
        var out= new ArrayList<Client>(0);

        /* Implement method here */
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            String hql = "SELECT DISTINCT c FROM Client c JOIN FETCH c.cars car WHERE car.manufacturer = :manufacturer";
            Query<Client> query = session.createQuery(hql, Client.class);
            query.setParameter("manufacturer", manufacturer);

            out = (ArrayList<Client>) query.getResultList();
        } catch (Exception e) {
            System.err.println("Error al obtener clientes por fabricante: " + e.getMessage());
            throw new RuntimeException("Error al obtener clientes por fabricante", e);
        }
        return out;
    }
}
