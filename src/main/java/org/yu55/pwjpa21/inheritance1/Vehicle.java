package org.yu55.pwjpa21.inheritance1;

import javax.persistence.*;

/*
@Inheritance strategy by default is SINGLE_TABLE. All attributes from entities hierarchy are mapped to ONE table in
database. This table also has a discriminator column (DTYPE) for persistence provider to know how to map each row into
which entity. Columns of child entities must be nullable. Changing structure of whatever entity ends up with changing
this one common table. It works well for simple and stable entities hierarchy.
Strategy JOINED creates separate table for each entity. Each tables adds only columns from corresponding entity (not
from higher entities in hierarchy). Subclass table has to be joined with the root table. Deeper hierarchy - more joins.
Strategy TABLE_PER_CLASS also has separate table for each entity, but each table has columns from according entity and
all entities above in hierarchy (denormalized database model). All tables must have matching id column. There is no
DTYPE column as there are no shared tables or columns.
For best performance and need to use polymorphic queries and relationships, the single table strategy should be chosen.
But it's not possible to use null constraints on subclass attributes which increase the risk of data inconsistencies.
For data consistency more important than performance and you polymorphic queries and relationships, the joined strategy
is probably best option.
When polymorphic queries or relationships aren't needed, the table per class strategy is most likely the best fit. It
allows to use constraints to ensure data consistency and provides an option of polymorphic queries. But polymorphic
queries are very complex for this table structure and should be avoided.
 */
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
/*
It's possible to change discriminator column name to arbitrary name via @DiscriminatorColumn. Additionally it's
possible to set type of discriminator column but then each entity in hierarchy must define its @DiscriminatorValue.
 */
@DiscriminatorColumn(name = "DISCRI", discriminatorType = DiscriminatorType.CHAR)
@DiscriminatorValue(value = "V")
class Vehicle {

    private Long id;
    private String name;

    @Id
    @GeneratedValue
    Long getId() {
        return id;
    }

    void setId(Long id) {
        this.id = id;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
