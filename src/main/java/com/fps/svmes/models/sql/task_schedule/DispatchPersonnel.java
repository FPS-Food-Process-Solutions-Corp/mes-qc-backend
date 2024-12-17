package com.fps.svmes.models.sql.task_schedule;

import com.fps.svmes.models.sql.User;
import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;

@Entity
@Table(name = "dispatch_personnel", schema = "quality_management")
@Data
@NoArgsConstructor
public class DispatchPersonnel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dispatch_id", nullable = false)
    private Dispatch dispatch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;


    public DispatchPersonnel(Long id, Dispatch dispatch, Integer userId) {
        this.id = id;
        this.dispatch = dispatch;
        this.user = new User();
        this.user.setId(userId);
    }

    public DispatchPersonnel( Dispatch dispatch, Integer userId) {
        this.dispatch = dispatch;
        this.user = new User();
        this.user.setId(userId);
    }

    @Override
    public String toString() {
        return "DispatchPersonnel{" +
                "id=" + id +
                ", userId=" + (user != null ? user.getId() : "null") +
                '}';
    }


}
