package org.srv.contentadm.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name="videos")
public class Video {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long  id;

    private byte[] content;
    private Boolean moderated;
}
