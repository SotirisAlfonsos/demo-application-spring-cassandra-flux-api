package nl.zwennesm.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.List;

@Table("Product")
public class Product {

    @PrimaryKey
    private String sku;
    private List<Long> recommendations;

    public Product() {}

    @JsonCreator
    public Product(@JsonProperty("sku") String sku, @JsonProperty("recommendations") List<Long> recs) {
        this.sku = sku;
        this.recommendations = recs;
    }

    @Override
    public String toString() {
        return String.format("Product[sku=%s, recommendations=%s]", this.sku, this.recommendations);
    }
}
