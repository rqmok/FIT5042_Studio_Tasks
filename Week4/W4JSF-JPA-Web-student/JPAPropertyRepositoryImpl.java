package fit5042.tutex.repository;

import fit5042.tutex.repository.entities.ContactPerson;
import fit5042.tutex.repository.entities.Property;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Eddie Leung
 */
@Stateless
public class JPAPropertyRepositoryImpl implements PropertyRepository {

    // Modified: Use a container managed entity manager.
    @PersistenceContext(unitName = "W4ExeStudent-ejbPU")
    private EntityManager entityManager;

    @Override
    public void addProperty(Property property) throws Exception {
        List<Property> properties = entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
        property.setPropertyId(properties.get(0).getPropertyId() + 1);
        entityManager.persist(property);
    }

    @Override
    public Property searchPropertyById(int id) throws Exception {
        Property property = entityManager.find(Property.class, id);
        property.getTags();
        return property;
    }

    @Override
    public List<Property> getAllProperties() throws Exception {
        return entityManager.createNamedQuery(Property.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public Set<Property> searchPropertyByContactPerson(ContactPerson contactPerson) throws Exception {
        contactPerson = entityManager.find(ContactPerson.class, contactPerson.getConactPersonId());
        contactPerson.getProperties().size();
        entityManager.refresh(contactPerson);

        return contactPerson.getProperties();
    }

    @Override
    public List<ContactPerson> getAllContactPeople() throws Exception {
        return entityManager.createNamedQuery(ContactPerson.GET_ALL_QUERY_NAME).getResultList();
    }

    @Override
    public void removeProperty(int propertyId) throws Exception {
        // Modified: Remove the property using the given property id.
        entityManager.remove(this.searchPropertyById(propertyId));
    }

    @Override
    public void editProperty(Property property) throws Exception {
        try {
            entityManager.merge(property);
        } catch (Exception ex) {
            // Modified: Use logger to log the exception message.
            Logger.getLogger(this.getClass().getName()).log(Level.WARNING, ex.getMessage());
        }
    }

    @Override
    public List<Property> searchPropertyByBudget(double budget) throws Exception {
        // Modified: Create a query to get properties for a given budget using Critera API.
        CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
        CriteriaQuery query = builder.createQuery(Property.class);
        Root<Property> p = query.from(Property.class);

        query.select(p).where(builder.le(p.get("price").as(Double.class), budget));

        return entityManager.createQuery(query).getResultList();
    }
}
