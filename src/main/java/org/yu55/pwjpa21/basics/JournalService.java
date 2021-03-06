package org.yu55.pwjpa21.basics;

import javax.persistence.EntityManager;
import java.util.Date;

class JournalService {

    private EntityManager entityManager;

    JournalService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    /*
    Entity life cycle: new, managed, detached, removed.
    - A new entity instance has no persistent identity, and is not yet associated with a persistence context.
    - A managed entity instance is an instance with a persistent identity that is currently associated with a persistence
    context.
    - A detached entity instance is an instance with a persistent identity that is not (or no longer) associated with
    a persistence context.
    - A removed entity instance is an instance with a persistent identity, associated with a persistence context, that
    will be removed from the database upon transaction commit.
    Use of the cascade annotation element may be used to propagate the effect of an operation to associated entities.
     */

    Journal createJournal(Long id, String title, Integer numberOfPages, Date releaseDate, Genre genre) {
        /*
        Entity is created but it's not managed nor persistent yet.
         */
        Journal journal = new Journal(id, title, numberOfPages, releaseDate, genre, null);
        /*
        A new entity instance becomes both managed and persistent by invoking the persist method on it or by cascading
        the persist operation.

        The semantics of the persist operation, applied to an entity X are as follows:
        - If X is a new entity, it becomes managed. The entity X will be entered into the database at or before
        transaction commit or as a result of the flush operation.
        - If X is a preexisting managed entity, it is ignored by the persist operation. However, the persist operation
        is cascaded to entities referenced by X, if the relationships from X to these other entities are annotated with
        the cascade=PERSIST or cascade=ALL annotation element value or specified with the equivalent XML descriptor
        element.
        - If X is a removed entity, it becomes managed.
        - If X is a detached object, the EntityExistsException may be thrown when the persist operation is invoked, or
        the EntityExistsException or another PersistenceException may be thrown at flush or commit time.
        - For all entities Y referenced by a relationship from X, if the relationship to Y has been annotated with the
        cascade element value cascade=PERSIST or cascade=ALL, the persist operation is applied to Y.
         */
        entityManager.persist(journal);
        return journal;
    }

    Journal findJournal(Long id) {
        return entityManager.find(Journal.class, id);
    }

    Journal updateTitle(Long id, String newTitle) {
        Journal journal = entityManager.find(Journal.class, id);
        if (journal != null) {
            journal.setTitle(newTitle);
        }
        return journal;
    }

    void removeJournal(Long id) {
        /*
        A managed entity instance becomes removed by invoking the remove method on it or by cascading the remove
        operation.
        The semantics of the remove operation, applied to an entity X are as follows:
        - If X is a new entity, it is ignored by the remove operation. However, the remove operation is cascaded to
        entities referenced by X, if the relationship from X to these other entities is annotated with the
        cascade=REMOVE or cascade=ALL annotation element value.
        - If X is a managed entity, the remove operation causes it to become removed. The remove operation is cascaded
        to entities referenced by X, if the relationships from X to these other entities is annotated with the
        cascade=REMOVE or cascade=ALL annotation element value.
        - If X is a detached entity, an IllegalArgumentException will be thrown by the remove operation (or the
        transaction commit will fail).
        - If X is a removed entity, it is ignored by the remove operation.
        - A removed entity X will be removed from the database at or before transaction commit or as a result of the
        flush operation.
        After an entity has been removed, its state (except for generated state) will be that of the entity at the point
        at which the remove operation was called.
         */
        Journal journal = entityManager.find(Journal.class, id);
        if (journal != null) {
            entityManager.remove(journal);
        }
    }
}
