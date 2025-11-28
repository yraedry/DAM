package concesionario.service;

import concesionario.dto.Coche;
import concesionario.dto.Coche.Estado;
import concesionario.dto.Cliente;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

import java.util.List;

public class ConcesionarioService {
    private final SessionFactory sessionFactory;

    // Inicializa la SessionFactory
    public ConcesionarioService() {
        try {
            this.sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Exception e) {
            System.err.println("Error al inicializar Hibernate: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

    public void altaCoche(Coche coche) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.persist(coche);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Coche> getCochesDisponibles() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Coche> cq = cb.createQuery(Coche.class);
            Root<Coche> root = cq.from(Coche.class);

            cq.select(root).where(cb.equal(root.get("estado"), Estado.DISPONIBLE));

            return session.createQuery(cq).getResultList();
        }
    }

    public List<Coche> getCochesVendidos() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Coche> cq = cb.createQuery(Coche.class);
            Root<Coche> root = cq.from(Coche.class);

            // Filtrar por estado VENDIDO
            cq.select(root).where(cb.equal(root.get("estado"), Estado.VENDIDO));

            return session.createQuery(cq).getResultList();
        }
    }

    private Cliente getOrCreateCliente(Session session, String dni, String nombre) {
        // Buscar existente
        Cliente cliente = session.bySimpleNaturalId(Cliente.class).load(dni);

        if (cliente == null) {
            cliente = new Cliente(null, dni, nombre);
            session.persist(cliente);
        }
        return cliente;
    }

    public boolean venderCoche(Long cocheId, String dniCliente, String nombreCliente) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Coche coche = session.find(Coche.class, cocheId);

            if (coche == null || coche.getEstado() == Estado.VENDIDO) {
                session.getTransaction().rollback();
                return false;
            }
            Cliente cliente = getOrCreateCliente(session, dniCliente, nombreCliente);

            coche.setEstado(Estado.VENDIDO);
            coche.setCliente(cliente);
            session.merge(coche);

            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}