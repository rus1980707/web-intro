package web.intro.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name = "books")
@SQLDelete(sql = "UPDATE book SET deleted = true WHERE id=?")
@Where(clause = "deleted=false")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String author;
	private String isbn;
	private BigDecimal price;
	private String description;
	private String coverImage;

	@Column(nullable = false)
	private boolean deleted = false;
}
